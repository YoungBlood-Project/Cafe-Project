package edu.sp5.jvx330.cafe.mileage.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.mileage.business.MileageSerivce;
import edu.sp5.jvx330.cafe.mileage.dao.impl.MileageDaoImpl;
import edu.sp5.jvx330.cafe.mileage.domain.Mileage;

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
	public void addMileage(Customer customer, Mileage mileage) {
		mileageDao.addMileage(customer.getCid(), mileage);
		
	}

	// 2. orderNum���� ���ϸ��� ��ȸ
	@Override
	public List<Mileage> findMileageByOrderNum(Long orderNum) {
		return mileageDao.findMileageByOrderNum(orderNum);
	}

	/**
	 * �ʿ�
	 */
	// 1. ���ϸ��� ��ȸ
	public List<Mileage> findMileageByUserInfo(Customer customer) {
		return mileageDao.findMileageByUserInfo(customer);	
	};

	// 2. ���ϸ��� �ݾ� ����(���ϸ��� ���)
	@Override
	public void setMileage(Customer customer, Integer mileage) {
		mileageDao.setMileage(customer, mileage);
	};
	
	// 3. ���ϸ��� ����
	public void deleteMileage(Customer customer) {
		mileageDao.deleteMileage(customer);
	}



}
