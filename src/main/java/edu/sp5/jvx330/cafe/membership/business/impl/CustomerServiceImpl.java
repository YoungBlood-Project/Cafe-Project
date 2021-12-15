package edu.sp5.jvx330.cafe.membership.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.membership.business.CustomerService;
import edu.sp5.jvx330.cafe.membership.dao.impl.CustomerDaoImpl;
import edu.sp5.jvx330.cafe.membership.dao.impl.MileageHistoryDaoImpl;
import edu.sp5.jvx330.cafe.membership.domain.Customer;

public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDaoImpl customerDao;
	@Autowired
	private MileageHistoryDaoImpl mileageDao;
	@Autowired
	private MileageServiceImpl tmService;

	/**
	 * 1. 고객 생성
	 * 
	 * @param customer
	 */
	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	/**
	 * 2. 고객 정보 조회
	 * 
	 * @param name
	 * @param phone
	 * @return
	 */
	// 2-1. 입력받은 정보로 고객 조회
	@Override
	public Customer findCustomerByUserInfo(String name, String phone)  {
		return customerDao.findCustomerByUserInfo(name, phone);
	}

	// 2-2. 고객 전체 조회
	@Override
	public List<Customer> findAllCustomers() {
		return customerDao.findAllCustomers();
	}
	
	//2-3. 고객 마일리지 조회
	@Override
	public Integer findMileage(Customer customer) {
		return tmService.findMileage(customer);
	}

	/**
	 * 3. 고객 삭제
	 * 
	 * @param customer
	 */
	@Override
	public void deleteCustomer(Customer customer) {
		mileageDao.deleteMileageHistory(customer);
		customerDao.deleteCustomer(customer);
		tmService.deleteMileage(customer);
	}
}
