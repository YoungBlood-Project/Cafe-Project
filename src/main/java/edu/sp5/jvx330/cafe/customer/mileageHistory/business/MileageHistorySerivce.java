package edu.sp5.jvx330.cafe.customer.mileageHistory.business;

import java.util.List;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileageHistory.domain.MileageHistory;

public interface MileageHistorySerivce {
	
	/**
	 * ���� - ����
	 * ���ϸ��� �����ϴ� �޼ҵ尡 ��� ���ϸ��� ���� �޼ҵ带 �߰��߽��ϴ�
	 * orderNum���� ���ϸ��� ��ȸ�ϴ� �ڵ� �߰�.
	 */
	// 1. ���ϸ��� ����
	public void addMileageHistory(Customer customer, MileageHistory mileageHistory);
	
	// 2. orderNum���� ���ϸ��� ��ȸ
	public List<MileageHistory> findMHByOrderNum(Long orderNum);
	
	/**
	 * �ʿ�
	 */
	// 1. ��ü ���ϸ��� ��ȸ
	public List<MileageHistory> findMHByUserInfo(Customer customer);
	
	// 2. ���ϸ��� �ݾ� ����(���ϸ��� ���)
	public void setMileageHistory(Customer customer, Integer mileage);
	
	// 3. ���ϸ��� ����
	public void deleteMileageHistory(Customer customer);
}
