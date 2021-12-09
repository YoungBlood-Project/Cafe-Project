package edu.sp5.jvx330.cafe.category.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.jvx330.cafe.category.domain.Category;

public class CategoryRowMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		Category category = new Category(rs.getString("categoryName"));
		category.setCategoryId(rs.getLong("categoryId"));
		
		return category;
	}
	
}
