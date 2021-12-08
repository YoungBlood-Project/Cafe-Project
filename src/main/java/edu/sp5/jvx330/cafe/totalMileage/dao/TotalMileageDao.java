package edu.sp5.jvx330.cafe.totalMileage.dao;

public interface TotalMileageDao {
	//1. Total Mileage 추가
	public void insertTotalMileage(Long customerId, Integer init_mileage);
	//2. Total Mileage 변경
	public void setTotalMileage(Long customerId, Integer mileageTotal);
	//3. Total Mileage 조회
	public Integer findTotalMileage(Long customerId);
	//4. Total Mileage 삭제
	public void deleteTotalMileage(Long customerId);
}
