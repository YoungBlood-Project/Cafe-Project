package edu.sp5.jvx330.cafe.membership.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.membership.domain.MileageHistory;
import edu.sp5.jvx330.cafe.web.container.OrderContainer;

@SessionAttributes("orderContainer")
@Controller("controller.searchMileageController")
public class SearchMileageController {
	
	@GetMapping("/membership/searchMileage")
	public ModelAndView SearchMileageGet(OrderContainer orderContainer) {//세션에서 orderContainer 받기? 일단 추가
		ModelAndView mav = new ModelAndView();
		
		System.out.println("SearchMileageController : "+orderContainer.getMileage());
		mav.setViewName("/membership/search_mileage");
		return mav;
	}
	
	@PostMapping("/membership/searchMileage")
	public ModelAndView SearchMileagePost(OrderContainer orderContainer 
			,String select_mileage, Integer use_amount) {	
		
		ModelAndView mav = new ModelAndView();
		
		//System.out.println(select_mileage);
		System.out.println("searchMileageController(post) : " + orderContainer);
		
		MileageHistory mileageHistory = orderContainer.getMileageHistory();
		
		if(select_mileage.equals("add_mileage")) {//적립
			System.out.println("mileageHistory : "+mileageHistory);
			//mileageHistoryServiceImpl.addMileageHistory(customer, mileageHistory);
			//적립, session의 할인금액은 0
		} else if(select_mileage.equals("use_mileage")) {			
			//System.out.println("[SearchMileageController]보유한 마일리지: "+orderContainer.getMileage());
			//보유한 마일리지 조회
			
			//System.out.println("사용할 금액 : "+use_amount);
			//System.out.println("보유한 마일리지 : "+orderContainer.getMileage());
			
			//아무 값도 입력하지 않았을 경우
			if(use_amount==null || use_amount<=0) {
				return addErrorMsg(mav, "사용할 값을 입력해주십시오.");
				
				/*
				mav.addObject("errorMsg", "사용할 값을 입력해주십시오!.");
				mav.setViewName("membership/search_mileage");
				
				return mav;
				*/
			}
			//보유한 마일리지보다 사용금액이 클 경우
			else if(orderContainer.getMileage() < use_amount) {
				return addErrorMsg(mav, "보유한 마일리지가 부족합니다.");
				
				/*
				mav.addObject("errorMsg", "보유한 마일리지가 부족합니다.");
				mav.setViewName("membership/search_mileage");
				
				return mav;
				*/
			}
			else if((use_amount%10) != 0) {
				return addErrorMsg(mav, "10원 이하의 단위는 입력할 수 없습니다.");
				
				/*
				mav.addObject("errorMsg", "10원 이하의 단위는 입력할 수 없습니다.");
				mav.setViewName("membership/search_mileage");
				
				return mav;
				*/
			}
			
			mileageHistory.setMBalance(-use_amount);//사용할 금액
			orderContainer.setMileageHistory(mileageHistory);
			
			//현재 가지고 있는 totalprice - 사용할 마일리지
			Integer reducedPrice = orderContainer.getSalesTotalPrice().getTotalPrice() - use_amount;
			//orderContainer가 가진 salesTotalPrice에 reducedPrice 계산해서 입력
			orderContainer.getSalesTotalPrice().setReducedPrice(reducedPrice);
			
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
	
	public ModelAndView addErrorMsg(ModelAndView mav, String msg) {
		mav.addObject("errorMsg", msg);
		mav.setViewName("membership/search_mileage");
		
		return mav;
	}
}
