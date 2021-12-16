package edu.sp5.jvx330.cafe.membership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.membership.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.membership.business.impl.MileageServiceImpl;
import edu.sp5.jvx330.cafe.membership.domain.Customer;
import edu.sp5.jvx330.cafe.web.container.OrderContainer;

@SessionAttributes("orderContainer")
@Controller("controller.LoginUserController")
public class LoginUserController {
	@Autowired
	private CustomerServiceImpl customerService;
	@Autowired
	private MileageServiceImpl mService;
	
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
		
		String name = orderContainer.getCustomer().getName();
		String phone = orderContainer.getCustomer().getPhone();

		//고객 정보 담을 Customer 객체
		Customer customer;
		try {
			//고객 정보가 있을 경우
			customer = customerService.findCustomerByUserInfo(name, phone);
			System.out.println("mileageLogin : "+customer);
			
			orderContainer.setMileage(mService.findMileage(customer));//세션에 마일리지 입력
			//System.out.println("LoginUserController : "+mService.findMileage(customer));
			//System.out.println("[LoginUserController(orderContainer)] : "+orderContainer);
			
			//mav.setViewName("membership/search_mileage");//원래 코드
			mav.setViewName("redirect:/membership/searchMileage");
		} catch(EmptyResultDataAccessException e) {
			//고객정보가 없을 경우
			//System.out.println("EmptyResultDataAccessException 발생");
			customer = null;
			mav.addObject("errorMsg","고객정보가 없습니다");
			mav.setViewName("membership/login_user");
		}
		
		orderContainer.setCustomer(customer);
		
		/*
		//고객 정보가 있을 경우
		if (customerService.findCustomerByUserInfo(name, phone) != null) {			
			mav.setViewName("membership/search_mileage");
		} else {
			//고객 정보x
			orderContainer.setCustomer(new Customer());
		}
		*/
		
		return mav;
	}
}
