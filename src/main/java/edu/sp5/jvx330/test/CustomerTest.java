package edu.sp5.jvx330.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.customer.business.CustomerService;
import edu.sp5.jvx330.cafe.customer.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.customer.config.CustomerConfig;
import edu.sp5.jvx330.cafe.customer.domain.Customer;

public class CustomerTest {
	private static CustomerService customerService;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CustomerConfig.class);

		customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);

		/**
		 * Test - 정혜윤(develop-jhy)
		 */

		// 1. 고객 생성
		// addCustomer();

		// 2. 고객 정보 조회
		// findCustomerByUserInfo();
		// findAllCustomers();
		// findTotalMileage();

		// 3. 고객 삭제
		// deleteCustomer();

		context.close();
	}

	/**
	 * 1. 고객 생성
	 */
	// 1-1. 고객 생성
	public static void addCustomer() {
		Customer customer = new Customer("A", "1");
		customerService.addCustomer(customer);
		System.out.println("customerServiceTest: 저장 완료.");
	}

	/**
	 * 2. 고객 정보 조회
	 */
	// 2-1. 입력받은 정보로 고객 조회
	public static void findCustomerByUserInfo() {
		Customer customer = customerService.findCustomerByUserInfo("A", "1");
		System.out.println("customerServiceTest: userInfo: "
				+ customerService.findCustomerByUserInfo(customer.getName(), customer.getPhone()));
	}

	// 2-2. 고객 전체 조회
	public static void findAllCustomers() {
		List<Customer> customer_list = customerService.findAllCustomers();
		for (Customer customer : customer_list) {
			System.out.println(customer);
		}
	}

	// 2-3. 고객 마일리지 조회
	public static void findTotalMileage() {
		Customer customer = customerService.findCustomerByUserInfo("A", "1");
		Integer totalMileage = customerService.findTotalMileage(customer);
		System.out.println("customerServiceTest 마일리지 조회" + totalMileage);
	}

	/**
	 * 3. 고객 삭제
	 */
	public static void deleteCustomer() {
		Customer customer = customerService.findCustomerByUserInfo("A", "1");
		customerService.deleteCustomer(customer);
		System.out.println("customerService : 삭제 완료.");
	}

}
