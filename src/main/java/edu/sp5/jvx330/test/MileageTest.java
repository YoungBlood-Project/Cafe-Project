package edu.sp5.jvx330.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.customer.business.CustomerService;
import edu.sp5.jvx330.cafe.customer.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.mileage.business.MileageSerivce;
import edu.sp5.jvx330.cafe.mileage.business.impl.MileageServiceImpl;
import edu.sp5.jvx330.cafe.mileage.config.MileageConfig;
import edu.sp5.jvx330.cafe.mileage.domain.Mileage;

public class MileageTest {
	private static CustomerService customerService;
	private static MileageSerivce mileageService;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MileageConfig.class);
		
		mileageService = context.getBean("mileageServiceImpl", MileageServiceImpl.class);
		customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);

//		addMileage();
//		 findMileageByUserInfo();
//		 setMileage();
//		 deleteMileage();

		context.close();
	}
	
	
	/**
	 * ���� - ����
	 * ���ϸ��� �����ϴ� �޼ҵ尡 ��� ���ϸ��� ���� �޼ҵ带 �߰��߽��ϴ�
	 */
	// 1. ���ϸ��� ����
	public static void addMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		Mileage mileage = new Mileage(customer, 201212060001l, 500);
		mileageService.addMileage(customer, mileage);
		System.out.println("MileageService : ���� �Ϸ�.");
		
	}
	// 2. ���ϸ��� ��ȸ
	public static void findMileageByUserInfo() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		List<Mileage> mileage_list = mileageService.findMileageByUserInfo(customer);
		System.out.println("���ϸ��� ��ȸ ����--------------");
		for(Mileage m : mileage_list) {
			System.out.println(m);
		}
	}
	
	/**
	 * ���� - orderNum���� ���ϸ��� ��ȸ�ϴ� �ڵ� �߰�.
	 * @param orderNum
	 */
	// 2-1. orderNum���� ���ϸ��� ��ȸ
	public static void fineMileageByOrderNum(Long orderNum) {
		List<Mileage> mileage_list = mileageService.findMileageByOrderNum(orderNum);
		for (Mileage mileage : mileage_list) {
			System.out.println(mileage);
		}
		
	}
	
	// 3. ���ϸ��� �ݾ� ����(���ϸ��� ���)
	public static void setMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		mileageService.setMileage(customer, 10);
		System.out.println("mileageService : ���ϸ��� ���� ���� �Ϸ�.");
		
	}
	
	// 4. ���ϸ��� ����
	public static void deleteMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		mileageService.deleteMileage(customer);
		System.out.println("mileageService: ���� �Ϸ�.");
	}
}
