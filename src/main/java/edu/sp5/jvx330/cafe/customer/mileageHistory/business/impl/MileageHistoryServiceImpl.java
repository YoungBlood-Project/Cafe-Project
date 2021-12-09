package edu.sp5.jvx330.cafe.customer.mileageHistory.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileageHistory.business.MileageHistorySerivce;
import edu.sp5.jvx330.cafe.customer.mileageHistory.dao.impl.MileageHistoryDaoImpl;
import edu.sp5.jvx330.cafe.customer.mileageHistory.domain.MileageHistory;


public class MileageHistoryServiceImpl implements MileageHistorySerivce {
	@Autowired
	private MileageHistoryDaoImpl mileageDao;

	/**
	 * 수정 - 혜윤
	 * 마일리지 생성하는 메소드가 없어서 마일리지 생성 메소드를 추가했습니다
	 * orderNum으로 마일리지 조회하는 코드 추가.
	 */
	// 1. 마일리지 생성
	@Override
	public void addMileageHistory(Customer customer, MileageHistory mileage) {
		mileageDao.addMileageHistory(customer.getCid(), mileage);
		
	}

	// 2. orderNum으로 마일리지 조회
	@Override
	public List<MileageHistory> findMileageByOrderNum(Long orderNum) {
		return mileageDao.findMileageHistoryByOrderNum(orderNum);
	}

	/**
	 * 초원
	 */
	// 1. 마일리지 조회
	public List<MileageHistory> findMileageByUserInfo(Customer customer) {
		return mileageDao.findMileageByUserInfo(customer);	
	};

	// 2. 마일리지 금액 수정(마일리지 사용)
	@Override
	public void setMileageHistory(Customer customer, Integer mileage) {
		mileageDao.setMileageHistory(customer, mileage);
	};
	
	// 3. 마일리지 삭제
	public void deleteMileageHistory(Customer customer) {
		mileageDao.deleteMileageHistory(customer);
	}



}
