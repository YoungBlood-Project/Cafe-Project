package edu.sp5.jvx330.cafe.sales.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import edu.sp5.jvx330.cafe.menu.dao.impl.ItemDaoImpl;
import edu.sp5.jvx330.cafe.menu.domain.Item;
import edu.sp5.jvx330.cafe.sales.business.SalesHistoryService;
import edu.sp5.jvx330.cafe.sales.dao.impl.SalesHistoryDaoImpl;
import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;


public class SalesHistoryServiceImpl implements SalesHistoryService {
	@Autowired
	ItemDaoImpl iDao;
	@Autowired
	SalesHistoryDaoImpl shDao;
	
	/**
	 * 1. �Ǹų��� �߰�
	 */
	@Override
	public void addSalesHistory(String itemName, SalesHistory salesHistory) {
		Long mid = iDao.findItemIdByItemName(itemName);
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
	
	//2-3. �ش� �޴��� �Ǹų��� ��ȸ(ItemId ����� ��)
	@Override
	public List<SalesHistory> findSalesHistoryByItem(Item item) {
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
	@Override
	public List<SalesHistory> findSalesHistoryByOrderNum(Long orderNum) {
		try {
		List<SalesHistory> sh_list = shDao.findSalesHistoryByOrderNum(orderNum);
		return sh_list;
		} catch(NumberFormatException e) {
			return null;
		} catch(EmptyResultDataAccessException e) {
			return null;
		} 
	}
	// 2-6 �Ǹų��� ���� ��ȸ
	@Override
	public List<SalesHistory> findSalesHistoryByMonth(Date date1, Date date2) {
		return shDao.findSalesHistoryByMonth(date1, date2);
	};
	
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
	
	/**
	 * 5. �ش� �ֹ���ȣ�� �Ǹų����� ������ �� ����
	 */
	@Override
	public Integer sumNumOfSalesByOrderNum(Long orderNum) {
		return shDao.sumNumOfSalesByOrderNum(orderNum);
	};
}
