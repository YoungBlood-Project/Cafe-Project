package edu.sp5.jvx330.cafe.customer.mileage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileage.domain.Mileage;

public class MileageRowMapper implements RowMapper<Mileage> {

	@Override
	public Mileage mapRow(ResultSet rs, int rowNum) throws SQLException {
		Mileage mileage = new Mileage(rs.getInt("mTotal"));
		mileage.setmId(rs.getLong("mId"));
		
		Customer customer = new Customer();
		customer.setCid(rs.getLong("customerId"));
		mileage.setCustomer(customer);
		
		return mileage;
	}

}
