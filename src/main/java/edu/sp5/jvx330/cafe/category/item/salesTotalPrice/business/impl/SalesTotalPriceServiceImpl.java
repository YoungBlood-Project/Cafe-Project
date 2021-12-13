package edu.sp5.jvx330.cafe.category.item.salesTotalPrice.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.category.item.salesTotalPrice.business.SalesTotalPriceService;
import edu.sp5.jvx330.cafe.category.item.salesTotalPrice.dao.impl.SalesTotalPriceDaoImpl;
import edu.sp5.jvx330.cafe.category.item.salesTotalPrice.domain.SalesTotalPrice;


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
	public List<SalesTotalPrice> findSTPByOrderNum(Long orderNum) {
		return stpDao.findSTPByOrderNum(orderNum);

	}

	// 3. ���ǸŰ��� ���� ���� - ȯ�� �� ���
	@Override
	public void deleteSalesTotalPrice(Long ordernum) {
		stpDao.deleteSalesTotalPrice(ordernum);
	}



}