package edu.sp5.jvx330.cafe.totalMileage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.totalMileage.domain.TotalMileage;

public class TotalMileageRowMapper implements RowMapper<TotalMileage> {

	@Override
	public TotalMileage mapRow(ResultSet rs, int rowNum) throws SQLException {
		TotalMileage totalMileage = new TotalMileage(rs.getInt("mileageTotal"));
		totalMileage.setTmId(rs.getLong("tmId"));
		
		Customer customer = new Customer();
		customer.setCid(rs.getLong("customerId"));
		totalMileage.setCustomer(customer);
		
		return totalMileage;
	}

}
