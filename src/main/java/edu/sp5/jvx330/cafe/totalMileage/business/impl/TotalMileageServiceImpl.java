package edu.sp5.jvx330.cafe.totalMileage.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.totalMileage.business.TotalMileageService;
import edu.sp5.jvx330.cafe.totalMileage.dao.impl.TotalMileageDaoImpl;

public class TotalMileageServiceImpl implements TotalMileageService {
	@Autowired
	private TotalMileageDaoImpl tmDao;

	//1. Total Mileage �� �Է�
	@Override
	public void setTotalMileage(Customer customer, Integer addMileage) {
		Integer totalMilleage = tmDao.findTotalMileage(customer.getCid());
		if(totalMilleage == null) {
			//���� �߰�
			tmDao.addTotalMileage(customer.getCid(), addMileage);
			return;
		}
		//���� �ִ� ���� ���ϱ�
		totalMilleage += addMileage;
		tmDao.setTotalMileage(customer.getCid(), totalMilleage);
	}
	//2. Total Mileage ��ȸ
	@Override
	public Integer findTotalMileage(Customer customer) {
		return tmDao.findTotalMileage(customer.getCid());
	}
	//3. Total Mileage ����
	@Override
	public void deleteTotalMileage(Customer customer) {
		tmDao.deleteTotalMileage(customer.getCid());
	}

}
