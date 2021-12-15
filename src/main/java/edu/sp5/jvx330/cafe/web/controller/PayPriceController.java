package edu.sp5.jvx330.cafe.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.membership.business.impl.MileageHistoryServiceImpl;
import edu.sp5.jvx330.cafe.membership.business.impl.MileageServiceImpl;
import edu.sp5.jvx330.cafe.sales.business.impl.SalesHistoryServiceImpl;
import edu.sp5.jvx330.cafe.sales.business.impl.SalesTotalPriceServiceImpl;
import edu.sp5.jvx330.cafe.sales.util.OrderNumGenerator;
import edu.sp5.jvx330.cafe.web.container.OrderContainer;

@SessionAttributes("orderContainer")
@Controller("payPriceController")
public class PayPriceController {
	@Autowired
	MileageServiceImpl mService;
	@Autowired
	MileageHistoryServiceImpl mhService;
	@Autowired
	SalesTotalPriceServiceImpl stpService;
	@Autowired
	SalesHistoryServiceImpl shService;
	
	@GetMapping("/main/payPrice")//필요없을 거 같지만 일단 만들어 놓은 GetMapping
	public String PayPriceGet(OrderContainer orderContainer) {
		System.out.println("get : "+orderContainer);
		return "/main/pay_price";
	}
	
	@Transactional//트랜잭션 묶기
	@PostMapping("/main/payPrice")
	public ModelAndView PayPricePost(OrderContainer orderContainer) {
		System.out.println("post : "+orderContainer);
		
		ModelAndView mav = new ModelAndView();
		Long orderNum = OrderNumGenerator.countOrderNum();
		System.out.println(orderNum);
		
		if(orderContainer.getCustomer()!=null) {//고객 정보를 입력했을 경우
			
		}
		
		//주문 번호 생성, 경로 입력
		mav.addObject("orderNum", orderNum);
		mav.setViewName("/main/pay_price");
		
		return mav;
	}
}
