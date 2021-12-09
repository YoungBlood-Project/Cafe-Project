package edu.sp5.jvx330.cafe.category.item.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.jvx330.cafe.category.item.domain.Item;
import edu.sp5.jvx330.cafe.customer.domain.Customer;

public class ItemRowMapper implements RowMapper<Item> {

	@Override
	public Item mapRow(ResultSet rs, int rowNum) 
			throws SQLException {
		
		Item item = new Item(rs.getString("menuName"),
				rs.getInt("menuPrice"));
		item.setItemId(rs.getLong("itemId"));
		
		return item;
	}
	
}
