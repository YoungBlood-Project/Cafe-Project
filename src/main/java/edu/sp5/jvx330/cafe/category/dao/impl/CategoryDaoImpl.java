package edu.sp5.jvx330.cafe.category.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.sp5.jvx330.cafe.category.dao.CategoryDao;
import edu.sp5.jvx330.cafe.category.dao.CategoryRowMapper;
import edu.sp5.jvx330.cafe.category.domain.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	/**
	 * 코드 작성 - 정혜윤(develop-jhy)
	 */
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 1. 카테고리 이름으로 카테고리 추가
	@Override
	public void addCategoryByCategoryName(String categoryName) {
		String sql = "INSERT INTO Category(categoryName)" 
					+ "VALUES(?)";
		
		jdbcTemplate.update(sql, categoryName);	
	}

	// 2. 카테고리 이름 변경
	@Override
	public Category setCategoryName(Category category, String categoryName) {
		String sql = "UPDATE Category SET categoryName = ? WHERE categoryId = ?";
		
		jdbcTemplate.update(sql, categoryName, category.getCategoryId());
		
		category.setCategoryName(categoryName);
		return category;
	}

	// 3. 카테고리 조회
	@Override
	public List<Category> findAllCategorys() {
		String sql = "SELECT categoryId, categoryName FROM Category";
		
		return jdbcTemplate.query(sql, new CategoryRowMapper());
	}

	// 4. 카테고리 이름으로 카테고리 조회
	@Override
	public Category findCategoryByCategoryName(String categoryName) {
		String sql = "SELECT categoryId, categoryName FROM Category WHERE categoryName = ?";
		
		return jdbcTemplate.queryForObject(sql, new CategoryRowMapper(), categoryName);
	}

}
