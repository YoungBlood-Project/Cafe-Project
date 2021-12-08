package edu.sp5.jvx330.cafe.totalMileage.dao;

public interface TotalMileageDao {
	//1. Total Mileage �߰�
	public void insertTotalMileage(Long customerId, Integer init_mileage);
	//2. Total Mileage ����
	public void setTotalMileage(Long customerId, Integer mileageTotal);
	//3. Total Mileage ��ȸ
	public Integer findTotalMileage(Long customerId);
	//4. Total Mileage ����
	public void deleteTotalMileage(Long customerId);
}
