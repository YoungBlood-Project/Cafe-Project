package edu.sp5.jvx330.cafe.controller;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.sp5.jvx330.cafe.DataSourceConfig;
import edu.sp5.jvx330.cafe.command.MileageCommand;
import edu.sp5.jvx330.cafe.customer.mileage.config.MileageConfig;

@Controller("controller.mileageController")
public class MileageController {
	
	@GetMapping("customer/mileage/mileage")
	public String mileageForm() {
		return "customer/mileage/mileage";
	}
	
	@PostMapping("customer/mileage/mileage")
	public String Mileage(@ModelAttribute MileageCommand mileage) {
		
		return "customer/mileage/mileage";
	}
}
