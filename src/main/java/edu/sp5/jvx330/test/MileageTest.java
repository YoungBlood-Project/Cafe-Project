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

		// 1. Mileage 값 변경
		//  1-1. 마일리지 적립
		// addMileage();
		//  1-2. 마일리지 사용
		// subtractMileage();
		 
		// 2. Mileage 조회
		// findTotalMileage();
		 
		// 3. Mileage 삭제 
		// deleteTotalMileage();

		context.close();
	}

	// 1. Mileage 값 변경
	//  1-1. 마일리지 적립
	public static void addMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example_ex1", "example_ex1");
		mileageService.addMileage(customer, 500);
		System.out.println("마일리지 적립 완료");
	}
	
	//  1-2. 마일리지 사용
	public static void subtractMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		mileageService.subtractMileage(customer, 200);
		System.out.println("마일리지 사용 완료");
	}
	// 2. Mileage 조회
	public static void findMileage() {
		System.out.println("------------ Mileage 조회------------");
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		System.out.println(customer);
		Integer totalMileage = mileageService.findMileage(customer);
		System.out.println(totalMileage);
	}
	
	// 3. Mileage 삭제
	public static void deleteMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		mileageService.deleteMileage(customer);
		System.out.println("마일리지 삭제 완료");
	}
		
	
}
