package edu.sp5.jvx330.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.customer.business.CustomerService;
import edu.sp5.jvx330.cafe.customer.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.mileage.business.MileageSerivce;
import edu.sp5.jvx330.cafe.mileage.business.impl.MileageServiceImpl;
import edu.sp5.jvx330.cafe.totalMileage.business.TotalMileageService;
import edu.sp5.jvx330.cafe.totalMileage.business.impl.TotalMileageServiceImpl;
import edu.sp5.jvx330.cafe.totalMileage.config.TotalMileageConfig;
import edu.sp5.jvx330.cafe.totalMileage.domain.TotalMileage;
import edu.sp5.jvx330.cafe.mileage.config.MileageConfig;

public class TotalMileageTest {
	private static CustomerService customerService;
	private static MileageSerivce mileageService;
	private static TotalMileageService totalMileageService;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(TotalMileageConfig.class);
		
		mileageService = context.getBean("mileageServiceImpl", MileageServiceImpl.class);
		customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);
		totalMileageService = context.getBean("totalMileageServiceImpl", TotalMileageServiceImpl.class);

		addTotalMileage();
		//findTotalMileage();
		//deleteTotalMileage();

		context.close();
		
	}

	//1. Total Mileage 값 입력
	public static void addTotalMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		totalMileageService.addTotalMileage(customer, 500);
	}
		
	public static void setTotalMileage(Customer customer, Integer addMileage) {
		
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
