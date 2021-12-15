package edu.sp5.jvx330.cafe.membership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.membership.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.membership.domain.Customer;
import edu.sp5.jvx330.cafe.web.container.OrderContainer;

@SessionAttributes("orderContainer")
@Controller("controller.LoginUserController")
public class LoginUserController {
	@Autowired
	private CustomerServiceImpl customerService;
	
	@GetMapping("/membership/loginUser")
	public String mileageForm() {
		return "membership/login_user";
	}

	@PostMapping("/membership/loginUser")
	public ModelAndView mileageLogin(OrderContainer orderContainer) {
		//AnnotationConfigApplicationContext context = 
				//new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		//customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("LoginUserController : "+orderContainer);
		
		String name = orderContainer.getCustomer().getName();
		String phone = orderContainer.getCustomer().getPhone();

		//�� ���� ���� Customer ��ü
		Customer customer;
		try {
			//�� ������ ���� ���
			customer = customerService.findCustomerByUserInfo(name, phone);
			System.out.println("mileageLogin : "+customer);
			mav.setViewName("membership/search_mileage");
		} catch(EmptyResultDataAccessException e) {
			//�������� ���� ���
			//System.out.println("EmptyResultDataAccessException �߻�");
			customer = null;
			mav.addObject("errorMsg","�������� �����ϴ�");
			mav.setViewName("membership/login_user");
		}
		
		orderContainer.setCustomer(customer);
		/*
		//�� ������ ���� ���
		if (customerService.findCustomerByUserInfo(name, phone) != null) {			
			mav.setViewName("membership/search_mileage");
		} else {
			//�� ����x
			orderContainer.setCustomer(new Customer());
		}
		*/
		
		return mav;
	}
}
