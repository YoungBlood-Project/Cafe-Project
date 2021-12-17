package edu.sp5.jvx330.cafe.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.membership.domain.MileageHistory;
import edu.sp5.jvx330.cafe.menu.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.menu.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.menu.domain.Category;
import edu.sp5.jvx330.cafe.menu.domain.Item;
import edu.sp5.jvx330.cafe.web.container.OrderContainer;

//@SessionAttributes(names = {"salesTotalPrice", "orderItemsCommand"}) //안되면 values로 바꾸기
@SessionAttributes("orderContainer")
@Controller("controller.indexController")
public class IndexController {
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	@Autowired
	private ItemSerivceImpl itemSerivceImpl;
	
	@GetMapping("/main/index")
	public ModelAndView indexForm(boolean cancel, SessionStatus sessionStatus) {

		ModelAndView mav = new ModelAndView();
		//카테고리, 아이템 리스트 맵 사용
		Map<Category, List<Item>> ciMap = new HashMap<Category, List<Item>>();
		
		//카테고리 전체 조회
		List<Category> category_list = categoryServiceImpl.findAllCategorys();

		for(Category category : category_list) {
			if(!category.getCategoryName().equals("deletedMenu")) {
				ciMap.put(category, itemSerivceImpl.findItemsByCategory(category));
			}
			//카테고리 마다의 아이템 리스트 ciMap에 추가
			
		}
		
		//System.out.println("<key 출력>(index) : "+ciMap.keySet());

		mav.addObject("ciMap", ciMap);
		mav.addObject("index_link", "index");
		mav.addObject("placehold","placehold");
		mav.setViewName("main/index");
		
		//System.out.println(cancel);
		if(cancel==true) {//취소 버튼 눌렀을 때
			sessionStatus.setComplete();
			mav.setViewName("redirect:/main/index");
		}
		
		return mav;
	}
	
	@PostMapping("/main/index")
	public String index(OrderContainer orderContainer) {
		try {
		Integer totalPrice = 
				orderContainer.getSalesTotalPrice().getTotalPrice();
		
			Integer mileage = (int) Math.floor(totalPrice * 0.03);	
			//System.out.println("mileage : "+mileage);
			
			//마일리지 금액 set, orderContainer에 입력
			MileageHistory mileageHistory = new MileageHistory();
			mileageHistory.setMBalance(mileage);
			orderContainer.setMileageHistory(mileageHistory);
			System.out.println("index(post) 판매내역 : "+orderContainer);
			
			return "redirect:/membership/loginUser";
		}
		catch(NullPointerException e) {//아무것도 선택 안하고 결제하기 눌렀을 경우
			return "redirect:/main/index";
		}
	}
	/*public String index(@ModelAttribute OrderItemsCommand orderItemsCommand, 
			@ModelAttribute SalesTotalPrice salesTotalPrice) {
		System.out.println("index(post) 판매내역 : "+orderItemsCommand);
		System.out.println("stp : "+salesTotalPrice);

		return "/jvx330/membership/login_user";
	}*/
}