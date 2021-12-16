package edu.sp5.jvx330.cafe.sales.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("MainMSalesHistoryController")
public class MainMSalesHistoryController {
	
	@GetMapping("/sales/mainMSalesHistory")
	public ModelAndView mainMSalesHistoryGet() {
		ModelAndView mav = new ModelAndView();
		
		List<Integer> year_list = new ArrayList<>();
		List<Integer> month_list = new ArrayList<>();
		List<Integer> day_list = new ArrayList<>();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		String thisYear = format.format(new Date());
		for(Integer year=2010; year<=Integer.parseInt(thisYear); year++) {
			year_list.add(year);
		}
		for(int month=1; month<=12; month++) {
			month_list.add(month);
		}
		for(int day=1; day<=31; day++) {
			day_list.add(day);
		}
		
		mav.addObject("year_list", year_list);
		mav.addObject("month_list", month_list);
		mav.addObject("day_list", day_list);
		
		mav.setViewName("sales/main_m_salesHistory");
		return mav;
	}
}
