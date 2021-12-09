package edu.sp5.jvx330.cafe.item.salesHistory.business;

import java.util.Date;
import java.util.List;

import edu.sp5.jvx330.cafe.item.domain.Menu;
import edu.sp5.jvx330.cafe.item.salesHistory.domain.SalesHistory;

public interface SalesHistoryService {
	/**
	 * 1. 판매내역 추가(메뉴, 판매내역)
	 * @param menu
	 * @param numOfSales
	 */
	public void addSalesHistory(Menu menu, SalesHistory salesHistory);
	
	/**
	 * 2. 판매내역 조회
	 * @return
	 */
	//2-1. 판매내역 전체 조회
	public List<SalesHistory> findAllSalesHistory();
	//2-2. 해당 날짜로 판매내역 조회
	public List<SalesHistory> findSalesHistoryByOrderDate(Date orderDate);
	//2-3. 해당 메뉴로 판매내역 조회(menuId 사용)
	public List<SalesHistory> findSalesHistoryByMenu(Menu menu);
	
	/**
	 * 정혜윤 추가
	 * (Integer orderNum -> Long orderNum)
	 * @param orderNum
	 * @return
	 */
	//2-4. 해당 주문 번호로 판매 내역 조회
	public List<SalesHistory> findSalesHistoryByOrderNum(Long orderNum);
	
	/**
	 * 3. 판매내역 삭제
	 */
	//3-1. 환불(해당 SalesHistory)
	public void deleteSalesHistoryBySid(SalesHistory salesHistory);
	//3-2. 해당 메뉴의 판매내역 전체 삭제
	public void deleteAllSalesHistories(Menu menu);
	
	/**
	 * 4. 날짜별 판매내역 개수
	 */
	public Integer countSalesHistoryByOrderDate(Date orderDate);
}
