package edu.sp5.jvx330.cafe.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("payPriceController")
public class PayPriceController {
	@GetMapping("/main/payPrice")
	public String PayPriceGet() {
		return "/main/pay_price";
	}
}
