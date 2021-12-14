package edu.sp5.jvx330.cafe.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
		public String loginManagerPost(@ModelAttribute Manager manager) {
			manager = managerService.managerLogin(manager.getManagerName(), manager.getPasswd());
			if (manager == null) {
				return "manager/login_manager";
			}
			return "main/index";
		}
}
