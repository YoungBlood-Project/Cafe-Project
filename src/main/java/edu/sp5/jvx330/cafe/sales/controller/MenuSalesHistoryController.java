package edu.sp5.jvx330.cafe.sales.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("menuSalesHistoryController")
public class MenuSalesHistoryController {
	@GetMapping("/sales/menuSalesHistory")
	public ModelAndView salesHistory() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Integer> historyByDate_year = new ArrayList<>();
		List<Integer> historyByDate_month = new ArrayList<>();
		List<Integer> historyByDate_day = new ArrayList<>();
		
		for (Integer year = 2010; year < 2021; year++) {
			historyByDate_year.add(year);
		}
		
		for (Integer month = 1; month < 12; month++) {
			historyByDate_month.add(month);
		}
		
		for (Integer date = 1; date < 31; date++) {
			historyByDate_day.add(date);
		}
		
		mav.addObject("historyByDate_year", historyByDate_year);
		mav.addObject("historyByDate_month", historyByDate_month);
		mav.addObject("historyByDate_day", historyByDate_day);
		mav.setViewName("/sales/menu_salesHistory");
		
		return mav;
	}
}
