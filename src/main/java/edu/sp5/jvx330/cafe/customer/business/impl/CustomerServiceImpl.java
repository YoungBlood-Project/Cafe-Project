package edu.sp5.jvx330.cafe.customer.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.customer.business.CustomerService;
import edu.sp5.jvx330.cafe.customer.dao.impl.CustomerDaoImpl;
import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileageHistory.dao.impl.MileageDaoImpl;
import edu.sp5.jvx330.cafe.customer.totalMileage.business.impl.TotalMileageServiceImpl;

public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDaoImpl customerDao;
	@Autowired
	private MileageDaoImpl mileageDao;
	@Autowired
	private TotalMileageServiceImpl tmService;

	/**
	 * 1. �� ����
	 * 
	 * @param customer
	 */
	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	/**
	 * 2. �� ���� ��ȸ
	 * 
	 * @param name
	 * @param phone
	 * @return
	 */
	// 2-1. �Է¹��� ������ �� ��ȸ
	@Override
	public Customer findCustomerByUserInfo(String name, String phone) {
		return customerDao.findCustomerByUserInfo(name, phone);
	}

	// 2-2. �� ��ü ��ȸ
	@Override
	public List<Customer> findAllCustomers() {
		return customerDao.findAllCustomers();
	}
	
	//2-3. �� ���ϸ��� ��ȸ
	@Override
	public Integer findTotalMileage(Customer customer) {
		return tmService.findTotalMileage(customer);
	}

	/**
	 * 3. �� ����
	 * 
	 * @param customer
	 */
	@Override
	public void deleteCustomer(Customer customer) {
		mileageDao.deleteMileageHistory(customer);
		customerDao.deleteCustomer(customer);
		tmService.deleteTotalMileage(customer);
	}
}
