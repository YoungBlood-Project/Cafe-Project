package edu.sp5.jvx330.cafe.category.SalesTotalPrice.dao;

public interface SalesTotalPriceDao {

	// 1. 총판매가격 저장
	public void saveSalesTotalPrice();	
				
	// 2. 총판매가격 조회
	public int findSalesTotalPrice();
		
	// 3. 총판매가격 기록 삭제 - 환불 시 사용
	public int deleteSalesTotalPrice();
	
	
	
	
}
