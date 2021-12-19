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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.menu.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.menu.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.menu.domain.Category;
import edu.sp5.jvx330.cafe.menu.domain.Item;
import edu.sp5.jvx330.cafe.sales.business.impl.SalesHistoryServiceImpl;
import edu.sp5.jvx330.cafe.sales.business.impl.SalesTotalPriceServiceImpl;
import edu.sp5.jvx330.cafe.sales.command.DateCommand;
import edu.sp5.jvx330.cafe.sales.command.MenuSalesHistoryCommand;
import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

@Controller
public class MDateSalesHistoryController {
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private ItemSerivceImpl itemService;
	@Autowired
	private SalesHistoryServiceImpl salesHistoryService;
	
	@GetMapping("/sales/mDateSalesHistory")
	public ModelAndView mDateSalesHistoryGet(String date) throws ParseException {
			ModelAndView mav = new ModelAndView();
//			String day = date.getDay();
//			String year = date.getYear();
//			String month = date.getMonth();
//			String str_yyyyMMdd = year+"-"+month+"-"+day;
//			
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			Date yyyyMMdd = format.parse(str_yyyyMMdd);
			if(date == "") {
				mav.addObject("errorMsg", "날짜를 선택해주세요");
				mav.setViewName("sales/main_m_salesHistory");  
				return mav;
			}
			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date yyyyMMdd = format.parse(date);
			
			List<SalesHistory> save_sh_list = salesHistoryService.sumNumOfSalesAndSumPaidPriceByDate(yyyyMMdd);
			//해당 날짜의 판매내역이 존재하지 않는 경우
			
			if(save_sh_list == null || save_sh_list.size() == 0) {
				mav.addObject("errorMsg", "해당 날짜의 판매내역이 존재하지 않습니다");
				mav.setViewName("sales/m_date_salesHistory");  
				return mav;
			}
			
			List<String> itemName_list = new ArrayList<>();
			List<String> categoryName_list = new ArrayList<>();
			Integer totalNumOfSales = 0;
			Integer totalPaidPrice = 0;
			for(SalesHistory sh : save_sh_list) {
				Item item = itemService.findItemByItemId(sh.getItem().getItemId());
				itemName_list.add(item.getItemName());
				Category category = categoryService.findCategoryByCategoryId(item.getCategory().getCategoryId());
				categoryName_list.add(category.getCategoryName());
				
				totalNumOfSales += sh.getNumOfSales();
				totalPaidPrice += sh.getPaidPrice();
			}
			mav.addObject("save_sh_list", save_sh_list);
			mav.addObject("totalNumOfSales", totalNumOfSales);
			mav.addObject("totalPaidPrice", totalPaidPrice);		
			mav.addObject("itemName_list", itemName_list);
			mav.addObject("categoryName_list", categoryName_list);	
			mav.addObject("date", date);
			
			mav.setViewName("sales/m_date_salesHistory");  
			return mav;
	}
}
