package edu.sp5.jvx330.cafe.category.item.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.category.item.business.ItemService;
import edu.sp5.jvx330.cafe.category.item.dao.impl.ItemDaoImpl;
import edu.sp5.jvx330.cafe.category.item.domain.Item;
import edu.sp5.jvx330.cafe.category.item.salesHistory.dao.impl.SalesHistoryDaoImpl;
import edu.sp5.jvx330.cafe.category.item.salesHistory.domain.SalesHistory;
import edu.sp5.jvx330.cafe.customer.mileage.dao.impl.MileageDaoImpl;

public class ItemSerivceImpl implements ItemService {
	@Autowired
	private ItemDaoImpl mDao;
	@Autowired
	private SalesHistoryDaoImpl shDao;
	@Autowired
	private MileageDaoImpl tmDao;
	
	/**
	 * 1. �����޴�
	 */
	//1-1. �޴� �߰�
	@Override
	public void addMenu(Item item) {
		mDao.addMenu(item);
	}
	
	//1-2. �޴� ����
	//�޴� �̸� ����
	@Override
	public Item setMenuName(Item item, String menuName) {
		return mDao.setMenuName(item, menuName);
	}

	//�޴� ���� ����
	@Override
	public Item setMenuSales(Item item, Integer menuPrice) {
		return mDao.setMenuSales(item, menuPrice);
	}
	
	//1-3. �޴� ����
	@Override
	public void deleteMenu(Item item) {	
		//������ �޴��� id�� �Ǹų��� ��ȸ
		List<SalesHistory> sh_list = shDao.findSalesHistoryByMenu(item.getMid());
		Long deleteId = mDao.findMidByMenu("delete");
		System.out.println(deleteId);
		for(SalesHistory sh : sh_list) {
			shDao.setMenuIdFromSalesHistory(deleteId, sh);
		}
		
		//�������� ����
		shDao.disableConstraintFromSH();
		//�޴� ����
		mDao.deleteMenu(item.getMenuName());
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
		List<Item> menu_list = mDao.findMidByCategory(category);
		List<Long> mid_list = new ArrayList<Long>();
		for(Item item : menu_list) {
			mid_list.add(item.getMid());
		}
		return mid_list;
	}
	//2-3. �޴� �̸����� �޴� ��ȸ
	@Override
	public Item findMenuByMenuName(String menuName) {
		return mDao.findMenuByMenuName(menuName);
	}
	//2-4. ��ü �޴� ��ȸ
	@Override
	public List<Item> findAllMenus() {
		return mDao.findAllMenus();
	}
	
	/**
	  * 3. �ֹ� ��� - ������ �߰�
	  */
	@Override
	//1. �ֹ� ��Ͽ� �޴� �߰�
	public List<Item> addOrderList(Item item) {
		List<Item> order_list = new ArrayList<Item>();
		order_list.add(item);
		return order_list;
	};
	   
	@Override
	//2. �ֹ� ��Ͽ� �޴� ����
	public List<Item> deleteOrderList(int orderNum, List<Item> order_list){
		order_list.remove(orderNum);
		return order_list;
	};
	   
}
