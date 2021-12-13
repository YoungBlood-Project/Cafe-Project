package edu.sp5.jvx330.cafe.membership.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.customer.dao.CustomerDao;
import edu.sp5.jvx330.cafe.customer.dao.CustomerRowMapper;
import edu.sp5.jvx330.cafe.customer.domain.Customer;

public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 1. �� ����
	 * @param customer
	 */
	@Override
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer(name, phone) "
				+ "VALUES(?, ?)";
		
		
		jdbcTemplate.update(sql, customer.getName(), customer.getPhone());
	}

	/**
	 * 2. �� ���� ��ȸ
	 * @param name
	 * @param phone
	 * @return
	 */
	//2-1. �Է¹��� ������ �� ��ȸ
	@Override
	public Customer findCustomerByUserInfo(String name, String phone) {
		String sql = "SELECT cid, name, phone, regDate FROM Customer"
				+ " WHERE name = ? AND phone = ?";
		return jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), name, phone);
	}
	//2-2. �� ��ü ��ȸ
	@Override
	public List<Customer> findAllCustomers() {
		String sql = "SELECT cid, name, phone, regDate FROM Customer";
		
		return jdbcTemplate.query(sql, new CustomerRowMapper());
	}
	
	/**3. �� ����
	 * @param customer
	 */
	@Override
	public void deleteCustomer(Customer customer) {
		String sql = "DELETE FROM Customer WHERE cid =?";
		
		jdbcTemplate.update(sql, customer.getCid());
	}
}
