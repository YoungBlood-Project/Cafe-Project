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
		mileageService = context.getBean("totalMileageServiceImpl", MileageServiceImpl.class);

		//1. Total Mileage �� ����
		//1-1. ���ϸ��� ����
		// addTotalMileage();
		//1-2. ���ϸ��� ���
		// subtractTotalMileage();
		//2. Total Mileage ��ȸ
		// findTotalMileage();
		// deleteTotalMileage();

		context.close();
		
	}

	//1. Total Mileage �� ����
	//1-1. ���ϸ��� ����
	public static void addTotalMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		mileageService.addTotalMileage(customer, 500);
		System.out.println("���� �Ϸ�");
	}
	
	//1-2. ���ϸ��� ���
	public static void subtractTotalMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		mileageService.subtractTotalMileage(customer, 200);
		System.out.println("��� �Ϸ�");
	}
	//2. Total Mileage ��ȸ
	public static void findTotalMileage() {
		System.out.println("------------Total Mileage ��ȸ------------");
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		System.out.println(customer);
		Integer totalMileage = mileageService.findTotalMileage(customer);
		System.out.println(totalMileage);
	}
	
	//3. Total Mileage ����
	public static void deleteTotalMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		mileageService.deleteTotalMileage(customer);
		System.out.println("�����Ϸ�");
	}
		
	
}
