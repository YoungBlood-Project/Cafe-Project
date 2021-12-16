package edu.sp5.jvx330.cafe.menu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.sp5.jvx330.cafe.menu.dao.CategoryDao;
import edu.sp5.jvx330.cafe.menu.dao.CategoryRowMapper;
import edu.sp5.jvx330.cafe.menu.domain.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	/**
	 * �ڵ� �ۼ� - ������(develop-jhy)
	 */
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 1. ī�װ� �̸����� ī�װ� �߰�
	@Override
	public void addCategoryByCategoryName(String categoryName) {
		String sql = "INSERT INTO Category(categoryName)" 
					+ "VALUES(?)";
		
		jdbcTemplate.update(sql, categoryName);	
	}

	// 2. ī�װ� �̸� ����
	@Override
	public Category setCategoryName(Category category, String categoryName) {
		String sql = "UPDATE Category SET categoryName = ? WHERE categoryId = ?";
		
		jdbcTemplate.update(sql, categoryName, category.getCategoryId());
		
		category.setCategoryName(categoryName);
		return category;
	}

	// 3. ī�װ� ��ȸ
	@Override
	public List<Category> findAllCategorys() {
		String sql = "SELECT categoryId, categoryName FROM Category ORDER BY 2";
		
		return jdbcTemplate.query(sql, new CategoryRowMapper());
	}

	// 4. ī�װ� �̸����� ī�װ� ��ȸ
	@Override
	public Category findCategoryByCategoryName(String categoryName) {
		String sql = "SELECT categoryId, categoryName FROM Category WHERE categoryName = ?";
		
		return jdbcTemplate.queryForObject(sql, new CategoryRowMapper(), categoryName);
	}
	
	
	//5. ī�װ� id�� ī�װ� ��ȸ
	@Override
	public Category findCategoryByCategoryId(Long categoryId) {
		String sql = "SELECT categoryId, categoryName FROM Category WHERE categoryId = ?";
		
		return jdbcTemplate.queryForObject(sql, new CategoryRowMapper(), categoryId);
	};

}
