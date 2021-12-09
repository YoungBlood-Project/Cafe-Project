package edu.sp5.jvx330.cafe.customer.mileageHistory.dao;

import java.util.List;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileageHistory.domain.MileageHistory;

public interface MileageHistoryDao {
	/**
	 * ���� - ����
	 * @param customer
	 */
	// 1. ���ϸ��� ����
	public void addMileageHistory(Long customerId, MileageHistory mileage);
	
	// 2. orderNum���� ���ϸ��� ��ȸ
	public List<MileageHistory> findMileageHistoryByOrderNum(Long orderNum);
	
	/**
	 * �ʿ�
	 */
	// 1. ��ü ���ϸ��� ��ȸ
	public List<MileageHistory> findMileageByUserInfo(Customer customer);
	
	// 2. ���ϸ��� �ݾ� ����(���ϸ��� ���)
	public void setMileageHistory(Customer customer, Integer mileage);
	
	// 3. ���ϸ��� ����
	public void deleteMileageHistory(Customer customer);
}
