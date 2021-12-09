package edu.sp5.jvx330.cafe.item.dao;

import java.util.List;

import edu.sp5.jvx330.cafe.item.domain.Item;

public interface ItemDao {
	/**
	 * 1. �����޴�
	 */
	//1-1. �޴� �߰� 
	public void addMenu(Item item);
	
	//1-2. �޴� ����
	//�޴� �̸� ����
	public Item setMenuName(Item item, String menuName);
	
	//�޴� ���� ����
	public Item setMenuSales(Item item, Integer menuPrice);
	
	//1-3. �޴� ����(�޴� �̸����� ����)
	public void deleteMenu(String menuName);
	
	/**
	 * 2. �޴� ��ȸ
	 */
	//2-1. �޴� id ��ȸ(�޴� �̸����� ��ȸ)
	//SalesHistoryServiceImpl���� ���
	public Long findMidByMenu(String menuName);
	//2-2. ī�װ��� �޴� ��ȸ
	public List<Item> findMidByCategory(String category);
	//2-3. �޴��̸����� �޴� ��ȸ
	public Item findMenuByMenuName(String menuName);
	//2-4. ��ü �޴� ��ȸ
	public List<Item> findAllMenus();
}
