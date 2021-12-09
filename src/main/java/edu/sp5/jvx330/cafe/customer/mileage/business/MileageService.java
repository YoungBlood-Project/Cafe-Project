package edu.sp5.jvx330.cafe.customer.mileage.business;

import edu.sp5.jvx330.cafe.customer.domain.Customer;

public interface MileageService {
	//1. Total Mileage 값 변경
	//1-1. 마일리지 적립
	public void addTotalMileage(Customer custeomr, Integer m_amount);
	//1-2. 마일리지 사용
	public void subtractTotalMileage(Customer customer, Integer m_amount);
	
	//2. Total Mileage 조회
	public Integer findTotalMileage(Customer customer);
	
	//3. Total Mileage 삭제
	public void deleteTotalMileage(Customer customer);
}
