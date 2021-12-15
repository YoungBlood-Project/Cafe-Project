package edu.sp5.jvx330.cafe.sales.business;

import java.util.Date;
import java.util.List;

import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

public interface SalesTotalPriceService {

	// 1. 총판매가격 저장
	public void saveSalesTotalPrice(SalesTotalPrice salesTotalPrice);	

	/**
	 * 총판매가격 내역 조회
	 */
	// 2-1. 총판매가격 내역 전체 조회
	public List<SalesTotalPrice> findAllSalesTotalPrice();

	// 2-2. 총판매가격 내역 주문번호로 조회
	public SalesTotalPrice findSTPByOrderNum(Long orderNum);
	// 2-3  총판매가격 날짜별 조회
	
	// 2-4 총판매가격 월별 조회
	public List<SalesTotalPrice> findSalesTotalPriceByMonth(Date date);
	
	// 2-5 총판매가격 연간 조회
	
	// 3. 총판매가격 내역 삭제 - 환불 시 사용
	public void deleteSalesTotalPrice(Long ordernum);


}