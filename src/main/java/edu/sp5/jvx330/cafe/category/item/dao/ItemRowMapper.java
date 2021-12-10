package edu.sp5.jvx330.cafe.category.item.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.jvx330.cafe.category.domain.Category;
import edu.sp5.jvx330.cafe.category.item.domain.Item;

public class ItemRowMapper implements RowMapper<Item> {

	@Override
	public Item mapRow(ResultSet rs, int rowNum) 
			throws SQLException {
		
		Category category = new Category();
		category.setCategoryId(rs.getLong("categoryId"));
		Item item = new Item(category, rs.getString("itemName"),
				rs.getInt("itemPrice"));
		item.setItemId(rs.getLong("itemId"));
		item.setItemUrl(rs.getString("itemUrl"));
		item.setRegDate(rs.getTimestamp("regDate"));
		
		return item;
	}
	
}
