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
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(CustomerConfig.class);
		
		customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);
		
		addCustomer();
		//findCustomerByUserInfo();
		//findAllCustomers();
		//findTotalMileage();
		//deleteCustomer();

		context.close();
	}
	
	/**
	 * 1. �� ����
	 */
	// 1-1. �� ����
	public static void addCustomer() {
		Customer customer = new Customer("example", "example");
		customerService.addCustomer(customer);
		System.out.println("customerServiceTest: ���� �Ϸ�.");
	}
	
	/**
	 * 2. �� ���� ��ȸ
	 */
	// 2-1. �Է¹��� ������ �� ��ȸ
	public static void findCustomerByUserInfo() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		System.out.println("customerServiceTest: userInfo: " + customerService.findCustomerByUserInfo(customer.getName(), customer.getPhone()));
	}
	
	// 2-2. �� ��ü ��ȸ
	public static void findAllCustomers() {
		List<Customer> customer_list = customerService.findAllCustomers();
		for(Customer customer : customer_list) {
			System.out.println(customer);
		}
	}
	//2-3. �� ���ϸ��� ��ȸ
	public static void findTotalMileage() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		Integer totalMileage = customerService.findTotalMileage(customer);
		System.out.println("customerServiceTest ���ϸ��� ��ȸ"+totalMileage);
	}
	
	/**
	 * 3. �� ����
	 */
	public static void deleteCustomer() {
		Customer customer = customerService.findCustomerByUserInfo("example", "example");
		customerService.deleteCustomer(customer);
		System.out.println("customerService : ���� �Ϸ�.");
	}
}
