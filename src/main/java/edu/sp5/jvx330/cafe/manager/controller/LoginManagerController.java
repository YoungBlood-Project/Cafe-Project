package edu.sp5.jvx330.cafe.manager.controller;

import javax.servlet.http.HttpServletRequest;
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
		public ModelAndView loginManagerPost(@ModelAttribute Manager manager, HttpServletRequest request, HttpSession session) {
			manager = managerService.loginManager(manager.getManagerName(), manager.getPasswd());
			ModelAndView mav = new ModelAndView();
			//관리자 정보 확인 후 틀리면 다시 로그인화면으로
			if (manager == null) {
				mav.addObject("loginErrorMsg", "확인 후 다시 입력해주세요");
				mav.setViewName("manager/login_manager");  
				return mav;
			}
			
			//이전에 호출한 화면으로 이동
			request.getSession();
			session.setAttribute("manager", manager);
			mav.setViewName("redirect:"+(String)session.getAttribute("requestPath"));  
			return mav;
			
		}
}
