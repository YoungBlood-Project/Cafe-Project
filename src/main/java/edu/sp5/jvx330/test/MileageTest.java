package edu.sp5.jvx330.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.customer.business.CustomerService;
import edu.sp5.jvx330.cafe.customer.business.impl.CustomerServiceImpl;
import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileageHistory.business.MileageSerivce;
import edu.sp5.jvx330.cafe.customer.mileageHistory.business.impl.MileageServiceImpl;
import edu.sp5.jvx330.cafe.customer.mileageHistory.config.MileageConfig;
import edu.sp5.jvx330.cafe.customer.mileageHistory.domain.MileageHistory;

public class MileageTest {
	private static CustomerService customerService;
	private static MileageSerivce mileageService;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MileageConfig.class);
		
		mileageService = context.getBean("mileageServiceImpl", MileageServiceImpl.class);
		customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);

		// 1. 마일리지 생성 
		// addMileage();
		  
		// 2. 마일리지 조회
		// findMileageByUserInfo();
		// fineMileageByOrderNum();
		  
		// 3. 마일리지 금액 수정 
		// setMileage();
		  
		// 4. 마일리지 삭제  
		// deleteMileage();

		context.close();
	}
	
	
	/**
	 * 수정 - 정혜윤
	 * 마일리지 생성하는 메소드가 없어서 마일리지 생성 메소드를 추가했습니다
	 */
	// 1. 마일리지 생성
	public static void addMileage() {
		Customer customer = customerService.findCustomerByUserInfo("A", "1");
		MileageHistory mileage = new MileageHistory(customer, 201212060001l, 500);
		mileageService.addMileageHistory(customer, mileage);
		System.out.println("MileageService : 저장 완료.");
		
	}
	// 2. 마일리지 조회
	public static void findMileageByUserInfo() {
		Customer customer = customerService.findCustomerByUserInfo("A", "1");
		List<MileageHistory> mileage_list = mileageService.findMileageByUserInfo(customer);
		System.out.println("마일리지 조회 시작--------------");
		for(MileageHistory m : mileage_list) {
			System.out.println(m);
		}
	}
	
	
	/**
	 * 정혜윤 - orderNum으로 마일리지 조회하는 코드 추가.
	 * @param orderNum
	 */
	// 2-1. orderNum으로 마일리지 조회
	public static void fineMileageByOrderNum() {
		List<MileageHistory> mileage_list = mileageService.findMileageByOrderNum(201212060001l);
		for (MileageHistory mileage : mileage_list) {
			System.out.println(mileage);
		}
	}
	
	// 3. 마일리지 금액 수정(마일리지 사용)
	public static void setMileage() {
		Customer customer = customerService.findCustomerByUserInfo("A", "1");
		mileageService.setMileageHistory(customer, 10);
		System.out.println("mileageService : 마일리지 가격 설정 완료.");
		
	}
	
	// 4. 마일리지 삭제
	public static void deleteMileage() {
		Customer customer = customerService.findCustomerByUserInfo("A", "1");
		mileageService.deleteMileageHistory(customer);
		System.out.println("mileageService: 삭제 완료.");
	}
}
