package edu.sp5.jvx330.cafe.category.SalesTotalPrice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import edu.sp5.jvx330.cafe.category.SalesTotalPrice.domain.SalesTotalPrice;
import edu.sp5.jvx330.cafe.category.item.domain.Item;
import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileage.domain.Mileage;

public class SalesTotalPriceRowMapper implements RowMapper<SalesTotalPrice> {

	@Override
	public SalesTotalPrice mapRow(ResultSet rs, int rowNum) throws SQLException {
		SalesTotalPrice stp = new SalesTotalPrice();
		
		
		//Item item = new Item();
		//item.setItemId(rs.getLong("itemId"));
		
		//Mileage mileage = new Mileage(rs.getInt("mTotal"));
		//mileage.setmId(rs.getLong("mId"));
		
		//Customer customer = new Customer();
		//customer.setCid(rs.getLong("customerId"));
		//mileage.setCustomer(customer);
		
		return stp;
	}

}
