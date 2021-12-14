package edu.sp5.jvx330.cafe.membership.business;

import edu.sp5.jvx330.cafe.membership.domain.Customer;

public interface MileageService {
	//1. Mileage 값 변경
	//1-1. 마일리지 적립
	public void addMileage(Customer custeomr, Integer m_amount);
	//1-2. 마일리지 사용
	public void subtractMileage(Customer customer, Integer m_amount);
	
	//2. Mileage 조회
	public Integer findMileage(Customer customer);
	
	//3. Mileage 삭제
	public void deleteMileage(Customer customer);
}
