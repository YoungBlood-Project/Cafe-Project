package edu.sp5.jvx330.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.category.business.CategoryService;
import edu.sp5.jvx330.cafe.category.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.category.config.CategoryConfig;
import edu.sp5.jvx330.cafe.category.domain.Category;

public class CategoryServiceTest {
	private static CategoryService categoryService;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(CategoryConfig.class);
		
		categoryService = context.getBean("categoryServiceImpl", CategoryServiceImpl.class);

		addCategoryByCategoryName();
		//setCategoryName();
		findAllCategorys();
		
	}
	
	public static void addCategoryByCategoryName() {
		categoryService.addCategoryByCategoryName("deletedMenu");
		//categoryService.addCategoryByCategoryName("扼都Dao");
	}
	
	public static void setCategoryName() {
		Category category =	categoryService.findCategoryByCategoryName("扼都Dao");
		categoryService.setCategoryName(category, "胶公叼");
	}
	
	public static void findAllCategorys() {
		List<Category> category_list = categoryService.findAllCategorys();
		for(Category category : category_list) {
			System.out.println(category);
		}
	}
	
	public static void findCategoryByCategoryName() {
		categoryService.findCategoryByCategoryName("扼都Dao");
	}
}
