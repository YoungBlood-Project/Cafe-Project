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

		//1. Total Mileage 값 변경
		//1-1. 마일리지 적립
		// addTotalMileage();
		//1-2. 마일리지 사용
		// subtractTotalMileage();
		//2. Total Mileage 조회
		// findTotalMileage();
		// deleteTotalMileage();

		context.close();
	}

	//1. Total Mileage 값 변경
	//1-1. 마일리지 적립
	public static void addTotalMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		mileageService.addTotalMileage(customer, 500);
		System.out.println("적립 완료");
	}
	
	//1-2. 마일리지 사용
	public static void subtractTotalMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		mileageService.subtractTotalMileage(customer, 200);
		System.out.println("사용 완료");
	}
	//2. Total Mileage 조회
	public static void findTotalMileage() {
		System.out.println("------------Total Mileage 조회------------");
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		System.out.println(customer);
		Integer totalMileage = mileageService.findTotalMileage(customer);
		System.out.println(totalMileage);
	}
	
	//3. Total Mileage 삭제
	public static void deleteTotalMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		mileageService.deleteTotalMileage(customer);
		System.out.println("삭제완료");
	}
		
	
}
