package edu.sp5.jvx330.cafe.manager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.manager.business.impl.ManagerServiceImpl;
import edu.sp5.jvx330.cafe.manager.domain.Manager;

@Controller
public class LoginManagerController {

		@Autowired
		private ManagerServiceImpl managerService;
		
		@GetMapping("/manager/loginManager")
		public String loginManagerGet() {
			return "manager/login_manager";
		}
		
		@PostMapping("/manager/loginManager")
		public ModelAndView loginManagerPost(@ModelAttribute Manager manager, HttpSession session) {
			manager = managerService.managerLogin(manager.getManagerName(), manager.getPasswd());
			ModelAndView mav = new ModelAndView();
			if (manager == null) {
				mav.addObject("loginErrorMsg", "Ȯ�� �� �ٽ� �Է����ּ���");
				mav.setViewName("manager/login_manager");  
				return mav;
			}
			session.setAttribute("manager", manager);
			mav.addObject("requestURL", session.getRequestURL());
			mav.setViewName("sales/today_salesHistory");  

			return mav;
		}
}
