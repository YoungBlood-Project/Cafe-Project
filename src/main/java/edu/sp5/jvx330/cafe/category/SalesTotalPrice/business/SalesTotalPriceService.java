package edu.sp5.jvx330.cafe.category.SalesTotalPrice.business;

public interface SalesTotalPriceService {

	// 1. 총판매가격 저장
	public void addSalesTotalPrice();	
		
	// 2. 총판매가격 조회
	public int findSalesTotalPrice();
	
	// 3. 총판매가격 기록 삭제 - 환불 시 사용
	public int deleteSalesTotalPrice();
		
}
