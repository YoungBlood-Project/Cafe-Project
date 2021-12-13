package edu.sp5.jvx330.cafe.category.item.salesHistory.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import edu.sp5.jvx330.cafe.category.item.salesHistory.business.SalesHistoryService;
import edu.sp5.jvx330.cafe.category.item.salesHistory.dao.impl.SalesHistoryDaoImpl;
import edu.sp5.jvx330.cafe.category.item.salesHistory.domain.SalesHistory;
import edu.sp5.jvx330.cafe.membership.business.impl.MileageServiceImpl;
import edu.sp5.jvx330.cafe.menu.dao.impl.ItemDaoImpl;
import edu.sp5.jvx330.cafe.menu.domain.Item;


public class SalesHistoryServiceImpl implements SalesHistoryService {
	@Autowired
	ItemDaoImpl iDao;
	@Autowired
	SalesHistoryDaoImpl shDao;
	
	/**
	 * 1. �Ǹų��� �߰�
	 */
	@Override
	public void addSalesHistory(Item item, SalesHistory salesHistory) {
		Long mid = iDao.findItemIdByItemName(item.getItemName());
		//�ֹ� ��ȣ�� ��Ʈ�ѷ����� �־������ �� ����.  
		shDao.addSalesHistory(mid, salesHistory);
	}
	
	/**
	 * 2. �Ǹų��� ��ȸ
	 */
	//2-1. �Ǹų��� ��ü ��ȸ
	@Override
	public List<SalesHistory> findAllSalesHistory() {
		return shDao.findAllSalesHistory();
	}
	//2-2. �ش� ��¥�� �Ǹų��� ��ȸ
	@Override
	public List<SalesHistory> findSalesHistoryByOrderDate(Date orderDate) {
		return shDao.findSalesHistoryByOrderDate(orderDate);
	}
	
	//2-3. �ش� �޴��� �Ǹų��� ��ȸ(menuId ����� ��)
	@Override
	public List<SalesHistory> findSalesHistoryByMenu(Item item) {
		//�޴� �̸� �޾Ƽ� id ��ȸ
		Long itemId = iDao.findItemIdByItemName(item.getItemName());
		return shDao.findSalesHistoryByItem(itemId);
	}
	
	/**
	 * ������ �߰�
	 * (Integer orderNum -> Long orderNum)
	 * @param orderNum
	 * @return
	 */
	// 2-4. �ش� �ֹ� ��ȣ�� �Ǹų��� ��ȸ
	public List<SalesHistory> findSalesHistoryByOrderNum(Long orderNum) {
		return shDao.findSalesHistoryByOrderNum(orderNum);
	}
	
	/**
	 * 3. �Ǹų��� ����
	 */
	//3-1. ȯ��
	@Override
	//3-1. ȯ��(�ش� SalesHistory)
	public void deleteSalesHistoryBySHid(SalesHistory salesHistory) {
		shDao.deleteSalesHistoryBySHid(salesHistory.getShid());
	}
	//3-2. �ش� �޴��� �Ǹų��� ��ü ����
	@Override
	public void deleteAllSalesHistories(Item item) {
		Long itemId = iDao.findItemIdByItemName(item.getItemName());
		shDao.deleteAllSalesHistories(itemId);
	}

	/**
	 * 4. ��¥�� �Ǹų��� ����
	 */
	@Override
	public Integer countSalesHistoryByOrderDate(Date orderDate) {
		return findSalesHistoryByOrderDate(orderDate).size();
	}
}
