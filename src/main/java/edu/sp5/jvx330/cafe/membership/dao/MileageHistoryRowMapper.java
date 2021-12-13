	package edu.sp5.jvx330.cafe.membership.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileageHistory.domain.MileageHistory;

public class MileageHistoryRowMapper implements RowMapper<MileageHistory> {

	public MileageHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setCid(rs.getLong("customerId"));
		
		MileageHistory mileage = new MileageHistory(customer, rs.getLong("orderNum"), rs.getInt("mBalance"));
		
		mileage.setMhId(rs.getLong("mhId"));
		mileage.setRegDate(rs.getTimestamp("regDate"));
		
		return mileage;
	}
}
