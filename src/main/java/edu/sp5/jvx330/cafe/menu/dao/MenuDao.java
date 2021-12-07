package edu.sp5.jvx330.cafe.menu.dao;

import java.util.List;

import edu.sp5.jvx330.cafe.menu.domain.Menu;

public interface MenuDao {
	/**
	 * 1. �����޴�
	 */
	//1-1. �޴� �߰� 
	public void addMenu(Menu menu);
	
	//1-2. �޴� ����
	//�޴� �̸� ����
	public Menu setMenuName(Menu menu, String menuName);
	
	//�޴� ���� ����
	public Menu setMenuSales(Menu menu, Integer menuPrice);
	
	//1-3. �޴� ����(�޴� �̸����� ����)
	public void deleteMenu(String menuName);
	
	/**
	 * 2. �޴� ��ȸ
	 */
	//2-1. �޴� id ��ȸ(�޴� �̸����� ��ȸ)
	//SalesHistoryServiceImpl���� ���
	public Long findMidByMenu(String menuName);
	//2-2. ī�װ��� �޴� ��ȸ
	public List<Menu> findMidByCategory(String category);
	//2-3. �޴��̸����� �޴� ��ȸ
	public Menu findMenuByMenuName(String menuName);
	//2-4. ��ü �޴� ��ȸ
	public List<Menu> findAllMenus();
}
