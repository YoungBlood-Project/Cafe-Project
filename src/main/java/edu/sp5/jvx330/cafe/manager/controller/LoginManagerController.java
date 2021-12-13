package edu.sp5.jvx330.cafe.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.sp5.jvx330.cafe.manager.business.impl.ManagerServiceImpl;

@Controller("manager.controller.LoginManagerController")
public class LoginManagerController {

		@Autowired
		private ManagerServiceImpl managerService;
		
		@GetMapping("manager/LoginManager")
		public String managerLoginGet() {
			return "manager/login_manager";
		}
		
		@PostMapping("manager/LoginManager")
		public String managerLoginPost(@ModelAttribute Manager manager) {
			managerService
			
			
			
		}
}
