package edu.sp5.jvx330.cafe.sales.business;

import java.util.Date;
import java.util.List;

import edu.sp5.jvx330.cafe.menu.domain.Item;
import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;

public interface SalesHistoryService {
	/**
	 * 1. 판매내역 추가(메뉴, 판매내역)
	 * @param item
	 * @param numOfSales
	 */
	public void addSalesHistory(String itemName, SalesHistory salesHistory);
	
	/**
	 * 2. 판매내역 조회
	 * @return
	 */
	//2-1. 판매내역 전체 조회
	public List<SalesHistory> findAllSalesHistory();
	//2-2. 해당 날짜로 판매내역 조회
	public List<SalesHistory> findSalesHistoryByOrderDate(Date orderDate);
	//2-3. 해당 메뉴로 판매내역 조회(menuId 사용)
	public List<SalesHistory> findSalesHistoryByItem(Item item);
	
	/**
	 * 정혜윤 추가
	 * (Integer orderNum -> Long orderNum)
	 * @param orderNum
	 * @return
	 */
	//2-4. 해당 주문 번호로 판매 내역 조회
	public List<SalesHistory> findSalesHistoryByOrderNum(Long orderNum);
	// 2-5. 해당 아이템 아이디와 날짜로 판매내역 조회
	// public List<SalesHistory> findSHByItemIdAndOrderDate(Long itemId, Date orderDate);
	/**
	 * 3. 판매내역 삭제
	 */
	//3-1. 환불(해당 SalesHistory)
	public void deleteSalesHistoryBySHid(SalesHistory salesHistory);
	//3-2. 해당 메뉴의 판매내역 전체 삭제
	public void deleteAllSalesHistories(Item item);
	
	/**
	 * 4. 날짜별 판매내역 개수
	 */
	public Integer countSalesHistoryByOrderDate(Date orderDate);
	
	/**
	 * 5. 해당 날짜의 판매내역별 수량의 총 수량
	 */
	public Integer sumNumOfSalesByOrderNum(Long orderNum);
}
