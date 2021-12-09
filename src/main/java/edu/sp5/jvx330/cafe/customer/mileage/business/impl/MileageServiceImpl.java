package edu.sp5.jvx330.cafe.customer.mileage.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileage.business.MileageService;
import edu.sp5.jvx330.cafe.customer.mileage.dao.impl.MileageDaoImpl;

public class MileageServiceImpl implements MileageService {
	@Autowired
	private MileageDaoImpl mDao;

	// 1. Mileage �� ����
	// 1-1. ���ϸ��� ����
	@Override
	public void addMileage(Customer customer, Integer m_amount) {
		// �ش� ���� ��ü ���ϸ��� ��ȸ
		Integer milleage = mDao.findMileage(customer.getCid());
		if (milleage == null) {
			// ���� �߰�
			mDao.insertMileage(customer.getCid(), m_amount);
			return;
		}
		// ���� �ִ� ���� ���ϱ�
		milleage += m_amount;
		mDao.setMileage(customer.getCid(), milleage);
	}

	// 1-2. ���ϸ��� ���
	@Override
	public void subtractMileage(Customer customer, Integer m_amount) {
		// �ش� ���� ��ü ���ϸ��� ��ȸ
		Integer mileage = mDao.findMileage(customer.getCid());
		if (mileage == null || mileage < m_amount) {
			System.out.println("���� �߻� mService(���ϸ��� �ܰ� ����)");
			return;
		}
		// ���� �ִ� ���� ����
		mileage -= m_amount;
		mDao.setMileage(customer.getCid(), mileage);
	}

	// 2. Mileage ��ȸ
	@Override
	public Integer findMileage(Customer customer) {
		if (mDao.findMileage(customer.getCid()) == null) {
			return null;
		}
		return mDao.findMileage(customer.getCid());
	}

	// 3. Mileage ����
	@Override
	public void deleteMileage(Customer customer) {
		mDao.deleteMileage(customer.getCid());
	}

}
