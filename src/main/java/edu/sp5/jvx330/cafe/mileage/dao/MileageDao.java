package edu.sp5.jvx330.cafe.mileage.dao;

import java.util.List;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.mileage.domain.Mileage;

public interface MileageDao {
	/**
	 * 수정 - 혜윤
	 * @param customer
	 */
	// 1. 마일리지 생성
	public void addMileage(Long customerId, Mileage mileage);
	
	// 2. orderNum으로 마일리지 조회
	public List<Mileage> findMileageByOrderNum(Long orderNum);
	
	/**
	 * 초원
	 */
	// 1. 전체 마일리지 조회
	public List<Mileage> findMileageByUserInfo(Customer customer);
	
	// 2. 마일리지 금액 수정(마일리지 사용)
	public void setMileage(Customer customer, Integer mileage);
	
	// 3. 마일리지 삭제
	public void deleteMileage(Customer customer);
}
