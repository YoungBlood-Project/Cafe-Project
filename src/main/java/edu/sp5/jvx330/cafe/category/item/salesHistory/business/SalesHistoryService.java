package edu.sp5.jvx330.cafe.category.item.salesHistory.business;

import java.util.Date;
import java.util.List;

import edu.sp5.jvx330.cafe.category.item.domain.Item;
import edu.sp5.jvx330.cafe.category.item.salesHistory.domain.SalesHistory;

public interface SalesHistoryService {
	/**
	 * 1. �Ǹų��� �߰�(�޴�, �Ǹų���)
	 * @param item
	 * @param numOfSales
	 */
	public void addSalesHistory(Item item, SalesHistory salesHistory);
	
	/**
	 * 2. �Ǹų��� ��ȸ
	 * @return
	 */
	//2-1. �Ǹų��� ��ü ��ȸ
	public List<SalesHistory> findAllSalesHistory();
	//2-2. �ش� ��¥�� �Ǹų��� ��ȸ
	public List<SalesHistory> findSalesHistoryByOrderDate(Date orderDate);
	//2-3. �ش� �޴��� �Ǹų��� ��ȸ(menuId ���)
	public List<SalesHistory> findSalesHistoryByMenu(Item item);
	
	/**
	 * ������ �߰�
	 * (Integer orderNum -> Long orderNum)
	 * @param orderNum
	 * @return
	 */
	//2-4. �ش� �ֹ� ��ȣ�� �Ǹ� ���� ��ȸ
	public List<SalesHistory> findSalesHistoryByOrderNum(Long orderNum);
	
	/**
	 * 3. �Ǹų��� ����
	 */
	//3-1. ȯ��(�ش� SalesHistory)
	public void deleteSalesHistoryBySid(SalesHistory salesHistory);
	//3-2. �ش� �޴��� �Ǹų��� ��ü ����
	public void deleteAllSalesHistories(Item item);
	
	/**
	 * 4. ��¥�� �Ǹų��� ����
	 */
	public Integer countSalesHistoryByOrderDate(Date orderDate);
}
