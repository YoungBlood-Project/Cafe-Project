package edu.sp5.jvx330.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.config.MileageConfig;
import edu.sp5.jvx330.cafe.membership.business.CustomerService;
import edu.sp5.jvx330.cafe.membership.business.MileageService;
import edu.sp5.jvx330.cafe.membership.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.membership.business.impl.MileageServiceImpl;
import edu.sp5.jvx330.cafe.membership.domain.Customer;


public class MileageServiceTest {
	private static CustomerService customerService;
	private static MileageService mileageService;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MileageConfig.class);
		
		customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);
		mileageService = context.getBean("mileageServiceImpl", MileageServiceImpl.class);

		// 1. Mileage �� ����
		//  1-1. ���ϸ��� ����
		// addMileage();
		//  1-2. ���ϸ��� ���
		// subtractMileage();
		 
		// 2. Mileage ��ȸ
		findMileage();
		 
		// 3. Mileage ���� 
		// deleteMileage();

		context.close();
	}

	// 1. Mileage �� ����
	//  1-1. ���ϸ��� ����
	public static void addMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example_ex1", "example_ex1");
		mileageService.addMileage(customer, 500);
		System.out.println("���ϸ��� ���� �Ϸ�");
	}
	
	//  1-2. ���ϸ��� ���
	public static void subtractMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example_ex1", "example_ex1");
		mileageService.subtractMileage(customer, 200);
		System.out.println("���ϸ��� ��� �Ϸ�");
	}
	// 2. Mileage ��ȸ
	public static void findMileage() {
		System.out.println("------------ Mileage ��ȸ------------");
		Customer customer = customerService.findCustomerByUserInfo("example_ex1", "example_ex1");
		System.out.println(customer);
		Integer mileage = mileageService.findMileage(customer);
		System.out.println(mileage);
	}
	
	// 3. Mileage ����
	public static void deleteMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example_ex1", "example_ex1");
		mileageService.deleteMileage(customer);
		System.out.println("���ϸ��� ���� �Ϸ�");
	}
		
	
}
