package edu.sp5.jvx330.cafe.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.sales.business.impl.SalesHistoryServiceImpl;
import edu.sp5.jvx330.cafe.sales.business.impl.SalesTotalPriceServiceImpl;

@Controller
public class DeleteOrderNumSalesHistoryController {

	@Autowired
	SalesHistoryServiceImpl salesHistoryService;
	@Autowired
	SalesTotalPriceServiceImpl salesTotalPriceService;
	
	@PostMapping("/sales/deleteOrderNumSalesHistory")
	public String deleteOrderNumSalesHistoryPost(String orderNum) {
		Long orderNumber = Long.parseLong(orderNum);

		salesHistoryService.deleteSalesHistoryByOrderNum(orderNumber);
		salesTotalPriceService.deleteSalesTotalPrice(orderNumber);
		
		return "redirect:/main/index";
	}
	
	@GetMapping("/sales/deleteOrderNumSalesHistory")
	public String deleteOrderNumSalesHistoryGet(String orderNum) {
		Long orderNumber = Long.parseLong(orderNum);

		salesHistoryService.deleteSalesHistoryByOrderNum(orderNumber);
		salesTotalPriceService.deleteSalesTotalPrice(orderNumber);
		
		return "redirect:/main/index";
	}
}
