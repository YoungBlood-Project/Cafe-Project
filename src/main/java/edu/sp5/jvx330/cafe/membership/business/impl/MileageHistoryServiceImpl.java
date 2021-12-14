package edu.sp5.jvx330.cafe.membership.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.membership.business.MileageHistorySerivce;
import edu.sp5.jvx330.cafe.membership.dao.impl.MileageHistoryDaoImpl;
import edu.sp5.jvx330.cafe.membership.domain.Customer;
import edu.sp5.jvx330.cafe.membership.domain.MileageHistory;


public class MileageHistoryServiceImpl implements MileageHistorySerivce {
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	@Autowired
	private MileageHistoryDaoImpl mhDao;

	/**
	 * ���� - ���� ���ϸ��� �����ϴ� �޼ҵ尡 ��� ���ϸ��� ���� �޼ҵ带 �߰��߽��ϴ� orderNum���� ���ϸ��� ��ȸ�ϴ� �ڵ� �߰�.
	 */
	// 1. ���ϸ��� ����
	@Override
	public void addMileageHistory(Customer customer, MileageHistory mileageHistory) {
		customer = customerServiceImpl.findCustomerByUserInfo(customer.getName(), customer.getPhone());
		mhDao.addMileageHistory(customer.getCid(), mileageHistory);
	}

	// 2. orderNum���� ���ϸ��� ��ȸ
	@Override
	public List<MileageHistory> findMHByOrderNum(Long orderNum) {
		return mhDao.findMHByOrderNum(orderNum);
	}

	/**
	 * �ʿ�
	 */
	// 1. ���ϸ��� ��ȸ
	public List<MileageHistory> findMHByUserInfo(Customer customer) {
		return mhDao.findMHByUserInfo(customer);
	};

	// 2. ���ϸ��� �ݾ� ����(���ϸ��� ���)
	@Override
	public void setMileageHistory(Customer customer, Integer mileage) {
		mhDao.setMileageHistory(customer, mileage);
	};

	// 3. ���ϸ��� ����
	public void deleteMileageHistory(Customer customer) {
		mhDao.deleteMileageHistory(customer);
	}

}
