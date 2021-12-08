package edu.sp5.jvx330.cafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sp5.jvx330.cafe.command.OrderItemsCommand;

@Controller("main.index")
public class IndexController {
	@GetMapping("main/index")
	public String indexForm() {
		return "main/index";
	}
	
	@PostMapping("main/index")
	public String index(@ModelAttribute OrderItemsCommand orderItems) {
		//거래내역 불러오기...? AJAX 안써도 될지도
		return "main/index";
	}
}
