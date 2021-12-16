package edu.sp5.jvx330.cafe.sales.dao;

import java.util.Date;
import java.util.List;

import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

public interface SalesHistoryDao {
	/**
	 * 1. 판매내역 추가(메뉴id, 판매내역)
	 * @param menu
	 * @param numOfSales
	 */
	public void addSalesHistory(Long itemId, SalesHistory salesHistory);
	
	/**
	 * 2. 판매내역 조회
	 * @return
	 */
	//2-1. 판매내역 전체 조회
	public List<SalesHistory> findAllSalesHistory();
	//2-2. 해당 날짜로 판매내역 조회
	public List<SalesHistory> findSalesHistoryByOrderDate(Date orderDate);
	//2-3. 해당 아이템으로 판매내역 조회(itemId 사용할 것)
	public List<SalesHistory> findSalesHistoryByItem(Long itemId);
	//2-4. 주문번호로 판매내역 조회 (Integer orderNum -> Long orderNum)
	public List<SalesHistory> findSalesHistoryByOrderNum(Long orderNum);
	//2-5 월별 판매내역 조회
	public List<SalesHistory> findSalesHistoryByMonth(Date date1, Date date2);
	//2-6 월별 아이템별 총 수량, 총 지불금액 조회
	public List<SalesHistory> sumSalesHistoryByMonth(Date date1, Date date2);
	//2-7 월별 아이템별 총 수량 조회
	public List<SalesHistory> sumNumOfSalesByMonth(Date date1, Date date2);
	//2-8 월별 아이템별 총 지불금액 조회
	public List<SalesHistory> sumPaidPriceByMonth(Date date1, Date date2);
	//2 test 월별 아이템별 총 수량, 총 지불금액 조회
	public List<SalesHistory> sumNumOfSalesAndSumPaidPriceByMonth(Date date1, Date date2);
	
	/**
	 * 3. 판매내역 삭제
	 */
	//3-1. 환불
	public void deleteSalesHistoryBySHid(Long shid);
	//3-2. 해당 메뉴의 판매내역 전체 삭제
	public void deleteAllSalesHistories(Long itemId);
	
	/**
	 * 4. 메뉴삭제(판매내역 메뉴 id 변경)
	 */
	public void setItemIdFromSalesHistory(Long itemId, SalesHistory salesHistory);
	
	/**
	 * 5. 해당 날짜의 판매내역별 수량의 총 수량
	 */
	public Integer sumNumOfSalesByOrderNum(Long orderNum);
	
}
