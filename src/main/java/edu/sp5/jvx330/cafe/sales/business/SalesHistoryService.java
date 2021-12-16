package edu.sp5.jvx330.cafe.sales.business;

import java.util.Date;
import java.util.List;

import edu.sp5.jvx330.cafe.menu.domain.Item;
import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;

public interface SalesHistoryService {
	/**
	 * 1. �Ǹų��� �߰�(�޴�, �Ǹų���)
	 * @param item
	 * @param numOfSales
	 */
	public void addSalesHistory(String itemName, SalesHistory salesHistory);
	
	/**
	 * 2. �Ǹų��� ��ȸ
	 * @return
	 */
	//2-1. �Ǹų��� ��ü ��ȸ
	public List<SalesHistory> findAllSalesHistory();
	//2-2. �ش� ��¥�� �Ǹų��� ��ȸ
	public List<SalesHistory> findSalesHistoryByOrderDate(Date orderDate);
	//2-3. �ش� �޴��� �Ǹų��� ��ȸ(menuId ���)
	public List<SalesHistory> findSalesHistoryByItem(Item item);
	
	/**
	 * ������ �߰�
	 * (Integer orderNum -> Long orderNum)
	 * @param orderNum
	 * @return
	 */
	//2-4. �ش� �ֹ� ��ȣ�� �Ǹ� ���� ��ȸ
	public List<SalesHistory> findSalesHistoryByOrderNum(Long orderNum);
	// 2-5. �ش� ������ ���̵�� ��¥�� �Ǹų��� ��ȸ
	// public List<SalesHistory> findSHByItemIdAndOrderDate(Long itemId, Date orderDate);
	/**
	 * 3. �Ǹų��� ����
	 */
	//3-1. ȯ��(�ش� SalesHistory)
	public void deleteSalesHistoryBySHid(SalesHistory salesHistory);
	//3-2. �ش� �޴��� �Ǹų��� ��ü ����
	public void deleteAllSalesHistories(Item item);
	
	/**
	 * 4. ��¥�� �Ǹų��� ����
	 */
	public Integer countSalesHistoryByOrderDate(Date orderDate);
	
	/**
	 * 5. �ش� ��¥�� �Ǹų����� ������ �� ����
	 */
	public Integer sumNumOfSalesByOrderNum(Long orderNum);
}
