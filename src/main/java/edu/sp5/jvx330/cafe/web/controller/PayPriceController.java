package edu.sp5.jvx330.cafe.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.sp5.jvx330.cafe.web.container.OrderContainer;

@SessionAttributes("orderContainer")
@Controller("payPriceController")
public class PayPriceController {
	@GetMapping("/main/payPrice")
	public String PayPriceGet(OrderContainer orderContainer) {
		System.out.println("get : "+orderContainer);
		return "/main/pay_price";
	}
	
	@PostMapping("/main/payPrice")
	public String PayPricePost(OrderContainer orderContainer) {
		System.out.println("post : "+orderContainer);
		return "/main/pay_price";
	}
}
