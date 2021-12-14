package edu.sp5.jvx330.cafe.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("payPriceController")
public class PayPriceController {
	@GetMapping("/main/payPrice")
	public String PayPriceGet() {
		//System.out.println("get");
		return "/main/pay_price";
	}
	
	@PostMapping("/main/payPrice")
	public String PayPricePost() {
		//System.out.println("post");
		return "/main/pay_price";
	}
}
