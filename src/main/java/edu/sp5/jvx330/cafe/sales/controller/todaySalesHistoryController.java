package edu.sp5.jvx330.cafe.sales.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.sales.business.impl.SalesHistoryServiceImpl;
import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;

@Controller
public class todaySalesHistoryController {

	@Autowired
	private SalesHistoryServiceImpl salesHistoryService;
	
	@GetMapping("/sales/todaySalesHistory")
	public ModelAndView todaySalesHistoryGet() {
		List<SalesHistory> salesHistory_list = salesHistoryService.findSalesHistoryByOrderDate(new Date());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("salesHistory_list", salesHistory_list); 
		mav.setViewName("sales/today_salesHistory");  
		return mav; 	
	}
	

	
}
