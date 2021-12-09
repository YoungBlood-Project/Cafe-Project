package edu.sp5.jvx330.cafe.category.item.dao;

import java.util.List;

import edu.sp5.jvx330.cafe.category.domain.Category;
import edu.sp5.jvx330.cafe.category.item.domain.Item;

public interface ItemDao {
	/**
	 * 1. �����޴�
	 */
	//1-1. �޴� �߰� 
	public void addItem(Item item);
	
	//1-2. �޴� ����
	//�޴� �̸� ����
	public Item setItemName(Item item, String itemName);
	
	//�޴� ���� ����
	public Item setItemPrice(Item item, Integer itemPrice);
	
	//1-3. �޴� ����(�޴� �̸����� ����)
	public void deleteItem(String itemName);
	
	/**
	 * 2. �޴� ��ȸ
	 */
	//2-1. �޴� id ��ȸ(�޴� �̸����� ��ȸ)
	//SalesHistoryServiceImpl���� ���
	public Long findItemIdByItemName(String itemName);
	//2-2. ī�װ��� �޴� ��ȸ
	public List<Item> findItemIdByCategory(Category category);
	//2-3. �޴��̸����� �޴� ��ȸ
	public Item findItemByItemName(String itemName);
	//2-4. ��ü �޴� ��ȸ
	public List<Item> findAllItems();
}
