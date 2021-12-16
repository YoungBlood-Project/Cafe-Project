package edu.sp5.jvx330.cafe.sales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("MYearSalesHistoryController")
public class MYearSalesHistoryController {
	
	@GetMapping("/sales/mYearSalesHistory")
	public ModelAndView mYearSalesHistory() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sales/m_year_salesHistory");
		
		return mav;
	}
}
