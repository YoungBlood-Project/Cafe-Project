package edu.sp5.jvx330.cafe.sales.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.menu.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.menu.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.menu.domain.Item;
import edu.sp5.jvx330.cafe.sales.business.impl.SalesHistoryServiceImpl;
import edu.sp5.jvx330.cafe.sales.business.impl.SalesTotalPriceServiceImpl;
import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

@Controller
public class TodaySalesHistoryController {

	@Autowired
	private SalesHistoryServiceImpl salesHistoryService;
	@Autowired
	private SalesTotalPriceServiceImpl salesTotalPriceService;
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private ItemSerivceImpl itemService;
	
	@GetMapping("/sales/todaySalesHistory")
	public ModelAndView todaySalesHistoryGet() {
		ModelAndView mav = new ModelAndView();
		
		List<String> categoryName_list = new ArrayList<>();
		List<String> itemName_list = new ArrayList<>();
		
		List<SalesHistory> salesHistory_list = salesHistoryService.findSalesHistoryByOrderDate(new Date());
		List<SalesTotalPrice> salesTotalPrice = salesTotalPriceService.findSTPByOrderDate(new Date());
		
		//해당 날짜의 당일 판매내역이 존재하지 않는 경우
		if(salesHistory_list == null) {
			mav.addObject("errorMsg", "당일 판매내역이 존재하지 않습니다");
			mav.setViewName("sales/today_salesHistory");  
			return mav;
		}
		
		for(SalesHistory salesHistory : salesHistory_list) {
			Long itemId = salesHistory.getItem().getItemId();
			Item item = itemService.findItemByItemId(itemId);
			String itemName = item.getItemName();
			itemName_list.add(itemName);
			
			Long orderNum = salesHistory.getOrderNum();
			
			//item으로 categoryId 찾은 후 category 이름 찾기
			String categoryName = categoryService.findCategoryByCategoryId(item.getCategory().getCategoryId()).getCategoryName();
			categoryName_list.add(categoryName);	

			Integer sumNumOfsales = salesHistoryService.sumNumOfSalesByOrderNum(orderNum);
			
			mav.addObject("itemName_list", itemName_list);
			mav.addObject("categoryName_list", categoryName_list);
			mav.addObject("sumNumOfsales", sumNumOfsales);
			
		}
		for(SalesTotalPrice stp : )
		
		
		mav.addObject("salesHistory_list", salesHistory_list); 
		mav.addObject("salesHistory_list", salesHistory_list); 
			
		mav.setViewName("sales/today_salesHistory");  
		return mav; 	
	}
	

	
}
