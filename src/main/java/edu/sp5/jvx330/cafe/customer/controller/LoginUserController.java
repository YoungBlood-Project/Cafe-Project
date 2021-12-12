package edu.sp5.jvx330.cafe.customer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.sp5.jvx330.cafe.DataSourceConfig;
import edu.sp5.jvx330.cafe.command.CustomerCommand;
import edu.sp5.jvx330.cafe.command.MileageCommand;
import edu.sp5.jvx330.cafe.customer.business.impl.CustomerServiceImpl;

@Controller("customer.controller.LoginUserController")
public class LoginUserController {
	@Autowired
	private CustomerServiceImpl customerService;
	
	@GetMapping("customer/loginUser")
	public String mileageForm() {
		return "customer/login_user";
	}

	@PostMapping("customer/loginUser")
	public String mileageLogin(@ModelAttribute CustomerCommand customer) {
		//AnnotationConfigApplicationContext context = 
				//new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		//customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);
		
		System.out.println(customer);
		
		String name = customer.getName();
		String phone = customer.getPhone();
		
		//고객 정보가 있을 경우
		if (customerService.findCustomerByUserInfo(name, phone) != null) {			
			return "customer/mileage/use_mileage";
		}
		
		return "customer/login_user";
	}
}
