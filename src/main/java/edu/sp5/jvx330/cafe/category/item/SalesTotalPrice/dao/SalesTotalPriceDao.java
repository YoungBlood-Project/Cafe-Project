package edu.sp5.jvx330.cafe.category.item.SalesTotalPrice.dao;

import java.util.List;

import edu.sp5.jvx330.cafe.category.item.SalesTotalPrice.domain.SalesTotalPrice;

public interface SalesTotalPriceDao {

	// 1. 총판매가격 저장
	public void saveSalesTotalPrice(SalesTotalPrice salesTotalPriceDao);	
	
	
	/**
	 * 총판매가격 내역 조회
	 */
	// 2-1. 총판매가격 내역 전체 조회
	public List<SalesTotalPrice> findAllSalesTotalPrice();
		
	// 2-2. 총판매가격 내역 주문번호로 조회
	public List<SalesTotalPrice> findSTPByOrderNum(Long orderNum);

	
	// 3. 총판매가격 내역 기록 삭제 - 환불 시 사용
	public void deleteSalesTotalPrice(Long orderNum);
	
	
	
	
}
