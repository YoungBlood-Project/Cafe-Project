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
import edu.sp5.jvx330.cafe.sales.command.DateCommand;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

@Controller
public class DateSalesTotalPriceController {
	
	@Autowired
	private SalesTotalPriceServiceImpl salesTotalPriceService;

	@GetMapping("/sales/dateSalesTotalPrice")
	public ModelAndView dateSalesTotalPriceGet(DateCommand date) throws ParseException {
		//year = 2021 
		//(1) month = 3, (2) month = 12
		//(1) date = 5, (2) date = 13
		ModelAndView mav = new ModelAndView();
		String year = date.getYear();//�Է��� �⵵
		String month = date.getMonth();//�Է��� ��
		String day = date.getDay();//�Է��� ��
		
		String str_yyyyMMdd = year+"-"+month+"-"+day;//(1)2021-03-12 //(2)2021-12
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date yyyyMMdd = format.parse(str_yyyyMMdd);
		
		Integer all_total = 0;
		Integer add_reduced = 0;
		
		//����Ͻ����� ȣ��
		List<SalesTotalPrice> stp_list = salesTotalPriceService.findSTPByOrderDate(yyyyMMdd);
		for(SalesTotalPrice stp : stp_list) {
			all_total += stp.getTotalPrice();
			add_reduced += stp.getReducedPrice();
		}
		
		mav.addObject("yyyyMMdd", year+"�� "+month+"��"+day+"��");
		mav.addObject("stp_list", stp_list);

		mav.setViewName("sales/date_salesTotalPrice");
		return mav;
	}
}
