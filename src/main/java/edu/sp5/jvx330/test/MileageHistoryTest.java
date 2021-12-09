package edu.sp5.jvx330.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.customer.business.CustomerService;
import edu.sp5.jvx330.cafe.customer.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileageHistory.business.MileageHistorySerivce;
import edu.sp5.jvx330.cafe.customer.mileageHistory.business.impl.MileageHistoryServiceImpl;
import edu.sp5.jvx330.cafe.customer.mileageHistory.config.MileageHistoryConfig;
import edu.sp5.jvx330.cafe.customer.mileageHistory.domain.MileageHistory;

public class MileageHistoryTest {
	private static CustomerService customerService;
	private static MileageHistorySerivce mileageService;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MileageHistoryConfig.class);
		
		mileageService = context.getBean("mileageServiceImpl", MileageHistoryServiceImpl.class);
		customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);

		// 1. ���ϸ��� ���� 
		// addMileage();
		  
		// 2. ���ϸ��� ��ȸ
		// findMileageByUserInfo();
		// fineMileageByOrderNum();
		  
		// 3. ���ϸ��� �ݾ� ���� 
		// setMileage();
		  
		// 4. ���ϸ��� ����  
		// deleteMileage();

		context.close();
	}
	
	
	/**
	 * ���� - ������
	 * ���ϸ��� �����ϴ� �޼ҵ尡 ��� ���ϸ��� ���� �޼ҵ带 �߰��߽��ϴ�
	 */
	// 1. ���ϸ��� ����
	public static void addMileage() {
		Customer customer = customerService.findCustomerByUserInfo("A", "1");
		MileageHistory mileage = new MileageHistory(customer, 201212060001l, 500);
		mileageService.addMileageHistory(customer, mileage);
		System.out.println("MileageService : ���� �Ϸ�.");
		
	}
	// 2. ���ϸ��� ��ȸ
	public static void findMileageByUserInfo() {
		Customer customer = customerService.findCustomerByUserInfo("A", "1");
		List<MileageHistory> mileage_list = mileageService.findMHByUserInfo(customer);
		System.out.println("���ϸ��� ��ȸ ����--------------");
		for(MileageHistory m : mileage_list) {
			System.out.println(m);
		}
	}
	
	
	/**
	 * ������ - orderNum���� ���ϸ��� ��ȸ�ϴ� �ڵ� �߰�.
	 * @param orderNum
	 */
	// 2-1. orderNum���� ���ϸ��� ��ȸ
	public static void fineMHByOrderNum() {
		List<MileageHistory> mileage_list = mileageService.findMHByOrderNum(201212060001l);
		for (MileageHistory mileage : mileage_list) {
			System.out.println(mileage);
		}
	}
	
	// 3. ���ϸ��� �ݾ� ����(���ϸ��� ���)
	public static void setMileageHistory() {
		Customer customer = customerService.findCustomerByUserInfo("A", "1");
		mileageService.setMileageHistory(customer, 10);
		System.out.println("mileageService : ���ϸ��� ���� ���� �Ϸ�.");
		
	}
	
	// 4. ���ϸ��� ����
	public static void deleteMileageHistory() {
		Customer customer = customerService.findCustomerByUserInfo("A", "1");
		mileageService.deleteMileageHistory(customer);
		System.out.println("mileageService: ���� �Ϸ�.");
	}
}
