package edu.sp5.jvx330.cafe.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("addItemsContoller")
public class AddItemsController {
	@PostMapping("/menu/add_items")
	public String addItemsPost() {
		
		return "/menu/search_items";
	}
}
