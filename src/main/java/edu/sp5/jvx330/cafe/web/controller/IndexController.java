package edu.sp5.jvx330.cafe.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.category.item.salesTotalPrice.domain.SalesTotalPrice;

import edu.sp5.jvx330.cafe.menu.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.menu.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.menu.command.OrderItemsCommand;
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
	
	@GetMapping("main/index")
	public ModelAndView indexForm() {
		
		ModelAndView mav = new ModelAndView();
		//카테고리, 아이템 리스트 맵 사용
		Map<Category, List<Item>> ciMap = new HashMap<Category, List<Item>>();
		//카테고리 전체 조회
		List<Category> category_list = categoryServiceImpl.findAllCategorys();
		for(Category category : category_list) {
			//카테고리 마다의 아이템 리스트 ciMap에 추가
			ciMap.put(category, itemSerivceImpl.findItemsByCategory(category));
		}
		
		System.out.println("<key 출력>(index) : "+ciMap.keySet());
	
		mav.addObject("ciMap", ciMap);
		mav.setViewName("main/index");
		
		return mav;
	}
	
	@PostMapping("main/index")
	public String index(OrderContainer orderContainer) {
		System.out.println("index(post) 판매내역 : "+orderContainer);

		return "/membership/login_user";
	}
	/*public String index(@ModelAttribute OrderItemsCommand orderItemsCommand, 
			@ModelAttribute SalesTotalPrice salesTotalPrice) {
		System.out.println("index(post) 판매내역 : "+orderItemsCommand);
		System.out.println("stp : "+salesTotalPrice);

		return "/jvx330/membership/login_user";
	}*/
}