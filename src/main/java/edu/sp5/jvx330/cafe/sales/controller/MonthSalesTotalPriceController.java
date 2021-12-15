package edu.sp5.jvx330.cafe.sales.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.sales.business.impl.SalesTotalPriceServiceImpl;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

@Controller
public class MonthSalesTotalPriceController {
	
	@Autowired
	private SalesTotalPriceServiceImpl salesTotalPriceService;
	
	@GetMapping("/sales/monthSalesTotalPrice")
	public ModelAndView monthSalesTotalGet(String year, String month) throws ParseException {
		//year = 2021 //(1) month = 3, (2) month = 12
		ModelAndView mav = new ModelAndView();
		
		String str_yyyyMM = year+"-"+month;//(1)2021-03 //(2)2021-12
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM");
		Date yyyyMM = transFormat.parse(str_yyyyMM); //(1)2021-03-01, (2)2021-12-01
		
		//(1)의 경우
		int nextMonth = Integer.parseInt(month)+1;
		String str_yyyyMM2 = year+"-"+Integer.toString(nextMonth);
		Date yyyyMM2 = transFormat.parse(str_yyyyMM2); //2021-04-01	
		
		//(2)의 경우
		if(month == "12") {
			String firstMonth = "1";
			int nextYear = Integer.parseInt(year) + 1;
			str_yyyyMM2 = Integer.toString(nextYear)+"-"+firstMonth;
			yyyyMM2 = transFormat.parse(str_yyyyMM2);//2022-01-01
		}
		
		List<SalesTotalPrice> stp_list = salesTotalPriceService.findSalesTotalPriceByMonth(yyyyMM, yyyyMM2);
		mav.addObject("stp_list", stp_list);

		mav.setViewName("sales/month_salesTotalPrice");
		return mav;
	}
	
}
