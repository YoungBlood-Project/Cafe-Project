package edu.sp5.jvx330.cafe.category.SalesTotalPrice.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.category.SalesTotalPrice.business.SalesTotalPriceService;
import edu.sp5.jvx330.cafe.category.SalesTotalPrice.dao.impl.SalesTotalPriceDaoImpl;

public class SalesTotalPriceServiceImpl implements SalesTotalPriceService {
	@Autowired
	private SalesTotalPriceDaoImpl stpDao;

	// 1. ���ǸŰ��� ����
	@Override
	public void addSalesTotalPrice() {
		
	}

	// 2. ���ǸŰ��� ��ȸ
	@Override
	public int findSalesTotalPrice() {
		return 0;
	}

	// 3. ���ǸŰ��� ��� ���� - ȯ�� �� ���
	@Override
	public int deleteSalesTotalPrice() {
		return 0;
	}
	
	
}
