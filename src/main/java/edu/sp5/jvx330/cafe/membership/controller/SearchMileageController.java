package edu.sp5.jvx330.cafe.membership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.sp5.jvx330.cafe.membership.business.impl.MileageHistoryServiceImpl;
import edu.sp5.jvx330.cafe.web.container.OrderContainer;

@Controller("searchMileageController")
public class SearchMileageController {
	@Autowired
	private MileageHistoryServiceImpl mileageHistoryServiceImpl;
	
	@PostMapping("/membership/searchMileage")
	public String SearchMileageGet(@SessionAttribute("orderContainer") OrderContainer orderContainer ,String select_mileage) {
		System.out.println(select_mileage);
		System.out.println("searchMileageController : " + orderContainer);
		if(select_mileage.equals("add_mileage")) {
			//mileageHistoryServiceImpl.addMileageHistory(null, null);
		} else if(select_mileage.equals("use_mileage")) {
			return "redirect:/main/index";
			//get 방식으로 이동
		}
		return "/membership/search_mileage";
	}
}
