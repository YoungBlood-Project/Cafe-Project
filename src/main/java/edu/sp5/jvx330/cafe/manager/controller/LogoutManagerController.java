package edu.sp5.jvx330.cafe.manager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutManagerController {

	@GetMapping("/manager/logoutManager")
	public String logoutManager(HttpSession session) {
		session.removeAttribute("manager");
		session.invalidate();
		return "redirect:/main/index";
	}
}
