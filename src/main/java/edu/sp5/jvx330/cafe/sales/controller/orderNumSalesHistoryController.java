package edu.sp5.jvx330.cafe.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.sales.business.impl.SalesHistoryServiceImpl;
import edu.sp5.jvx330.cafe.sales.business.impl.SalesTotalPriceServiceImpl;
import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

@Controller
public class orderNumSalesHistoryController {

	@Autowired
	private SalesHistoryServiceImpl salesHistoryService;
	@Autowired
	private SalesTotalPriceServiceImpl salesTotalPriceService;
	
	
	@GetMapping("/sales/orderNumSalesHistory")
	public String orderNumSalesHistoryGet() {
		return "sales/orderNum_salesHistory";
	}
	
	
	
	@PostMapping("/sales/orderNumSalesHistory")
	public ModelAndView orderNumSalesHistoryPost(@RequestParam("orderNum") String orderNum) {
		Long orderNumber = Long.parseLong(orderNum);
		ModelAndView mav = new ModelAndView();
		Integer totalNumOfPrice = 0;
		
		List<SalesHistory> salesHistory_list = salesHistoryService.findSalesHistoryByOrderNum(orderNumber);
		if(salesHistory_list != null) {
			for(SalesHistory salesHistory : salesHistory_list) {
				String itemName = salesHistory.getItem().getItemName();
				String category = salesHistory.getItem().getCategory().getCategoryName();
				totalNumOfPrice += salesHistory.getNumOfSales();
				mav.addObject(itemName);
				mav.addObject(category);
				mav.addObject(totalNumOfPrice);
			}		
		}
		mav.addObject("salesHistory_list", salesHistory_list); 
		
		SalesTotalPrice salesTotalPrice = salesTotalPriceService.findSTPByOrderNum(orderNumber);
		mav.addObject("salesTotalPrice", salesTotalPrice); 
		
		mav.setViewName("sales/today_salesHistory");  
		return mav; 	
		
	}
	
	
	
}
