package edu.sp5.jvx330.cafe.item.business;

import java.util.List;

import edu.sp5.jvx330.cafe.item.domain.Item;

public interface ItemService {
	/**
	 * 1. �����޴�
	 */
	//1-1. �޴� �߰� 
	public void addMenu(Item item);
	
	//1-2. �޴� ����
	//1-2-1. �޴� �̸� ����
	public Item setMenuName(Item item, String menuName);
	
	//1-2-2. �޴� ���� ����
	public Item setMenuSales(Item item, Integer menuPrice);
	
	//1-3. �޴� ����
	public void deleteMenu(Item item);
	
	/**
	 * 2. �޴� ��ȸ
	 */
	//2-1. �޴� id ��ȸ
	public Long findMidByMenuName(String menuName);
	//2-2. ī�װ��� �޴� id ��ȸ
	public List<Long> findMidByCategory(String category);
	//2-3. �޴� �̸����� �޴� ��ȸ
	public Item findMenuByMenuName(String menuName);
	//2-4. ��ü �޴� ��ȸ
	public List<Item> findAllMenus();
	
	/**
	 * 3. �ֹ� ���
	 */
	//1. �ֹ� ��Ͽ� �޴� �߰�
	public List<Item> addOrderList(Item item);
	//2. �ֹ� ��Ͽ� �޴� ����
	public List<Item> deleteOrderList(int menuNum, List<Item> order_list);
}
