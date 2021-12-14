package edu.sp5.jvx330.cafe.membership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.membership.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.membership.command.CustomerCommand;
import edu.sp5.jvx330.cafe.membership.domain.Customer;

@Controller("controller.LoginUserController")
public class LoginUserController {
	@Autowired
	private CustomerServiceImpl customerService;
	
	@GetMapping("/membership/loginUser")
	public String mileageForm() {
		return "membership/login_user";
	}

	@PostMapping("/membership/loginUser")
	public ModelAndView mileageLogin(@ModelAttribute Customer customer) {
		//AnnotationConfigApplicationContext context = 
				//new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		//customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println(customer);
		
		String name = customer.getName();
		String phone = customer.getPhone();

		mav.setViewName("membership/login_user");
		
		//고객 정보가 있을 경우
		if (customerService.findCustomerByUserInfo(name, phone) != null) {			
			mav.addObject("customer", customer);
			mav.setViewName("membership/search_mileage");
		}
		
		return mav;
	}
}
