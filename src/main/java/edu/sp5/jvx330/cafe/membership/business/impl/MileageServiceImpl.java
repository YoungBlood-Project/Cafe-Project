package edu.sp5.jvx330.cafe.membership.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.membership.business.MileageService;
import edu.sp5.jvx330.cafe.membership.dao.impl.MileageDaoImpl;
import edu.sp5.jvx330.cafe.membership.domain.Customer;

public class MileageServiceImpl implements MileageService {
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	@Autowired
	private MileageDaoImpl mDao;

	// 1. Mileage 값 변경
	// 1-1. 마일리지 적립
	@Override
	public void addMileage(Customer customer, Integer m_amount) {
		// 고객 정보 받아오기
		customer = customerServiceImpl.findCustomerByUserInfo(customer.getName(), customer.getPhone());
		// 해당 고객의 전체 마일리지 조회
		Integer milleage = mDao.findMileage(customer.getCid());
		if (milleage == null) {
			// 새로 추가
			mDao.insertMileage(customer.getCid(), m_amount);
			return;
		}
		// 원래 있던 값에 더하기
		milleage += m_amount;
		mDao.setMileage(customer.getCid(), milleage);
	}

	// 1-2. 마일리지 사용
	@Override
	public void subtractMileage(Customer customer, Integer m_amount) {
		// 고객 정보 받아오기
		customer = customerServiceImpl.findCustomerByUserInfo(customer.getName(), customer.getPhone());
		// 해당 고객의 전체 마일리지 조회
		Integer mileage = mDao.findMileage(customer.getCid());
		if (mileage == null || mileage < m_amount) {
			System.out.println("에러 발생 mService(마일리지 잔고 부족)");
			return;
		}
		// 원래 있던 값에 빼기
		mileage -= m_amount;
		mDao.setMileage(customer.getCid(), mileage);
	}

	// 2. Mileage 조회
	@Override
	public Integer findMileage(Customer customer) {
		// 고객 정보 받아오기
		customer = customerServiceImpl.findCustomerByUserInfo(customer.getName(), customer.getPhone());
		if (mDao.findMileage(customer.getCid()) == null) {
			return null;
		}
		return mDao.findMileage(customer.getCid());
	}

	// 3. Mileage 삭제
	@Override
	public void deleteMileage(Customer customer) {
		// 고객 정보 받아오기
		customer = customerServiceImpl.findCustomerByUserInfo(customer.getName(), customer.getPhone());
		mDao.deleteMileage(customer.getCid());
	}

}
