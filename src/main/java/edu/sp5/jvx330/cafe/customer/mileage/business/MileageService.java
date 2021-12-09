package edu.sp5.jvx330.cafe.customer.mileage.business;

import edu.sp5.jvx330.cafe.customer.domain.Customer;

public interface MileageService {
	//1. Total Mileage �� ����
	//1-1. ���ϸ��� ����
	public void addTotalMileage(Customer custeomr, Integer m_amount);
	//1-2. ���ϸ��� ���
	public void subtractTotalMileage(Customer customer, Integer m_amount);
	
	//2. Total Mileage ��ȸ
	public Integer findTotalMileage(Customer customer);
	
	//3. Total Mileage ����
	public void deleteTotalMileage(Customer customer);
}
