package edu.sp5.jvx330.cafe.category.dao;

import java.util.List;

import edu.sp5.jvx330.cafe.category.domain.Category;

public interface CategoryDao {
	//1. 카테고리 이름으로 카테고리 추가
	public void addCategoryByCategoryName(String categoryName);
	
	//2. 카테고리 이름 변경
	public void setCategoryName(Category category,String categoryName);
	
	//3. 카테고리 조회
	public List<Category> findAllCategorys();
	
	//4. 카테고리 이름으로 카테고리 조회
	public Category findCategoryByCategoryName(String categoryName);
}
