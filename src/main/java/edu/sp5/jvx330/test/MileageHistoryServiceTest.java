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

public class MileageHistoryServiceTest {
	private static CustomerService customerService;
	private static MileageHistorySerivce mileageService;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MileageHistoryConfig.class);
		
		mileageService = context.getBean("mileageHistoryServiceImpl", MileageHistoryServiceImpl.class);
		customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);

		// 1. ���ϸ��� ���� 
		// addMileageHistory();
		  
		// 2. ���ϸ��� ��ȸ
		// findMHByOrderNum();

		// --------------------------------------------------------------------

		// 1. ��ü ���ϸ��� ��ȸ
		// findMHByUserInfo();
		  
		// 3. ���ϸ��� �ݾ� ���� 
		// setMileageHistory();
		  
		// 4. ���ϸ��� ����  
		// deleteMileageHistory();

		context.close();
	}
	
	
	/**
	 * ���� - ������
	 * ���ϸ��� �����ϴ� �޼ҵ尡 ��� ���ϸ��� ���� �޼ҵ带 �߰��߽��ϴ�
	 */
	// 1. ���ϸ��� ����
	public static void addMileageHistory() {
		Customer customer = customerService.findCustomerByUserInfo("example_ex1", "example_ex1");
		MileageHistory mileage = new MileageHistory(customer, 201212060001l, 500);
		mileageService.addMileageHistory(customer, mileage);
		System.out.println("MileageService : ���� �Ϸ�.");
		
	}
	
	/**
	 * ������ - orderNum���� ���ϸ��� ��ȸ�ϴ� �ڵ� �߰�.
	 * @param orderNum
	 */
	// 2. orderNum���� ���ϸ��� ��ȸ
	public static void findMHByOrderNum() {
		List<MileageHistory> mileage_list = mileageService.findMHByOrderNum(201212060001l);
		for (MileageHistory mileage : mileage_list) {
			System.out.println(mileage);
		}
	}
	
	// --------------------------------------------------------------------
	
	// 1. ��ü ���ϸ��� ��ȸ
	public static void findMHByUserInfo() {
		Customer customer = customerService.findCustomerByUserInfo("example_ex1", "example_ex1");
		List<MileageHistory> mileage_list = mileageService.findMHByUserInfo(customer);
		System.out.println("���ϸ��� ��ȸ ����--------------");
		for(MileageHistory m : mileage_list) {
			System.out.println(m);
		}
	}
	
		
	// 2. ���ϸ��� �ݾ� ����(���ϸ��� ���)
	public static void setMileageHistory() {
		Customer customer = customerService.findCustomerByUserInfo("example_ex1", "example_ex1");
		mileageService.setMileageHistory(customer, 10);
		System.out.println("mileageService : ���ϸ��� ���� ���� �Ϸ�.");
		
	}
	
	// 3. ���ϸ��� ����
	public static void deleteMileageHistory() {
		Customer customer = customerService.findCustomerByUserInfo("example_ex1", "example_ex1");
		mileageService.deleteMileageHistory(customer);
		System.out.println("mileageService: ���� �Ϸ�.");
	}
}
