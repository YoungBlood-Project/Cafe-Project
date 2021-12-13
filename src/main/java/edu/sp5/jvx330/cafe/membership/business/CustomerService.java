package edu.sp5.jvx330.cafe.membership.business;

import java.util.List;

import edu.sp5.jvx330.cafe.customer.domain.Customer;

public interface CustomerService {
	/**
	 * 1. 고객 생성
	 * @param customer
	 */
	public void addCustomer(Customer customer);
	   
	/**
	 * 2. 고객 정보 조회
	 * @param name
	 * @param phone
	 * @return
	 */
	//2-1. 입력받은 정보로 고객 조회
	public Customer findCustomerByUserInfo(String name, String phone);
	//2-2. 고객 전체 조회
	public List<Customer> findAllCustomers();
	//2-3. 고객 마일리지 조회
	public Integer findMileage(Customer customer);
	
	/**
	 * 3. 고객 삭제
	 * @param customer
	 */
	public void deleteCustomer(Customer customer);
}
