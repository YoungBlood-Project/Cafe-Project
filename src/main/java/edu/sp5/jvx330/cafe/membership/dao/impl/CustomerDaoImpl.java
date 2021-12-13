package edu.sp5.jvx330.cafe.membership.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.membership.dao.CustomerDao;
import edu.sp5.jvx330.cafe.membership.dao.CustomerRowMapper;
import edu.sp5.jvx330.cafe.membership.domain.Customer;

public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 1. 고객 생성
	 * @param customer
	 */
	@Override
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer(name, phone) "
				+ "VALUES(?, ?)";
		
		
		jdbcTemplate.update(sql, customer.getName(), customer.getPhone());
	}

	/**
	 * 2. 고객 정보 조회
	 * @param name
	 * @param phone
	 * @return
	 */
	//2-1. 입력받은 정보로 고객 조회
	@Override
	public Customer findCustomerByUserInfo(String name, String phone) {
		String sql = "SELECT cid, name, phone, regDate FROM Customer"
				+ " WHERE name = ? AND phone = ?";
		return jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), name, phone);
	}
	//2-2. 고객 전체 조회
	@Override
	public List<Customer> findAllCustomers() {
		String sql = "SELECT cid, name, phone, regDate FROM Customer";
		
		return jdbcTemplate.query(sql, new CustomerRowMapper());
	}
	
	/**3. 고객 삭제
	 * @param customer
	 */
	@Override
	public void deleteCustomer(Customer customer) {
		String sql = "DELETE FROM Customer WHERE cid =?";
		
		jdbcTemplate.update(sql, customer.getCid());
	}
}
