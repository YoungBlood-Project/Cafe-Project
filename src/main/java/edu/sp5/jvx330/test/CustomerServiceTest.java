package edu.sp5.jvx330.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.config.CustomerConfig;
import edu.sp5.jvx330.cafe.membership.business.CustomerService;
import edu.sp5.jvx330.cafe.membership.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.membership.domain.Customer;


public class CustomerServiceTest {
	private static CustomerService customerService;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CustomerConfig.class);

		customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);
		
		/**
		 * Test - ������(develop-jhy)
		 */

		//1. �� ����
		//addCustomer();

		//2. �� ���� ��ȸ
		//findCustomerByUserInfo();
		findAllCustomers();
		//findMileage();

		//3. �� ����
		//deleteCustomer();

		context.close();
	}

	/**
	 * 1. �� ����
	 */
	// 1-1. �� ����
	public static void addCustomer() {
		 Customer customer = new Customer("example_ex1", "example_ex1");
//		 Customer customer = new Customer("example_ex2", "example_ex2");
//		Customer customer = new Customer("example_ex3", "example_ex3");
		customerService.addCustomer(customer);
		System.out.println("customerServiceTest: ���� �Ϸ�.");
	}

	/**
	 * 2. �� ���� ��ȸ
	 */
	// 2-1. �Է¹��� ������ �� ��ȸ
	public static void findCustomerByUserInfo() {
		Customer customer = customerService.findCustomerByUserInfo("example_ex1", "example_ex1");
		System.out.println("customerServiceTest, userInfo: "
				+ customerService.findCustomerByUserInfo(customer.getName(), customer.getPhone()));
	}

	// 2-2. �� ��ü ��ȸ
	public static void findAllCustomers() {
		List<Customer> customer_list = customerService.findAllCustomers();
		for (Customer customer : customer_list) {
			System.out.println(customer);
		}
	}

	// 2-3. �� ���ϸ��� ��ȸ
	public static void findMileage() {
		Customer customer = customerService.findCustomerByUserInfo("A", "1");
		Integer totalMileage = customerService.findMileage(customer);
		System.out.println("customerServiceTest ���ϸ��� ��ȸ" + totalMileage);
	}

	/**
	 * 3. �� ����
	 */
	public static void deleteCustomer() {
		Customer customer = customerService.findCustomerByUserInfo("example_ex1", "example_ex1");
		customerService.deleteCustomer(customer);
		System.out.println("customerService : ���� �Ϸ�.");
	}

}
