package edu.sp5.jvx330.cafe.sales.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.menu.business.impl.ItemSerivceImpl;
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
			yyyyMM2 = format.parse(str_yyyyMM2);//2022-01-01
		}
		
		List<SalesHistory> sh_list = salesHistoryService.findSalesHistoryByMonth(yyyyMM, yyyyMM2);
		for(SalesHistory sh : sh_list) {
			
			
		}
		
		
		mav.setViewName("sales/m_month_salesHistory");
		
		return mav;
	}
}
