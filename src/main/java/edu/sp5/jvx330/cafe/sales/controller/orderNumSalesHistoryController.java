package edu.sp5.jvx330.cafe.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.menu.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.menu.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.menu.domain.Item;
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
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private ItemSerivceImpl itemService;
	
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
				Long itemId = salesHistory.getItem().getItemId();
				Item item = itemService.findItemByItemId(itemId);
				String itemName = item.getItemName();	
				String categoryName = categoryService.findCategoryByCategoryId(item.getCategory().getCategoryId());
					
				System.out.println(itemId+itemName+categoryName);

				totalNumOfPrice += salesHistory.getNumOfSales();
				mav.addObject(itemName);
				mav.addObject(categoryName);
				mav.addObject(totalNumOfPrice);
			}		
		}
		mav.addObject("salesHistory_list", salesHistory_list); 
		
		SalesTotalPrice salesTotalPrice = salesTotalPriceService.findSTPByOrderNum(orderNumber);
		mav.addObject("salesTotalPrice", salesTotalPrice); 
		
		mav.setViewName("sales/orderNum_salesHistory");  
		return mav; 	
		
	}
	
	
	
}
