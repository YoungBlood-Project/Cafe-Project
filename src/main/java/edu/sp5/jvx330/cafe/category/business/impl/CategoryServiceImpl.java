package edu.sp5.jvx330.cafe.category.business.impl;

import java.util.List;

import edu.sp5.jvx330.cafe.category.business.CategoryService;
import edu.sp5.jvx330.cafe.category.dao.CategoryDao;
import edu.sp5.jvx330.cafe.category.domain.Category;

public class CategoryServiceImpl implements CategoryService {
	/**
	 * �ڵ� �ۼ� - ������(develop-jhy)
	 */
	
	private CategoryDao cDao;
	

	@Override
	public void addCategoryByCategoryName(String categoryName) {
		cDao.addCategoryByCategoryName(categoryName);
	}

	@Override
	public Category setCategoryName(Category category, String categoryName) {
		return cDao.setCategoryName(category, categoryName);	
	}

	@Override
	public List<Category> findAllCategorys() {
		return cDao.findAllCategorys();
	}

	@Override
	public Category findCategoryByCategoryName(String categoryName) {
		return cDao.findCategoryByCategoryName(categoryName);
	}
	
}
