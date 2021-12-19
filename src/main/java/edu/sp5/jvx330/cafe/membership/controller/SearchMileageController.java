package edu.sp5.jvx330.cafe.membership.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.jvx330.cafe.membership.domain.MileageHistory;
import edu.sp5.jvx330.cafe.web.container.OrderContainer;

@SessionAttributes("orderContainer")
@Controller("controller.searchMileageController")
public class SearchMileageController {
	
	@GetMapping("/membership/searchMileage")
	public ModelAndView SearchMileageGet(OrderContainer orderContainer) {//���ǿ��� orderContainer �ޱ�? �ϴ� �߰�
		ModelAndView mav = new ModelAndView();
		
		System.out.println("SearchMileageController : "+orderContainer.getMileage());
		mav.setViewName("/membership/search_mileage");
		return mav;
	}
	
	@PostMapping("/membership/searchMileage")
	public ModelAndView SearchMileagePost(OrderContainer orderContainer 
			,String select_mileage, Integer use_amount) {	
		
		ModelAndView mav = new ModelAndView();
		
		//System.out.println(select_mileage);
		System.out.println("searchMileageController(post) : " + orderContainer);
		
		MileageHistory mileageHistory = orderContainer.getMileageHistory();
		
		if(select_mileage.equals("add_mileage")) {//����
			System.out.println("mileageHistory : "+mileageHistory);
			//mileageHistoryServiceImpl.addMileageHistory(customer, mileageHistory);
			//����, session�� ���αݾ��� 0
		} else if(select_mileage.equals("use_mileage")) {			
			//System.out.println("[SearchMileageController]������ ���ϸ���: "+orderContainer.getMileage());
			//������ ���ϸ��� ��ȸ
			
			//System.out.println("����� �ݾ� : "+use_amount);
			//System.out.println("������ ���ϸ��� : "+orderContainer.getMileage());
			
			//�ƹ� ���� �Է����� �ʾ��� ���
			if(use_amount==null || use_amount<=0) {
				return addErrorMsg(mav, "����� ���� �Է����ֽʽÿ�.");
				
				/*
				mav.addObject("errorMsg", "����� ���� �Է����ֽʽÿ�!.");
				mav.setViewName("membership/search_mileage");
				
				return mav;
				*/
			}
			//������ ���ϸ������� ���ݾ��� Ŭ ���
			else if(orderContainer.getMileage() < use_amount) {
				return addErrorMsg(mav, "������ ���ϸ����� �����մϴ�.");
				
				/*
				mav.addObject("errorMsg", "������ ���ϸ����� �����մϴ�.");
				mav.setViewName("membership/search_mileage");
				
				return mav;
				*/
			}
			else if((use_amount%10) != 0) {
				return addErrorMsg(mav, "10�� ������ ������ �Է��� �� �����ϴ�.");
				
				/*
				mav.addObject("errorMsg", "10�� ������ ������ �Է��� �� �����ϴ�.");
				mav.setViewName("membership/search_mileage");
				
				return mav;
				*/
			}
			
			mileageHistory.setMBalance(-use_amount);//����� �ݾ�
			orderContainer.setMileageHistory(mileageHistory);
			
			//���� ������ �ִ� totalprice - ����� ���ϸ���
			Integer reducedPrice = orderContainer.getSalesTotalPrice().getTotalPrice() - use_amount;
			//orderContainer�� ���� salesTotalPrice�� reducedPrice ����ؼ� �Է�
			orderContainer.getSalesTotalPrice().setReducedPrice(reducedPrice);
			
		} else {
			System.out.println("searchMileageController ���� �߻�");
		}
		
		//post ������� �̵�
		mav.addObject("use_amount",use_amount);
		//index�� ���� �� submit ���� ���� ��ũ
		mav.addObject("index_link", "/jvx330/main/payPrice");
		mav.setViewName("main/index");
		return mav;
	}
	
	public ModelAndView addErrorMsg(ModelAndView mav, String msg) {
		mav.addObject("errorMsg", msg);
		mav.setViewName("membership/search_mileage");
		
		return mav;
	}
}
