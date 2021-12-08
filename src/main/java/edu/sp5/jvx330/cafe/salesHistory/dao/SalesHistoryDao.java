package edu.sp5.jvx330.cafe.salesHistory.dao;

import java.util.Date;
import java.util.List;

import edu.sp5.jvx330.cafe.salesHistory.domain.SalesHistory;

public interface SalesHistoryDao {
	/**
	 * 1. �Ǹų��� �߰�(�޴�id, �Ǹų���)
	 * @param menu
	 * @param numOfSales
	 */
	public void addSalesHistory(Long menuId, SalesHistory salesHistory);
	
	/**
	 * 2. �Ǹų��� ��ȸ
	 * @return
	 */
	//2-1. �Ǹų��� ��ü ��ȸ
	public List<SalesHistory> findAllSalesHistory();
	//2-2. �ش� ��¥�� �Ǹų��� ��ȸ
	public List<SalesHistory> findSalesHistoryByOrderDate(Date orderDate);
	//2-3. �ش� �޴��� �Ǹų��� ��ȸ(menuId ����� ��)
	public List<SalesHistory> findSalesHistoryByMenu(Long menuId);
	//2-4. �ֹ���ȣ�� �Ǹų��� ��ȸ (Integer orderNum -> Long orderNum)
	public List<SalesHistory> findSalesHistoryByOrderNum(Long orderNum);
	
	/**
	 * 3. �Ǹų��� ����
	 */
	//3-1. ȯ��
	public void deleteSalesHistoryBySid(Long sid);
	//3-2. �ش� �޴��� �Ǹų��� ��ü ����
	public void deleteAllSalesHistories(Long menuId);
	
	/**
	 * 4. �޴�����(�Ǹų��� �޴� id ����)
	 */
	public void setMenuIdFromSalesHistory(Long menuId, SalesHistory salesHistory);
}
