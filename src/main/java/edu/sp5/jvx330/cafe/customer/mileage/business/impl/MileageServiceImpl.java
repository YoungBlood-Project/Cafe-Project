package edu.sp5.jvx330.cafe.customer.mileage.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileage.business.MileageService;
import edu.sp5.jvx330.cafe.customer.mileage.dao.impl.MileageDaoImpl;

public class MileageServiceImpl implements MileageService {
	@Autowired
	private MileageDaoImpl tmDao;

	//1. Total Mileage �� ����
	//1-1. ���ϸ��� ����
	@Override
	public void addTotalMileage(Customer customer, Integer m_amount) {
		//�ش� ���� ��ü ���ϸ��� ��ȸ
		Integer totalMilleage = tmDao.findTotalMileage(customer.getCid());
		if(totalMilleage == null) {
			//���� �߰�
			tmDao.insertTotalMileage(customer.getCid(), m_amount);
			return;
		}
		//���� �ִ� ���� ���ϱ�
		totalMilleage += m_amount;
		tmDao.setTotalMileage(customer.getCid(), totalMilleage);
	}
	//1-2. ���ϸ��� ���
	@Override
	public void subtractTotalMileage(Customer customer, Integer m_amount) {
		//�ش� ���� ��ü ���ϸ��� ��ȸ
		Integer totalMilleage = tmDao.findTotalMileage(customer.getCid());
		if(totalMilleage == null || totalMilleage < m_amount) {
			System.out.println("���� �߻� tmService(���ϸ��� �ܰ� ����)");
			return;
		}
		//���� �ִ� ���� ����
		totalMilleage -= m_amount;
		tmDao.setTotalMileage(customer.getCid(), totalMilleage);
	}
	
	//2. Total Mileage ��ȸ
	@Override
	public Integer findTotalMileage(Customer customer) {
		if(tmDao.findTotalMileage(customer.getCid()) == null) {
			return null;
		}
		return tmDao.findTotalMileage(customer.getCid());
	}
	//3. Total Mileage ����
	@Override
	public void deleteTotalMileage(Customer customer) {
		tmDao.deleteTotalMileage(customer.getCid());
	}

}
