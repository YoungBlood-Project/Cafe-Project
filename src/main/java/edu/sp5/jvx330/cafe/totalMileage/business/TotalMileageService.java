package edu.sp5.jvx330.cafe.totalMileage.business;

import edu.sp5.jvx330.cafe.customer.domain.Customer;

public interface TotalMileageService {
	//1. Total Mileage 값 입력
	public void setTotalMileage(Customer customer, Integer mileageTotal);
	//2. Total Mileage 조회
	public Integer findTotalMileage(Customer customer);
	//3. Total Mileage 삭제
	public void deleteTotalMileage(Customer customer);
}
