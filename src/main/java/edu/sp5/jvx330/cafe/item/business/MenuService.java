package edu.sp5.jvx330.cafe.item.business;

import java.util.List;

import edu.sp5.jvx330.cafe.item.domain.Menu;

public interface MenuService {
	/**
	 * 1. �����޴�
	 */
	//1-1. �޴� �߰� 
	public void addMenu(Menu menu);
	
	//1-2. �޴� ����
	//1-2-1. �޴� �̸� ����
	public Menu setMenuName(Menu menu, String menuName);
	
	//1-2-2. �޴� ���� ����
	public Menu setMenuSales(Menu menu, Integer menuPrice);
	
	//1-3. �޴� ����
	public void deleteMenu(Menu menu);
	
	/**
	 * 2. �޴� ��ȸ
	 */
	//2-1. �޴� id ��ȸ
	public Long findMidByMenuName(String menuName);
	//2-2. ī�װ��� �޴� id ��ȸ
	public List<Long> findMidByCategory(String category);
	//2-3. �޴� �̸����� �޴� ��ȸ
	public Menu findMenuByMenuName(String menuName);
	//2-4. ��ü �޴� ��ȸ
	public List<Menu> findAllMenus();
	
	/**
	 * 3. �ֹ� ���
	 */
	//1. �ֹ� ��Ͽ� �޴� �߰�
	public List<Menu> addOrderList(Menu menu);
	//2. �ֹ� ��Ͽ� �޴� ����
	public List<Menu> deleteOrderList(int menuNum, List<Menu> order_list);
}
