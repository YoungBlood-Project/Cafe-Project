package edu.sp5.jvx330.cafe.category.item.business;

import java.util.List;

import edu.sp5.jvx330.cafe.category.domain.Category;
import edu.sp5.jvx330.cafe.category.item.domain.Item;

public interface ItemService {
	/**
	 * 1. �����޴�
	 */
	//1-1. �޴� �߰� 
	public void addItem(Item item);
	
	//1-2. �޴� ����
	//1-2-1. �޴� �̸� ����
	public Item setItemName(Item item, String menuName);
	
	//1-2-2. �޴� ���� ����
	public Item setItemPrice(Item item, Integer menuPrice);
	
	//1-3. �޴� ����
	public void deleteItem(Item item);
	
	/**
	 * 2. �޴� ��ȸ
	 */
	//2-1. �޴� id ��ȸ
	public Long findMidByItemName(String menuName);
	//2-2. ī�װ��� �޴� id ��ȸ
	public List<Long> findMidByCategory(Category category);
	//2-3. �޴� �̸����� �޴� ��ȸ
	public Item findMenuByItemName(String itemName);
	//2-4. ��ü �޴� ��ȸ
	public List<Item> findAllItems();
	
	/**
	 * 3. �ֹ� ���
	 */
	//1. �ֹ� ��Ͽ� �޴� �߰�
	public List<Item> addOrderList(Item item);
	//2. �ֹ� ��Ͽ� �޴� ����
	public List<Item> deleteOrderList(int menuNum, List<Item> order_list);
}
