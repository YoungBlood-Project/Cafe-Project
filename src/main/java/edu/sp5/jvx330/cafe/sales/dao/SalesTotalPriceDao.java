package edu.sp5.jvx330.cafe.sales.dao;

import java.util.Date;
import java.util.List;

import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

public interface SalesTotalPriceDao {

	// 1. 총판매가격 저장
	public void saveSalesTotalPrice(SalesTotalPrice salesTotalPriceDao);	


	/**
	 * 총판매가격 내역 조회
	 */
	// 2-1. 총판매가격 내역 전체 조회
	public List<SalesTotalPrice> findAllSalesTotalPrice();

	// 2-2. 총판매가격 내역 주문번호로 조회
	public SalesTotalPrice findSTPByOrderNum(Long orderNum);

	// 2-3  총판매가격 날짜별 조회
	public List<SalesTotalPrice> findSTPByOrderDate(Date date);
		
	// 2-4 총판매가격 월별 조회
	public List<SalesTotalPrice> findSalesTotalPriceByMonth(Date date1, Date date2);
		
	// 3. 총판매가격 내역 기록 삭제 - 환불 시 사용
	public void deleteSalesTotalPrice(Long orderNum);
	
}