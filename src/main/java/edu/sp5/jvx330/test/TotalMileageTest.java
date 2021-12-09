package edu.sp5.jvx330.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.customer.business.CustomerService;
import edu.sp5.jvx330.cafe.customer.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.totalMileage.business.TotalMileageService;
import edu.sp5.jvx330.cafe.customer.totalMileage.business.impl.TotalMileageServiceImpl;
import edu.sp5.jvx330.cafe.customer.totalMileage.config.TotalMileageConfig;

public class TotalMileageTest {
	private static CustomerService customerService;
	private static TotalMileageService totalMileageService;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(TotalMileageConfig.class);
		
		customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);
		totalMileageService = context.getBean("totalMileageServiceImpl", TotalMileageServiceImpl.class);

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
		totalMileageService.addTotalMileage(customer, 500);
		System.out.println("적립 완료");
	}
	
	//1-2. 마일리지 사용
	public static void subtractTotalMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		totalMileageService.subtractTotalMileage(customer, 200);
		System.out.println("사용 완료");
	}
	//2. Total Mileage 조회
	public static void findTotalMileage() {
		System.out.println("------------Total Mileage 조회------------");
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		System.out.println(customer);
		Integer totalMileage = totalMileageService.findTotalMileage(customer);
		System.out.println(totalMileage);
	}
	
	//3. Total Mileage 삭제
	public static void deleteTotalMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		totalMileageService.deleteTotalMileage(customer);
		System.out.println("삭제완료");
	}
		
	
}
