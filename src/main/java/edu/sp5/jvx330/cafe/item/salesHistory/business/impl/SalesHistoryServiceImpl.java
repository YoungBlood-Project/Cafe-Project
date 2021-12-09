package edu.sp5.jvx330.cafe.item.salesHistory.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.customer.mileage.business.impl.MileageServiceImpl;
import edu.sp5.jvx330.cafe.customer.mileageHistory.business.impl.MileageHistoryServiceImpl;
import edu.sp5.jvx330.cafe.item.dao.impl.ItemDaoImpl;
import edu.sp5.jvx330.cafe.item.domain.Item;
import edu.sp5.jvx330.cafe.item.salesHistory.business.SalesHistoryService;
import edu.sp5.jvx330.cafe.item.salesHistory.dao.impl.SalesHistoryDaoImpl;
import edu.sp5.jvx330.cafe.item.salesHistory.domain.SalesHistory;



public class SalesHistoryServiceImpl implements SalesHistoryService {
	@Autowired
	ItemDaoImpl mDao;
	@Autowired
	SalesHistoryDaoImpl shDao;
	
	@Autowired
	MileageServiceImpl mileageService;
	@Autowired
	MileageServiceImpl tmService;
	
	/**
	 * 1. �Ǹų��� �߰�
	 */
	@Override
	public void addSalesHistory(Item item, SalesHistory salesHistory) {
		Long mid = mDao.findMidByMenu(item.getMenuName());
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
		Long mid = mDao.findMidByMenu(item.getMenuName());
		return shDao.findSalesHistoryByMenu(mid);
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
	public void deleteSalesHistoryBySid(SalesHistory salesHistory) {
		shDao.deleteSalesHistoryBySid(salesHistory.getSid());
	}
	//3-2. �ش� �޴��� �Ǹų��� ��ü ����
	@Override
	public void deleteAllSalesHistories(Item item) {
		Long mid = mDao.findMidByMenu(item.getMenuName());
		shDao.deleteAllSalesHistories(mid);
	}

	/**
	 * 4. ��¥�� �Ǹų��� ����
	 */
	@Override
	public Integer countSalesHistoryByOrderDate(Date orderDate) {
		return findSalesHistoryByOrderDate(orderDate).size();
	}

}
