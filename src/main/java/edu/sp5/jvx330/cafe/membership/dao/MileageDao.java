package edu.sp5.jvx330.cafe.membership.dao;

public interface MileageDao {
	//1. Mileage �߰�
	public void insertMileage(Long customerId, Integer init_mileage);
	//2. Mileage ����
	public void setMileage(Long customerId, Integer mTotal);
	//3. Mileage ��ȸ
	public Integer findMileage(Long customerId);
	//4. Mileage ����
	public void deleteMileage(Long customerId);
}
