package edu.sp5.jvx330.cafe.sales.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.sales.business.SalesTotalPriceService;
import edu.sp5.jvx330.cafe.sales.dao.impl.SalesTotalPriceDaoImpl;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;


public class SalesTotalPriceServiceImpl implements SalesTotalPriceService {
	@Autowired
	private SalesTotalPriceDaoImpl stpDao;

	// 1. 총판매가격 저장
	@Override
	public void saveSalesTotalPrice(SalesTotalPrice salesTotalPrice) {
		stpDao.saveSalesTotalPrice(salesTotalPrice);
	}

	/**
	 * 총판매가격 내역 조회
	 */
	// 2-1. 총판매가격 내역 전체 조회
	@Override
	public List<SalesTotalPrice> findAllSalesTotalPrice() {
		return stpDao.findAllSalesTotalPrice();
	}

	// 2-2. 총판매가격 내역 주문번호로 조회
	@Override
	public SalesTotalPrice findSTPByOrderNum(Long orderNum) {
		return stpDao.findSTPByOrderNum(orderNum);

	}
	
	// 2-4 총판매가격 월별 조회
	@Override
	public List<SalesTotalPrice> findSalesTotalPriceByMonth(Date date){
		return stpDao.findSalesTotalPriceByMonth(date);
	};

	// 3. 총판매가격 내역 삭제 - 환불 시 사용
	@Override
	public void deleteSalesTotalPrice(Long ordernum) {
		stpDao.deleteSalesTotalPrice(ordernum);
	}



}