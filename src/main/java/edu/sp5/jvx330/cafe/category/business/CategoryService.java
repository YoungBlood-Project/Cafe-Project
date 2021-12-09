package edu.sp5.jvx330.cafe.category.business;

import java.util.List;

import edu.sp5.jvx330.cafe.category.domain.Category;

public interface CategoryService {
	//1. ī�װ� �̸����� ī�װ� �߰�
	public void addCategoryByCategoryName(String categoryName);
	
	//2. ī�װ� �̸� ����
	public Category setCategoryName(Category category,String categoryName);
	
	//3. ī�װ� ��ȸ
	public List<Category> findAllCategorys();
	
	/**
	 * �ڵ� �߰� - ������(develop-jhy)
	 * @return
	 */
	// 4. ī�װ� �̸����� ī�װ� ��ȸ
	public Category findCategoryByCategoryName(String categoryName);
}
