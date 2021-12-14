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
	 * 수정 - 혜윤 마일리지 생성하는 메소드가 없어서 마일리지 생성 메소드를 추가했습니다 orderNum으로 마일리지 조회하는 코드 추가.
	 */
	// 1. 마일리지 생성
	@Override
	public void addMileageHistory(Customer customer, MileageHistory mileageHistory) {
		customer = customerServiceImpl.findCustomerByUserInfo(customer.getName(), customer.getPhone());
		mhDao.addMileageHistory(customer.getCid(), mileageHistory);
	}

	// 2. orderNum으로 마일리지 조회
	@Override
	public List<MileageHistory> findMHByOrderNum(Long orderNum) {
		return mhDao.findMHByOrderNum(orderNum);
	}

	/**
	 * 초원
	 */
	// 1. 마일리지 조회
	public List<MileageHistory> findMHByUserInfo(Customer customer) {
		return mhDao.findMHByUserInfo(customer);
	};

	// 2. 마일리지 금액 수정(마일리지 사용)
	@Override
	public void setMileageHistory(Customer customer, Integer mileage) {
		mhDao.setMileageHistory(customer, mileage);
	};

	// 3. 마일리지 삭제
	public void deleteMileageHistory(Customer customer) {
		mhDao.deleteMileageHistory(customer);
	}

}
