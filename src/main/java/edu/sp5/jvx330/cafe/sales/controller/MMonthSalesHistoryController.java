package edu.sp5.jvx330.cafe.sales.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.menu.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.menu.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.menu.domain.Category;
import edu.sp5.jvx330.cafe.menu.domain.Item;
import edu.sp5.jvx330.cafe.sales.business.impl.SalesHistoryServiceImpl;
import edu.sp5.jvx330.cafe.sales.command.DateCommand;
import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;

@Controller("MMonthSalesHistoryController")
public class MMonthSalesHistoryController {
	@Autowired
	private SalesHistoryServiceImpl salesHistoryService;
	@Autowired
	private ItemSerivceImpl itemService;
	@Autowired
	private CategoryServiceImpl categoryService;
	
	@GetMapping("/sales/mMonthSalesHistory")
	public ModelAndView mMonthSalesHistory(DateCommand date) throws ParseException {
		//year = 2021 //(1) month = 3, (2) month = 12
		ModelAndView mav = new ModelAndView();
		String year = date.getYear();
		String month = date.getMonth();
		String str_yyyyMM = year+"-"+month;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		Date yyyyMM = format.parse(str_yyyyMM);
		
		//(1)의 경우
		int nextMonth = Integer.parseInt(month)+1;
		String str_yyyyMM2 = year+"-"+Integer.toString(nextMonth);
		Date yyyyMM2 = format.parse(str_yyyyMM2); 
		
		//(2)의 경우
		if(month == "12") {
			String firstMonth = "1";
			int nextYear = Integer.parseInt(year) + 1;
			str_yyyyMM2 = Integer.toString(nextYear)+"-"+firstMonth;
			yyyyMM2 = format.parse(str_yyyyMM2);
		}
		
		List<SalesHistory> save_sh_list = salesHistoryService.sumNumOfSalesAndSumPaidPriceByMonth(yyyyMM, yyyyMM2);

		List<Item> item_list = itemService.findAllItems();
		List<Long> itemId_list = new ArrayList<>();
		List<String> itemName_list = new ArrayList<>();
		List<String> categoryName_list = new ArrayList<>();
		
		for(Item item: item_list) {
			Long itemId = item.getItemId();
			itemId_list.add(itemId);
			
			String itemName = item.getItemName();
			itemName_list.add(itemName);
			
			String categoryName = categoryService.findCategoryByCategoryId(item.getCategory().getCategoryId()).getCategoryName();
			categoryName_list.add(categoryName);
		}
		
		List<SalesHistory> sh_list = new ArrayList<>();
		for(int i=0; i < itemId_list.size(); i++) {
			Item item = new Item();
			item.setItemId(itemId_list.get(i));
			sh_list.get(i).setItem(item);
		}
		
		//Map<Long, Integer> itemId_numOfSales = new HashMap<>();
		int sumNumOfSales = 0;
		int sumPaidPrice = 0;
		for(SalesHistory sh : save_sh_list) {
			sumNumOfSales += sh.getNumOfSales();
			sumPaidPrice += sh.getPaidPrice();
		}
		
		SalesHistory salesHistory = new SalesHistory();
		
		salesHistory.setNumOfSales(sumNumOfSales);
		salesHistory.setPaidPrice(sumPaidPrice);
		
		//itemId_numOfSales.put(itemId_list.get(0), salesHistory.getNumOfSales());
		
		mav.addObject("date", date);
		mav.setViewName("sales/m_month_salesHistory");
		
		return mav;
	}
}
