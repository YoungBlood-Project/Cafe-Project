package edu.sp5.jvx330.cafe.sales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("MMonthSalesHistoryController")
public class MMonthSalesHistoryController {
	
	@GetMapping("/sales/mMonthSalesHistory")
	public ModelAndView mMonthSalesHistory() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sales/m_month_salesHistory");
		
		return mav;
	}
}
