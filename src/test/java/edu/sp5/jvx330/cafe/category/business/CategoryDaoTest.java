package edu.sp5.jvx330.cafe.category.business;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import edu.sp5.jvx330.cafe.config.CategoryConfig;
import edu.sp5.jvx330.cafe.menu.dao.CategoryDao;

@SpringJUnitConfig(classes = {CategoryConfig.class})
public class CategoryDaoTest {
	@Autowired
	private CategoryDao dao;
	
	@Test
	//@Transactional
	//@Commit
	public void findCategoryByCategoryName() {
		assertTrue(dao.findCategoryByCategoryName("¶ó¶¼Dao").getCategoryName().equals("¶ó¶¼Dao"));
	}	
}