package edu.sp5.jvx330.cafe.mileage.business;

import java.util.List;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.mileage.domain.Mileage;

public interface MileageSerivce {
	
	/**
	 * ���� - ����
	 * ���ϸ��� �����ϴ� �޼ҵ尡 ��� ���ϸ��� ���� �޼ҵ带 �߰��߽��ϴ�
	 * orderNum���� ���ϸ��� ��ȸ�ϴ� �ڵ� �߰�.
	 */
	// 1. ���ϸ��� ����
	public void addMileage(Customer customer, Mileage mileage);
	
	// 2. orderNum���� ���ϸ��� ��ȸ
	public List<Mileage> findMileageByOrderNum(Long orderNum);
	
	/**
	 * �ʿ�
	 */
	// 1. ��ü ���ϸ��� ��ȸ
	public List<Mileage> findMileageByUserInfo(Customer customer);
	
	// 2. ���ϸ��� �ݾ� ����(���ϸ��� ���)
	public void setMileage(Customer customer, Integer mileage);
	
	// 3. ���ϸ��� ����
	public void deleteMileage(Customer customer);
}
