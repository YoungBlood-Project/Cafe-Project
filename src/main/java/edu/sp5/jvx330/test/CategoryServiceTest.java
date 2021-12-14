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

		addCategoryByCategoryName();
		//setCategoryName();
		//findAllCategorys();
		
		context.close();
	}
	
	//��ü ī�װ� �߰� �޼ҵ�
	public static void addCategoryByCategoryName() {
		categoryService.addCategoryByCategoryName("deletedMenu");
		categoryService.addCategoryByCategoryName("Coffee");
		categoryService.addCategoryByCategoryName("Tea");
		categoryService.addCategoryByCategoryName("Drink");
		categoryService.addCategoryByCategoryName("Cake");
		categoryService.addCategoryByCategoryName("Meal");
		categoryService.addCategoryByCategoryName("Bread");
		categoryService.addCategoryByCategoryName("MD");
		
		System.out.println("CategoryServiceTest: ���� �Ϸ�.");
	}
	
	public static void setCategoryName() {
		Category category =	categoryService.findCategoryByCategoryName("��Dao");
		categoryService.setCategoryName(category, "������");
	}
	
	public static void findAllCategorys() {
		List<Category> category_list = categoryService.findAllCategorys();
		for(Category category : category_list) {
			System.out.println(category);
		}
	}
	
	public static void findCategoryByCategoryName() {
		categoryService.findCategoryByCategoryName("��Dao");
	}
}
