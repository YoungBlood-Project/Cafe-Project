package edu.sp5.jvx330.cafe.category.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.category.dao.CategoryDao;
import edu.sp5.jvx330.cafe.category.domain.Category;

public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//1. 카테고리 이름으로 카테고리 추가
	@Override
	public void addCategoryByCategoryName(String categoryName) {
		String sql = "INSERT INTO Category(categoryName)" 
					+ "VALUES(?)";
		
		
		jdbcTemplate.update(sql, categoryName);	
	}

	//2. 카테고리 이름 변경
	@Override
	public void setCategoryName(Category category, String categoryName) {
		// TODO Auto-generated method stub
		
	}

	//3. 카테고리 조회
	@Override
	public List<Category> findAllCategorys() {
		// TODO Auto-generated method stub
		return null;
	}

	//4. 카테고리 이름으로 카테고리 조회
	@Override
	public Category findCategoryByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

}
