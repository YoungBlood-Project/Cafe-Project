package edu.sp5.jvx330.cafe.sales.business;

import java.util.Date;
import java.util.List;

import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

public interface SalesTotalPriceService {

	// 1. ���ǸŰ��� ����
	public void saveSalesTotalPrice(SalesTotalPrice salesTotalPrice);	

	/**
	 * ���ǸŰ��� ���� ��ȸ
	 */
	// 2-1. ���ǸŰ��� ���� ��ü ��ȸ
	public List<SalesTotalPrice> findAllSalesTotalPrice();

	// 2-2. ���ǸŰ��� ���� �ֹ���ȣ�� ��ȸ
	public SalesTotalPrice findSTPByOrderNum(Long orderNum);
	// 2-3  ���ǸŰ��� ��¥�� ��ȸ
	
	// 2-4 ���ǸŰ��� ���� ��ȸ
	public List<SalesTotalPrice> findSalesTotalPriceByMonth(Date date);
	
	// 2-5 ���ǸŰ��� ���� ��ȸ
	
	// 3. ���ǸŰ��� ���� ���� - ȯ�� �� ���
	public void deleteSalesTotalPrice(Long ordernum);


}