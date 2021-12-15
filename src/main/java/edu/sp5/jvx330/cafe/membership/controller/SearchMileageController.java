package edu.sp5.jvx330.cafe.membership.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.membership.domain.Customer;
import edu.sp5.jvx330.cafe.membership.domain.MileageHistory;
import edu.sp5.jvx330.cafe.web.container.OrderContainer;

@SessionAttributes("orderContainer")
@Controller("searchMileageController")
public class SearchMileageController {
	//@Autowired
	//private MileageHistoryServiceImpl mileageHistoryServiceImpl;
	
	@PostMapping("/membership/searchMileage")
	public ModelAndView SearchMileageGet(OrderContainer orderContainer 
			,String select_mileage, Integer use_amount) {
		ModelAndView mav = new ModelAndView();
		
		System.out.println(select_mileage);
		System.out.println("searchMileageController : " + orderContainer);
		
		MileageHistory mileageHistory = orderContainer.getMileageHistory();
		
		if(select_mileage.equals("add_mileage")) {//적립
			System.out.println("mileageHistory : "+mileageHistory);
			//mileageHistoryServiceImpl.addMileageHistory(customer, mileageHistory);
			//적립, session의 할인금액은 0
		} else if(select_mileage.equals("use_mileage")) {
			mileageHistory.setMBalance(-use_amount);//사용할 금액
			orderContainer.setMileageHistory(mileageHistory);
			
			//현재 가지고 있는 totalprice - 사용할 마일리지
			Integer reducedPrice = orderContainer.getSalesTotalPrice().getTotalPrice() - use_amount;
			//orderContainer가 가진 salesTotalPrice에 reducedPrice 계산해서 입력
			orderContainer.getSalesTotalPrice().setReducedPrice(reducedPrice);
			
			System.out.println("사용할 금액 : "+use_amount);
		} else {
			System.out.println("searchMileageController 에러 발생");
		}
		
		//post 방식으로 이동
		mav.addObject("use_amount",use_amount);
		//index로 보낸 뒤 submit 했을 때의 링크
		mav.addObject("index_link", "/jvx330/main/payPrice");
		mav.setViewName("main/index");
		return mav;
	}
}
