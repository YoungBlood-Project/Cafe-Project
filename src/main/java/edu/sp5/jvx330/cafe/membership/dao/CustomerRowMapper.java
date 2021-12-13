package edu.sp5.jvx330.cafe.membership.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.jvx330.cafe.customer.domain.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer(rs.getString("name"), rs.getString("phone"));
		customer.setCid(rs.getLong("cid"));
		customer.setRegDate(rs.getTimestamp("regDate"));
		
		return customer;
	}

}
