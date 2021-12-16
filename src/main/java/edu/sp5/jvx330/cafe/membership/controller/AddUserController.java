package edu.sp5.jvx330.cafe.membership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.membership.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.membership.domain.Customer;
import edu.sp5.jvx330.cafe.util.Validator;
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
		
		//유효성 검사
		if(customer==null
				||Validator.isEmpty(customer.getName())
				||Validator.isEmpty(customer.getPhone()))
		{
			mav.addObject("errorMsg", "고객 정보를 다시 입력해주십시오.");
			mav.setViewName("membership/add_user");
			return mav;
		}
		
		try {
			cService.findCustomerByUserInfo(customer.getName(), customer.getPhone());//고객 찾기
			
			mav.addObject("errorMsg", "이미 가입된 고객입니다.");
			mav.setViewName("membership/add_user");
			return mav;
			
		} catch(EmptyResultDataAccessException e) {//등록된 고객이 없을 경우
			cService.addCustomer(customer);//고객 회원가입
			//고객 정보 찾기
			customer = cService.findCustomerByUserInfo(customer.getName(), customer.getPhone());
			orderContainer.setCustomer(customer);
			orderContainer.setMileage(0);
			mav.setViewName("redirect:/membership/searchMileage");
			return mav;
		}
		
	}
}
