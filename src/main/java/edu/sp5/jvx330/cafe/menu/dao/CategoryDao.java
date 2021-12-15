package edu.sp5.jvx330.cafe.menu.dao;

import java.util.List;

import edu.sp5.jvx330.cafe.menu.domain.Category;

public interface CategoryDao {
	//1. ī�װ� �̸����� ī�װ� �߰�
	public void addCategoryByCategoryName(String categoryName);
	
	//2. ī�װ� �̸� ����
	public Category setCategoryName(Category category,String categoryName);
	
	//3. ī�װ� ��ȸ
	public List<Category> findAllCategorys();
	
	//4. ī�װ� �̸����� ī�װ� ��ȸ
	public Category findCategoryByCategoryName(String categoryName);
	
	//5.(�ֹ���ȣ�� �Ǹų����� ���� �߰�) ī�װ� id�� ī�װ� �̸� ��ȸ
	public String findCategoryByCategoryId(Long categoryId);
}
