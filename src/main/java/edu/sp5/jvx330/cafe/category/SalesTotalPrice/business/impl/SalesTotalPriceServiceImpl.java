package edu.sp5.jvx330.cafe.category.SalesTotalPrice.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.category.SalesTotalPrice.business.SalesTotalPriceService;
import edu.sp5.jvx330.cafe.category.SalesTotalPrice.dao.impl.SalesTotalPriceDaoImpl;

public class SalesTotalPriceServiceImpl implements SalesTotalPriceService {
	@Autowired
	private SalesTotalPriceDaoImpl stpDao;

	// 1. 총판매가격 저장
	@Override
	public void addSalesTotalPrice() {
		
	}

	// 2. 총판매가격 조회
	@Override
	public int findSalesTotalPrice() {
		return 0;
	}

	// 3. 총판매가격 기록 삭제 - 환불 시 사용
	@Override
	public int deleteSalesTotalPrice() {
		return 0;
	}
	
	
}
