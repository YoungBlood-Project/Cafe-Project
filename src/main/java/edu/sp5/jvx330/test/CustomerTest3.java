package edu.sp5.jvx330.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.customer.business.CustomerService;
import edu.sp5.jvx330.cafe.customer.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.customer.config.CustomerConfig;

public class CustomerTest3 {
private static CustomerService customerService;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(CustomerConfig.class);
		
		customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);

		context.close();
	}
}
