package edu.sp5.jvx330.cafe.category.dao;

import java.util.List;

import edu.sp5.jvx330.cafe.category.domain.Category;

public interface CategoryDao {
	//1. ī�װ� �̸����� ī�װ� �߰�
	public void addCategoryByCategoryName();
	
	//2. ī�װ� �̸� ����
	public void setCategoryName(Category category,String categoryName);
	
	//3. ī�װ� ��ȸ
	public List<Category> findAllCategorys();
	
	//4. ī�װ� �̸����� ī�װ� ��ȸ
	public Category findCategoryByCategoryName(String categoryName);
}
