package edu.sp5.jvx330.cafe.menu.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.menu.business.CategoryService;
import edu.sp5.jvx330.cafe.menu.dao.CategoryDao;
import edu.sp5.jvx330.cafe.menu.domain.Category;


public class CategoryServiceImpl implements CategoryService {
	/**
	 * ÄÚµå ÀÛ¼º - Á¤ÇýÀ±(develop-jhy)
	 */
	@Autowired
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
	
	@Override
	public Category findCategoryByCategoryId(Long categoryId) {
		return cDao.findCategoryByCategoryId(categoryId);
	};
	
}
