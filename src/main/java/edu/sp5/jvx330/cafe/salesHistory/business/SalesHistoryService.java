package edu.sp5.jvx330.cafe.salesHistory.business;

import java.util.Date;
import java.util.List;

import edu.sp5.jvx330.cafe.menu.domain.Menu;
import edu.sp5.jvx330.cafe.salesHistory.domain.SalesHistory;

public interface SalesHistoryService {
	/**
	 * 1. �Ǹų��� �߰�(�޴�, �Ǹų���)
	 * @param menu
	 * @param numOfSales
	 */
	public void addSalesHistory(Menu menu, SalesHistory salesHistory);
	
	/**
	 * 2. �Ǹų��� ��ȸ
	 * @return
	 */
	//2-1. �Ǹų��� ��ü ��ȸ
	public List<SalesHistory> findAllSalesHistory();
	//2-2. �ش� ��¥�� �Ǹų��� ��ȸ
	public List<SalesHistory> findSalesHistoryByOrderDate(Date orderDate);
	//2-3. �ش� �޴��� �Ǹų��� ��ȸ(menuId ���)
	public List<SalesHistory> findSalesHistoryByMenu(Menu menu);
	
	/**
	 * 3. �Ǹų��� ����
	 */
	//3-1. ȯ��(�ش� SalesHistory)
	public void deleteSalesHistoryBySid(SalesHistory salesHistory);
	//3-2. �ش� �޴��� �Ǹų��� ��ü ����
	public void deleteAllSalesHistories(Menu menu);
	
	/**
	 * 4. ��¥�� �Ǹų��� ����
	 */
	public Integer countSalesHistoryByOrderDate(Date orderDate);
}
