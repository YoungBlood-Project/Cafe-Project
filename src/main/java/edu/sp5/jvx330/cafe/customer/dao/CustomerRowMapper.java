package edu.sp5.jvx330.cafe.customer.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.jvx330.cafe.customer.domain.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setCid(rs.getLong("cid"));
		customer.setName(rs.getString("name"));
		customer.setPhone(rs.getString("phone"));
		
		return customer;
	}

}
