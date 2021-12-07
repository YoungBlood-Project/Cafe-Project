package edu.sp5.jvx330.cafe.salesHistory.dao;

import java.util.Date;
import java.util.List;

import edu.sp5.jvx330.cafe.salesHistory.domain.SalesHistory;

public interface SalesHistoryDao {
	/**
	 * 1. 판매내역 추가(메뉴id, 판매내역)
	 * @param menu
	 * @param numOfSales
	 */
	public void addSalesHistory(Long menuId, SalesHistory salesHistory);
	
	/**
	 * 2. 판매내역 조회
	 * @return
	 */
	//2-1. 판매내역 전체 조회
	public List<SalesHistory> findAllSalesHistory();
	//2-2. 해당 날짜로 판매내역 조회
	public List<SalesHistory> findSalesHistoryByOrderDate(Date orderDate);
	//2-3. 해당 메뉴로 판매내역 조회(menuId 사용할 것)
	public List<SalesHistory> findSalesHistoryByMenu(Long menuId);
	//2-4. 주문번호로 판매내역 조회
	public List<SalesHistory> findSalesHistoryByOrderNum(Integer orderNum);
	
	/**
	 * 3. 판매내역 삭제
	 */
	//3-1. 환불
	public void deleteSalesHistoryBySid(Long sid);
	//3-2. 해당 메뉴의 판매내역 전체 삭제
	public void deleteAllSalesHistories(Long menuId);
	
	/**
	 * 4. 메뉴삭제(판매내역 메뉴 id 변경)
	 */
	public void setMenuIdFromSalesHistory(Long menuId, SalesHistory salesHistory);
}
