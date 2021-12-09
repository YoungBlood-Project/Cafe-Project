package edu.sp5.jvx330.cafe.customer.mileage.dao;

public interface MileageDao {
	//1. Mileage 추가
	public void insertMileage(Long customerId, Integer init_mileage);
	//2. Mileage 변경
	public void setMileage(Long customerId, Integer mTotal);
	//3. Mileage 조회
	public Integer findMileage(Long customerId);
	//4. Mileage 삭제
	public void deleteMileage(Long customerId);
}
