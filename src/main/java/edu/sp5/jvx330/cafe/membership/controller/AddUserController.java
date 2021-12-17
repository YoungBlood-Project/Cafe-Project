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
@Controller("controller.addUserController")
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
		
		//��ȿ�� �˻�
		if(customer==null
				||Validator.isEmpty(customer.getName())
				||Validator.isEmpty(customer.getPhone()))
		{
			mav.addObject("errorMsg", "�� ������ �ٽ� �Է����ֽʽÿ�.");
			mav.setViewName("membership/add_user");
			return mav;
		}
		
		try {
			cService.findCustomerByUserInfo(customer.getName(), customer.getPhone());//�� ã��
			
			mav.addObject("errorMsg", "�̹� ���Ե� ���Դϴ�.");
			mav.setViewName("membership/add_user");
			return mav;
			
		} catch(EmptyResultDataAccessException e) {//��ϵ� ���� ���� ���
			cService.addCustomer(customer);//�� ȸ������
			//�� ���� ã��
			customer = cService.findCustomerByUserInfo(customer.getName(), customer.getPhone());
			orderContainer.setCustomer(customer);
			orderContainer.setMileage(0);
			mav.setViewName("redirect:/membership/searchMileage");
			return mav;
		}
		
	}
}
