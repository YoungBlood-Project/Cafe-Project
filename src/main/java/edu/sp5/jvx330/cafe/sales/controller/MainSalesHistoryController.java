package edu.sp5.jvx330.cafe.sales.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
		public String mainSalesHistoryPost() {	
			return "sales/main_salesHistory";
		}
}
