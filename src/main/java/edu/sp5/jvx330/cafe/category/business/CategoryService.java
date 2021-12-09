package edu.sp5.jvx330.cafe.category.business;

import java.util.List;

import edu.sp5.jvx330.cafe.category.domain.Category;

public interface CategoryService {
	//1. 카테고리 이름으로 카테고리 추가
	public void addCategoryByCategoryName(String categoryName);
	
	//2. 카테고리 이름 변경
	public Category setCategoryName(Category category,String categoryName);
	
	//3. 카테고리 조회
	public List<Category> findAllCategorys();
	
	/**
	 * 코드 추가 - 정혜윤(develop-jhy)
	 * @return
	 */
	// 4. 카테고리 이름으로 카테고리 조회
	public Category findCategoryByCategoryName(String categoryName);
}
