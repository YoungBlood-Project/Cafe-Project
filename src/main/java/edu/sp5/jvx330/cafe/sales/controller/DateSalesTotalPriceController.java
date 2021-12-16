package edu.sp5.jvx330.cafe.sales.controller;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.sales.command.DateCommand;

@Controller
public class DateSalesTotalPriceController {

	@GetMapping("/sales/dateSalesTotalPrice")
	public ModelAndView dateSalesTotalPriceGet(DateCommand date) {
		String year = date.getYear();
		String month = date.getMonth();
		String day = date.getDay();
		
		ModelAndView mav = new ModelAndView();
		SimpleDateFormat format = new SimpleDateFormat();
		
		
		
		
		return mav;
	}
}
