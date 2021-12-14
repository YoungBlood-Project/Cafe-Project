package edu.sp5.jvx330.cafe.membership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.membership.business.impl.MileageHistoryServiceImpl;
import edu.sp5.jvx330.cafe.membership.domain.Customer;
import edu.sp5.jvx330.cafe.membership.domain.Mileage;
import edu.sp5.jvx330.cafe.membership.domain.MileageHistory;
import edu.sp5.jvx330.cafe.web.container.OrderContainer;

@Controller("searchMileageController")
public class SearchMileageController {
	@Autowired
	private MileageHistoryServiceImpl mileageHistoryServiceImpl;
	
	@PostMapping("/membership/searchMileage")
	public ModelAndView SearchMileageGet(@SessionAttribute("orderContainer") OrderContainer orderContainer 
			,String select_mileage, Integer use_amount, Customer customer) {
		ModelAndView mav = new ModelAndView();
		
		System.out.println(select_mileage);
		System.out.println("searchMileageController : " + orderContainer);
		
		MileageHistory mileageHistory = orderContainer.getMileageHistory();
		
		if(select_mileage.equals("add_mileage")) {//����
			System.out.println("mileageHistory : "+mileageHistory);
			System.out.println("customer : "+customer);
			//mileageHistoryServiceImpl.addMileageHistory(customer, mileageHistory);
			use_amount = 0; //����, session�� ���αݾ��� 0
		} else if(select_mileage.equals("use_mileage")) {
			mileageHistory.setMBalance(-use_amount);//����� �ݾ�
			orderContainer.setMileageHistory(mileageHistory);
			System.out.println("����� �ݾ� : "+use_amount);
			//get ������� �̵�
		} else {
			System.out.println("searchMileageController ���� �߻�");
		}
		
		mav.addObject("use_amount",use_amount);
		mav.setViewName("redirect:/main/index");
		return mav;
	}
}
