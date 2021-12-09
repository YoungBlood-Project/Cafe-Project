package edu.sp5.jvx330.cafe.customer.mileageHistory.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileageHistory.business.MileageSerivce;
import edu.sp5.jvx330.cafe.customer.mileageHistory.dao.impl.MileageDaoImpl;
import edu.sp5.jvx330.cafe.customer.mileageHistory.domain.MileageHistory;


public class MileageServiceImpl implements MileageSerivce {
	@Autowired
	private MileageDaoImpl mileageDao;

	/**
	 * ���� - ����
	 * ���ϸ��� �����ϴ� �޼ҵ尡 ��� ���ϸ��� ���� �޼ҵ带 �߰��߽��ϴ�
	 * orderNum���� ���ϸ��� ��ȸ�ϴ� �ڵ� �߰�.
	 */
	// 1. ���ϸ��� ����
	@Override
	public void addMileageHistory(Customer customer, MileageHistory mileage) {
		mileageDao.addMileageHistory(customer.getCid(), mileage);
		
	}

	// 2. orderNum���� ���ϸ��� ��ȸ
	@Override
	public List<MileageHistory> findMileageByOrderNum(Long orderNum) {
		return mileageDao.findMileageByOrderNum(orderNum);
	}

	/**
	 * �ʿ�
	 */
	// 1. ���ϸ��� ��ȸ
	public List<MileageHistory> findMileageByUserInfo(Customer customer) {
		return mileageDao.findMileageByUserInfo(customer);	
	};

	// 2. ���ϸ��� �ݾ� ����(���ϸ��� ���)
	@Override
	public void setMileageHistory(Customer customer, Integer mileage) {
		mileageDao.setMileageHistory(customer, mileage);
	};
	
	// 3. ���ϸ��� ����
	public void deleteMileageHistory(Customer customer) {
		mileageDao.deleteMileageHistory(customer);
	}



}
