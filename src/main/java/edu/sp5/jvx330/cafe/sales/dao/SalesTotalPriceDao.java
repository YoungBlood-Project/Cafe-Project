package edu.sp5.jvx330.cafe.sales.dao;

import java.util.List;

import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

public interface SalesTotalPriceDao {

	// 1. ���ǸŰ��� ����
	public void saveSalesTotalPrice(SalesTotalPrice salesTotalPriceDao);	


	/**
	 * ���ǸŰ��� ���� ��ȸ
	 */
	// 2-1. ���ǸŰ��� ���� ��ü ��ȸ
	public List<SalesTotalPrice> findAllSalesTotalPrice();

	// 2-2. ���ǸŰ��� ���� �ֹ���ȣ�� ��ȸ
	public SalesTotalPrice findSTPByOrderNum(Long orderNum);


	// 3. ���ǸŰ��� ���� ��� ���� - ȯ�� �� ���
	public void deleteSalesTotalPrice(Long orderNum);
	
}