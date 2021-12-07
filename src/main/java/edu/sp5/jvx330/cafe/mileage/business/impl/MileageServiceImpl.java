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
	 * 수정 - 혜윤
	 * 마일리지 생성하는 메소드가 없어서 마일리지 생성 메소드를 추가했습니다
	 * orderNum으로 마일리지 조회하는 코드 추가.
	 */
	// 1. 마일리지 생성
	@Override
	public void addMileage(Customer customer, Mileage mileage) {
		mileageDao.addMileage(customer.getCid(), mileage);
		
	}

	// 2. orderNum으로 마일리지 조회
	@Override
	public List<Mileage> findMileageByOrderNum(Long orderNum) {
		return mileageDao.findMileageByOrderNum(orderNum);
	}

	/**
	 * 초원
	 */
	// 1. 마일리지 조회
	public List<Mileage> findMileageByUserInfo(Customer customer) {
		return mileageDao.findMileageByUserInfo(customer);	
	};

	// 2. 마일리지 금액 수정(마일리지 사용)
	@Override
	public void setMileage(Customer customer, Integer mileage) {
		mileageDao.setMileage(customer, mileage);
	};
	
	// 3. 마일리지 삭제
	public void deleteMileage(Customer customer) {
		mileageDao.deleteMileage(customer);
	}



}
