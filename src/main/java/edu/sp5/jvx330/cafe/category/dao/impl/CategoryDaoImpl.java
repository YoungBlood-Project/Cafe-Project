package edu.sp5.jvx330.cafe.category.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.category.dao.CategoryDao;
import edu.sp5.jvx330.cafe.category.domain.Category;

public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//1. ī�װ� �̸����� ī�װ� �߰�
	@Override
	public void addCategoryByCategoryName(String categoryName) {
		String sql = "INSERT INTO Category(categoryName)" 
					+ "VALUES(?)";
		
		
		jdbcTemplate.update(sql, categoryName);	
	}

	//2. ī�װ� �̸� ����
	@Override
	public void setCategoryName(Category category, String categoryName) {
		// TODO Auto-generated method stub
		
	}

	//3. ī�װ� ��ȸ
	@Override
	public List<Category> findAllCategorys() {
		// TODO Auto-generated method stub
		return null;
	}

	//4. ī�װ� �̸����� ī�װ� ��ȸ
	@Override
	public Category findCategoryByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

}
