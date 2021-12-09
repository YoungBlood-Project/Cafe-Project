package edu.sp5.jvx330.cafe.customer.mileage.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileage.business.MileageService;
import edu.sp5.jvx330.cafe.customer.mileage.dao.impl.MileageDaoImpl;

public class MileageServiceImpl implements MileageService {
	@Autowired
	private MileageDaoImpl tmDao;

	//1. Total Mileage 값 변경
	//1-1. 마일리지 적립
	@Override
	public void addTotalMileage(Customer customer, Integer m_amount) {
		//해당 고객의 전체 마일리지 조회
		Integer totalMilleage = tmDao.findTotalMileage(customer.getCid());
		if(totalMilleage == null) {
			//새로 추가
			tmDao.insertTotalMileage(customer.getCid(), m_amount);
			return;
		}
		//원래 있던 값에 더하기
		totalMilleage += m_amount;
		tmDao.setTotalMileage(customer.getCid(), totalMilleage);
	}
	//1-2. 마일리지 사용
	@Override
	public void subtractTotalMileage(Customer customer, Integer m_amount) {
		//해당 고객의 전체 마일리지 조회
		Integer totalMilleage = tmDao.findTotalMileage(customer.getCid());
		if(totalMilleage == null || totalMilleage < m_amount) {
			System.out.println("에러 발생 tmService(마일리지 잔고 부족)");
			return;
		}
		//원래 있던 값에 빼기
		totalMilleage -= m_amount;
		tmDao.setTotalMileage(customer.getCid(), totalMilleage);
	}
	
	//2. Total Mileage 조회
	@Override
	public Integer findTotalMileage(Customer customer) {
		if(tmDao.findTotalMileage(customer.getCid()) == null) {
			return null;
		}
		return tmDao.findTotalMileage(customer.getCid());
	}
	//3. Total Mileage 삭제
	@Override
	public void deleteTotalMileage(Customer customer) {
		tmDao.deleteTotalMileage(customer.getCid());
	}

}
