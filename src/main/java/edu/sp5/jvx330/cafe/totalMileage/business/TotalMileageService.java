package edu.sp5.jvx330.cafe.totalMileage.business;

import edu.sp5.jvx330.cafe.customer.domain.Customer;

public interface TotalMileageService {
	//1. Total Mileage �� �Է�
	public void setTotalMileage(Customer customer, Integer mileageTotal);
	//2. Total Mileage ��ȸ
	public Integer findTotalMileage(Customer customer);
	//3. Total Mileage ����
	public void deleteTotalMileage(Customer customer);
}
