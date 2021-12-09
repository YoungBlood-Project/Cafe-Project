package edu.sp5.jvx330.cafe.menu.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.customer.totalMileage.dao.impl.TotalMileageDaoImpl;
import edu.sp5.jvx330.cafe.menu.business.MenuService;
import edu.sp5.jvx330.cafe.menu.dao.impl.MenuDaoImpl;
import edu.sp5.jvx330.cafe.menu.domain.Menu;
import edu.sp5.jvx330.cafe.menu.salesHistory.dao.impl.SalesHistoryDaoImpl;
import edu.sp5.jvx330.cafe.menu.salesHistory.domain.SalesHistory;

public class MenuSerivceImpl implements MenuService {
	@Autowired
	private MenuDaoImpl mDao;
	@Autowired
	private SalesHistoryDaoImpl shDao;
	@Autowired
	private TotalMileageDaoImpl tmDao;
	
	/**
	 * 1. �����޴�
	 */
	//1-1. �޴� �߰�
	@Override
	public void addMenu(Menu menu) {
		mDao.addMenu(menu);
	}
	
	//1-2. �޴� ����
	//�޴� �̸� ����
	@Override
	public Menu setMenuName(Menu menu, String menuName) {
		return mDao.setMenuName(menu, menuName);
	}

	//�޴� ���� ����
	@Override
	public Menu setMenuSales(Menu menu, Integer menuPrice) {
		return mDao.setMenuSales(menu, menuPrice);
	}
	
	//1-3. �޴� ����
	@Override
	public void deleteMenu(Menu menu) {	
		//������ �޴��� id�� �Ǹų��� ��ȸ
		List<SalesHistory> sh_list = shDao.findSalesHistoryByMenu(menu.getMid());
		Long deleteId = mDao.findMidByMenu("delete");
		System.out.println(deleteId);
		for(SalesHistory sh : sh_list) {
			shDao.setMenuIdFromSalesHistory(deleteId, sh);
		}
		
		//�������� ����
		shDao.disableConstraintFromSH();
		//�޴� ����
		mDao.deleteMenu(menu.getMenuName());
		//�������� �߰�
		shDao.enableConstraintFromSH();
	}

	/**
	 * 2. �޴� ��ȸ
	 */
	//2-1. �޴� id ��ȸ
	@Override
	public Long findMidByMenuName(String menuName) {
		return mDao.findMidByMenu(menuName);
	}

	//2-2. ī�װ��� �޴� id ��ȸ
	@Override
	public List<Long> findMidByCategory(String category) {
		List<Menu> menu_list = mDao.findMidByCategory(category);
		List<Long> mid_list = new ArrayList<Long>();
		for(Menu menu : menu_list) {
			mid_list.add(menu.getMid());
		}
		return mid_list;
	}
	//2-3. �޴� �̸����� �޴� ��ȸ
	@Override
	public Menu findMenuByMenuName(String menuName) {
		return mDao.findMenuByMenuName(menuName);
	}
	//2-4. ��ü �޴� ��ȸ
	@Override
	public List<Menu> findAllMenus() {
		return mDao.findAllMenus();
	}
	
	/**
	  * 3. �ֹ� ��� - ������ �߰�
	  */
	@Override
	//1. �ֹ� ��Ͽ� �޴� �߰�
	public List<Menu> addOrderList(Menu menu) {
		List<Menu> order_list = new ArrayList<Menu>();
		order_list.add(menu);
		return order_list;
	};
	   
	@Override
	//2. �ֹ� ��Ͽ� �޴� ����
	public List<Menu> deleteOrderList(int orderNum, List<Menu> order_list){
		order_list.remove(orderNum);
		return order_list;
	};
	   
}
