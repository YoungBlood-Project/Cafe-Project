package edu.sp5.jvx330.cafe.customer.mileageHistory.dao;

import java.util.List;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileageHistory.domain.MileageHistory;

public interface MileageDao {
	/**
	 * 수정 - 혜윤
	 * @param customer
	 */
	// 1. 마일리지 생성
	public void addMileageHistory(Long customerId, MileageHistory mileage);
	
	// 2. orderNum으로 마일리지 조회
	public List<MileageHistory> findMileageByOrderNum(Long orderNum);
	
	/**
	 * 초원
	 */
	// 1. 전체 마일리지 조회
	public List<MileageHistory> findMileageByUserInfo(Customer customer);
	
	// 2. 마일리지 금액 수정(마일리지 사용)
	public void setMileageHistory(Customer customer, Integer mileage);
	
	// 3. 마일리지 삭제
	public void deleteMileageHistory(Customer customer);
}
