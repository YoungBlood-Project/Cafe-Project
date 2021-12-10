package edu.sp5.jvx330.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.customer.business.CustomerService;
import edu.sp5.jvx330.cafe.customer.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileage.business.MileageService;
import edu.sp5.jvx330.cafe.customer.mileage.business.impl.MileageServiceImpl;
import edu.sp5.jvx330.cafe.customer.mileage.config.MileageConfig;

public class MileageTest {
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
		// findTotalMileage();
		 
		// 3. Mileage ���� 
		// deleteTotalMileage();

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
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		mileageService.subtractMileage(customer, 200);
		System.out.println("���ϸ��� ��� �Ϸ�");
	}
	// 2. Mileage ��ȸ
	public static void findMileage() {
		System.out.println("------------ Mileage ��ȸ------------");
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		System.out.println(customer);
		Integer totalMileage = mileageService.findMileage(customer);
		System.out.println(totalMileage);
	}
	
	// 3. Mileage ����
	public static void deleteMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		mileageService.deleteMileage(customer);
		System.out.println("���ϸ��� ���� �Ϸ�");
	}
		
	
}
