	package edu.sp5.jvx330.cafe.mileage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.mileage.domain.Mileage;

public class MileageRowMapper implements RowMapper<Mileage> {

	public Mileage mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setCid(rs.getLong("customerId"));
		
		Mileage mileage = new Mileage(customer, rs.getLong("orderNum"), rs.getInt("mBalance"));
		
		mileage.setMileageId(rs.getLong("mileageId"));
		mileage.setRegDate(rs.getTimestamp("regDate"));
		
		return mileage;
	}
}
