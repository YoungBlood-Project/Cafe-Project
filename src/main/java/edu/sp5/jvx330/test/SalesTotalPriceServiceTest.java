package edu.sp5.jvx330.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.config.SalesTotalPriceConfig;
import edu.sp5.jvx330.cafe.sales.business.SalesTotalPriceService;
import edu.sp5.jvx330.cafe.sales.business.impl.SalesTotalPriceServiceImpl;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

public class SalesTotalPriceServiceTest {
	private static SalesTotalPriceService stp_service;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SalesTotalPriceConfig.class);
		
		stp_service = context.getBean("salesTotalPriceServiceImpl", SalesTotalPriceServiceImpl.class);
		
		/**
		 * 테스트 - 김채현
		 */
		// 1. 총판매가격 저장
		saveSalesTotalPrice();
		
		// 2. 총판매가격 내역 조회
		//findAllSalesTotalPrice();
		//findSTPByOrderNum() ;
		
		// 3. 총판매가격 내역 삭제
		//deleteSalesTotalPrice();		
			
		context.close();
	}
	
	// 1. 총판매가격 저장
	public static void saveSalesTotalPrice() {
		SalesTotalPrice salesTotalPrice = new SalesTotalPrice(202112140001l, 30000, 28000);
		stp_service.saveSalesTotalPrice(salesTotalPrice);
		System.out.println("SalesTotalPrice_Service_Test : 총판매가격 내역 저장 완료");
	}

		
	/**
	 * 총판매가격 내역 조회
	 */
	// 2-1. 총판매가격 내역 전체 조회
	public static void findAllSalesTotalPrice() {
		List<SalesTotalPrice> stp_list = stp_service.findAllSalesTotalPrice();
		for(SalesTotalPrice stp : stp_list) {
			System.out.println(stp);
		}
	};
		
	// 2-2. 총판매가격 내역 주문번호로 조회
	public static void findSTPByOrderNum() {
		SalesTotalPrice stp = stp_service.findSTPByOrderNum(202112110001l);
		System.out.println(stp);		
	};

	// 3. 총판매가격 내역 삭제 - 환불 시 사용
	public static void deleteSalesTotalPrice() {
		stp_service.deleteSalesTotalPrice(202112110001l);
		System.out.println("총판매가격 내역 삭제 완료");
	};

	

	
	
	
	
}
