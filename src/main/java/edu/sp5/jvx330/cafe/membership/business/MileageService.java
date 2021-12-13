package edu.sp5.jvx330.cafe.membership.business;

import edu.sp5.jvx330.cafe.membership.domain.Customer;

public interface MileageService {
	//1. Mileage �� ����
	//1-1. ���ϸ��� ����
	public void addMileage(Customer custeomr, Integer m_amount);
	//1-2. ���ϸ��� ���
	public void subtractMileage(Customer customer, Integer m_amount);
	
	//2. Mileage ��ȸ
	public Integer findMileage(Customer customer);
	
	//3. Mileage ����
	public void deleteMileage(Customer customer);
}
