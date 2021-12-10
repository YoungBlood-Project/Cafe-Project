package edu.sp5.jvx330.cafe.category.item.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.category.domain.Category;
import edu.sp5.jvx330.cafe.category.item.business.ItemService;
import edu.sp5.jvx330.cafe.category.item.dao.impl.ItemDaoImpl;
import edu.sp5.jvx330.cafe.category.item.domain.Item;
import edu.sp5.jvx330.cafe.category.item.salesHistory.dao.impl.SalesHistoryDaoImpl;
import edu.sp5.jvx330.cafe.category.item.salesHistory.domain.SalesHistory;

public class ItemSerivceImpl implements ItemService {
	@Autowired
	private ItemDaoImpl iDao;
	@Autowired
	private SalesHistoryDaoImpl shDao;
	
	/**
	 * 1. �����޴�
	 */
	//1-1. ������ �߰�
	@Override
	public void addItem(Item item) {
		iDao.addItem(item);
	}
	
	//1-2. ������ ����
	//������ �̸� ����
	@Override
	public Item setItemName(Item item, String itemName) {
		return iDao.setItemName(item, itemName);
	}

	//������ ���� ����
	@Override
	public Item setItemPrice(Item item, Integer itemPrice) {
		return iDao.setItemPrice(item, itemPrice);
	}
	
	//1-3. ������ ����
	@Override
	public void deleteItem(Item item) {	
		//������ �������� id�� �Ǹų��� ��ȸ
		List<SalesHistory> sh_list = shDao.findSalesHistoryByItem(item.getItemId());
		Long deleteId = iDao.findItemIdByItemName(item.getItemName());
		//���� item�� �̸����� ������ itemId ��ȸ
		System.out.println(deleteId);
		for(SalesHistory sh : sh_list) {
			shDao.setItemIdFromSalesHistory(deleteId, sh);
		}
		
		//�������� ����
		shDao.disableConstraintFromSH();
		//�޴� ����
		iDao.deleteItem(item.getItemName());
		//�������� �߰�
		shDao.enableConstraintFromSH();
	}

	/**
	 * 2. �޴� ��ȸ
	 */
	//2-1. �޴� id ��ȸ
	@Override
	public Long findItemIdByItemName(String itemName) {
		return iDao.findItemIdByItemName(itemName);
	}

	//2-2. ī�װ��� �޴� ��ȸ
	@Override
	public List<Item> findItemsByCategory(Category category) {
		List<Item> item_list = iDao.findItemsByCategory(category);

		return item_list;
	}

	//2-3. �޴� �̸����� �޴� ��ȸ
	@Override
	public Item findItemByItemName(String itemName) {
		return iDao.findItemByItemName(itemName);
	}
	//2-4. ��ü �޴� ��ȸ
	@Override
	public List<Item> findAllItems() {
		return iDao.findAllItems();
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
