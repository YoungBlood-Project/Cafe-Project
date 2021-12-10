package edu.sp5.jvx330.cafe.controller;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.sp5.jvx330.cafe.DataSourceConfig;
import edu.sp5.jvx330.cafe.command.MileageCommand;
import edu.sp5.jvx330.cafe.customer.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.customer.mileage.business.impl.MileageServiceImpl;

@Controller("controller.mileageController")

public class MileageController {

	private static CustomerServiceImpl customerService;
	
	@GetMapping("customer/mileage/mileage")
	public String mileageForm() {
		return "customer/mileage/mileage";
	}

	@PostMapping("customer/mileage/mileage")
	public String mileageLogin(@ModelAttribute MileageCommand mileage) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);
		
		String name = mileage.getCustomer().getName();
		String phone = mileage.getCustomer().getPhone();
		
		//if (customerService.findCustomerByUserInfo(name, phone) == ) {			
		//	return "customer/mileage/search_mileage";
		//}
		
		return "customer/mileage/mileage";
	}
}
