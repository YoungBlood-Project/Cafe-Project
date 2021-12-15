package edu.sp5.jvx330.cafe.sales.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.sales.business.impl.SalesTotalPriceServiceImpl;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

@Controller
public class MonthSalesTotalPriceController {
	
	@Autowired
	private SalesTotalPriceServiceImpl salesTotalPriceService;
	
	@GetMapping("/sales/monthSalesTotalPrice")
	public ModelAndView monthSalesTotalGet(@ModelAttribute String month) throws ParseException {
		ModelAndView mav = new ModelAndView();
		SimpleDateFormat format = new SimpleDateFormat ("yyyy");
		String thisYear = format.format(new Date());
		String str_yyyyMM = thisYear+"-"+month;
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM");
		Date yyyyMM = transFormat.parse(str_yyyyMM);
		
		List<SalesTotalPrice> stp_list = salesTotalPriceService.findSalesTotalPriceByMonth(yyyyMM);
		mav.addObject("stp_list", stp_list);

		mav.setViewName("sales/month_salesTotalPrice");
		return mav;
	}
	
	@ModelAttribute("monthList")
	public Map<String, String> monthPrividerList() {
		Map<String, String> monthList_map = new HashMap<String, String>();
		monthList_map.put("12월", "12");
		monthList_map.put("11월", "11");
		monthList_map.put("10월", "10");
		monthList_map.put("9월", "9");
		monthList_map.put("8월", "8");
		monthList_map.put("7월", "7");
		monthList_map.put("6월", "6");
		monthList_map.put("5월", "5");
		monthList_map.put("4월", "4");
		monthList_map.put("3월", "3");
		monthList_map.put("2월", "2");
		monthList_map.put("1월", "1");
		return monthList_map;
	}
}
