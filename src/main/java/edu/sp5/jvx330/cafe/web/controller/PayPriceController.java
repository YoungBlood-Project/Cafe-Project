package edu.sp5.jvx330.cafe.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.membership.business.impl.MileageHistoryServiceImpl;
import edu.sp5.jvx330.cafe.membership.business.impl.MileageServiceImpl;
import edu.sp5.jvx330.cafe.membership.domain.MileageHistory;
import edu.sp5.jvx330.cafe.menu.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.menu.command.OrderItemsCommand;
import edu.sp5.jvx330.cafe.menu.domain.Item;
import edu.sp5.jvx330.cafe.sales.business.impl.SalesHistoryServiceImpl;
import edu.sp5.jvx330.cafe.sales.business.impl.SalesTotalPriceServiceImpl;
import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;
import edu.sp5.jvx330.cafe.sales.util.OrderNumGenerator;
import edu.sp5.jvx330.cafe.web.container.OrderContainer;

@SessionAttributes("orderContainer")
@Controller("payPriceController")
public class PayPriceController {
	@Autowired
	ItemSerivceImpl itemService;
	@Autowired
	MileageServiceImpl mService;
	@Autowired
	MileageHistoryServiceImpl mhService;
	@Autowired
	SalesTotalPriceServiceImpl stpService;
	@Autowired
	SalesHistoryServiceImpl shService;
	
	@GetMapping("/main/payPrice")//�ʿ���� �� ������ �ϴ� ����� ���� GetMapping
	public String PayPriceGet(OrderContainer orderContainer) {
		System.out.println("get : "+orderContainer);
		return "/main/pay_price";
	}
	
	@Transactional//Ʈ����� ����
	@PostMapping("/main/payPrice")
	public ModelAndView PayPricePost(OrderContainer orderContainer,
			SessionStatus sessionStatus) {
		System.out.println("post : "+orderContainer);
		
		ModelAndView mav = new ModelAndView();
		Long orderNum = OrderNumGenerator.countOrderNum();//�ֹ���ȣ ����
		System.out.println(orderNum);
		
		SalesHistory sh = new SalesHistory();//�Ǹų���
		sh.setOrderNum(orderNum);//�ֹ���ȣ �Է�
		
		SalesTotalPrice stp = orderContainer.getSalesTotalPrice();//stp
		stp.setOrderNum(orderNum);
		
		MileageHistory mh = orderContainer.getMileageHistory();//���ϸ��� ��� ����
		mh.setOrderNum(orderNum);
		if(orderContainer.getCustomer()!=null) {//�� ������ �Է����� ���
			mhService.addMileageHistory(orderContainer.getCustomer(), mh);
			mService.addMileage(orderContainer.getCustomer(), mh.getMBalance());
		}
		
		//�������� �� ����(salesHistroy, stp)
		List<OrderItemsCommand> oic_list = orderContainer.getOrderItemsList();
		for(OrderItemsCommand oic : oic_list) {
			sh.setNumOfSales(oic.getNumOfNum());
			sh.setPaidPrice(oic.getPaidPrice());
			shService.addSalesHistory(oic.getMenuName(), sh);//�Ǹų��� ����
		}
		//System.out.println("�Ǹų��� ���� �Ϸ�");
		
		stpService.saveSalesTotalPrice(stp);//�Ǹų��� �� �ݾ�(stp) ����
		
		//�ֹ� ��ȣ ����, ��� �Է�
		mav.addObject("orderNum", orderNum);
		mav.setViewName("/main/pay_price");
		
		sessionStatus.setComplete();//���� ������ ����
		
		return mav;
	}
}
