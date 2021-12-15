package edu.sp5.jvx330.cafe.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("setItemsController")
public class SetItemsController {
	@PostMapping("/menu/set_items")
	public String setItemsPost() {
		
		return "menu/search_items";
	}
}
