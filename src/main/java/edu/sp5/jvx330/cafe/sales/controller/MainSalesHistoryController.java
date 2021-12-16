package edu.sp5.jvx330.cafe.sales.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.manager.domain.Manager;

@Controller
public class MainSalesHistoryController {

		@GetMapping("/sales/mainSalesHistory")
		public String mainSalesHistoryGet(HttpServletRequest request, HttpSession session) {	
			Manager auth_manager = (Manager)session.getAttribute("manager");
			
			//관리자로그인 확인
			if(auth_manager == null) {
				session.setAttribute("requestPath", request.getServletPath());
				return "/manager/login_manager";
			}
			return "sales/main_salesHistory";
		}
		
		@PostMapping("/sales/mainSalesHistory") 
		public ModelAndView mainSalesHistoryPost() {	
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
			mav.setViewName("sales/main_salesHistory");
			
			return mav;
		}
}
