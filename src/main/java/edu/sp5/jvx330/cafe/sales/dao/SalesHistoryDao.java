package edu.sp5.jvx330.cafe.sales.dao;

import java.util.Date;
import java.util.List;

import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;

public interface SalesHistoryDao {
	/**
	 * 1. �Ǹų��� �߰�(�޴�id, �Ǹų���)
	 * @param menu
	 * @param numOfSales
	 */
	public void addSalesHistory(Long itemId, SalesHistory salesHistory);
	
	/**
	 * 2. �Ǹų��� ��ȸ
	 * @return
	 */
	//2-1. �Ǹų��� ��ü ��ȸ
	public List<SalesHistory> findAllSalesHistory();
	//2-2. �ش� ��¥�� �Ǹų��� ��ȸ
	public List<SalesHistory> findSalesHistoryByOrderDate(Date orderDate);
	//2-3. �ش� ���������� �Ǹų��� ��ȸ(itemId ����� ��)
	public List<SalesHistory> findSalesHistoryByItem(Long itemId);
	//2-4. �ֹ���ȣ�� �Ǹų��� ��ȸ (Integer orderNum -> Long orderNum)
	public List<SalesHistory> findSalesHistoryByOrderNum(Long orderNum);
	
	/**
	 * 3. �Ǹų��� ����
	 */
	//3-1. ȯ��
	public void deleteSalesHistoryBySHid(Long shid);
	//3-2. �ش� �޴��� �Ǹų��� ��ü ����
	public void deleteAllSalesHistories(Long itemId);
	
	/**
	 * 4. �޴�����(�Ǹų��� �޴� id ����)
	 */
	public void setItemIdFromSalesHistory(Long itemId, SalesHistory salesHistory);
	
	/**
	 * 5. �ش� ��¥�� �Ǹų����� ������ �� ����
	 */
	public Integer sumNumOfSalesByOrderNum(Long orderNum);
	
}
