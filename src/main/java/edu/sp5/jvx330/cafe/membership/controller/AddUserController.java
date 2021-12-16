package edu.sp5.jvx330.cafe.membership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.membership.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.membership.domain.Customer;
import edu.sp5.jvx330.cafe.web.container.OrderContainer;

@SessionAttributes("orderContainer")
@Controller("controller.AddUserController")
public class AddUserController {
	@Autowired
	CustomerServiceImpl cService;
	
	@GetMapping("/membership/addUser")
	public String addUserGet() {
		return "membership/add_user";
	}
	
	@Transactional
	@PostMapping("/membership/addUser")
	public ModelAndView addUserPost(OrderContainer orderContainer,
			Customer customer) {
		ModelAndView mav = new ModelAndView();
		System.out.println("addUserPost : "+customer);
		
		if(customer==null
				|| customer.getName()==null || customer.getName().length()==0
				|| customer.getPhone()==null || customer.getPhone().length()==0)
		{
			mav.addObject("errorMsg", "고객 정보를 다시 입력해주십시오.");
			mav.setViewName("membership/add_user");
			return mav;
		}
		cService.addCustomer(customer);//고객 회원가입
		//고객 정보 찾기
		cService.findCustomerByUserInfo(customer.getName(), customer.getPhone());
		
		orderContainer.setCustomer(customer);
		mav.setViewName("searchMileage");
		return mav;
	}
}
