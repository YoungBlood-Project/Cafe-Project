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

	// 1. ���ǸŰ��� ����
	@Override
	public void saveSalesTotalPrice(SalesTotalPrice salesTotalPrice) {
		stpDao.saveSalesTotalPrice(salesTotalPrice);
	}

	/**
	 * ���ǸŰ��� ���� ��ȸ
	 */
	// 2-1. ���ǸŰ��� ���� ��ü ��ȸ
	@Override
	public List<SalesTotalPrice> findAllSalesTotalPrice() {
		return stpDao.findAllSalesTotalPrice();
	}

	// 2-2. ���ǸŰ��� ���� �ֹ���ȣ�� ��ȸ
	@Override
	public SalesTotalPrice findSTPByOrderNum(Long orderNum) {
		return stpDao.findSTPByOrderNum(orderNum);

	}
	
	// 2-4 ���ǸŰ��� ���� ��ȸ
	@Override
	public List<SalesTotalPrice> findSalesTotalPriceByMonth(Date date){
		return stpDao.findSalesTotalPriceByMonth(date);
	};

	// 3. ���ǸŰ��� ���� ���� - ȯ�� �� ���
	@Override
	public void deleteSalesTotalPrice(Long ordernum) {
		stpDao.deleteSalesTotalPrice(ordernum);
	}



}