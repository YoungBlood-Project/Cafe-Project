package edu.sp5.jvx330.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.config.CategoryConfig;
import edu.sp5.jvx330.cafe.menu.business.CategoryService;
import edu.sp5.jvx330.cafe.menu.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.menu.domain.Category;


public class CategoryServiceTest {
	private static CategoryService categoryService;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(CategoryConfig.class);
		
		categoryService = context.getBean("categoryServiceImpl", CategoryServiceImpl.class);

		//addCategoryByCategoryName();
		//setCategoryName();
		//findAllCategorys();
		//findCategoryByCategoryId();
		
		context.close();
	}
	
	//전체 카테고리 추가 메소드
	public static void addCategoryByCategoryName() {
		categoryService.addCategoryByCategoryName("deletedMenu");
		categoryService.addCategoryByCategoryName("Coffee");
		categoryService.addCategoryByCategoryName("Tea");
		categoryService.addCategoryByCategoryName("Drink");
		categoryService.addCategoryByCategoryName("Cake");
		categoryService.addCategoryByCategoryName("Meal");
		categoryService.addCategoryByCategoryName("Bread");
		categoryService.addCategoryByCategoryName("MD");
		
		System.out.println("CategoryServiceTest: 저장 완료.");
	}
	
	public static void setCategoryName() {
		Category category =	categoryService.findCategoryByCategoryName("라떼Dao");
		categoryService.setCategoryName(category, "스무디");
	}
	
	public static void findAllCategorys() {
		List<Category> category_list = categoryService.findAllCategorys();
		for(Category category : category_list) {
			System.out.println(category);
		}
	}
	
	public static void findCategoryByCategoryName() {
		categoryService.findCategoryByCategoryName("Coffee");
	}
	
	public static void findCategoryByCategoryId() {
		System.out.println(categoryService.findCategoryByCategoryId(2l));
	}
}
