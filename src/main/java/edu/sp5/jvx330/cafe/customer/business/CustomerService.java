package edu.sp5.jvx330.cafe.customer.business;

import java.util.List;

import edu.sp5.jvx330.cafe.customer.domain.Customer;

public interface CustomerService {
	/**
	 * 1. �� ����
	 * @param customer
	 */
	public void addCustomer(Customer customer);
	   
	/**
	 * 2. �� ���� ��ȸ
	 * @param name
	 * @param phone
	 * @return
	 */
	//2-1. �Է¹��� ������ �� ��ȸ
	public Customer findCustomerByUserInfo(String name, String phone);
	//2-2. �� ��ü ��ȸ
	public List<Customer> findAllCustomers();
	//2-3. �� ���ϸ��� ��ȸ
	public Integer findMileage(Customer customer);
	
	/**
	 * 3. �� ����
	 * @param customer
	 */
	public void deleteCustomer(Customer customer);
}
