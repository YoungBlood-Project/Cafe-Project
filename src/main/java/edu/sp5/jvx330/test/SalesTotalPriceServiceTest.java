package edu.sp5.jvx330.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.category.item.salesTotalPrice.business.SalesTotalPriceService;
import edu.sp5.jvx330.cafe.category.item.salesTotalPrice.business.impl.SalesTotalPriceServiceImpl;
import edu.sp5.jvx330.cafe.category.item.salesTotalPrice.config.SalesTotalPriceConfig;
import edu.sp5.jvx330.cafe.category.item.salesTotalPrice.domain.SalesTotalPrice;

public class SalesTotalPriceServiceTest {
	private static SalesTotalPriceService stp_service;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SalesTotalPriceConfig.class);
		
		stp_service = context.getBean("salesTotalPriceServiceImpl", SalesTotalPriceServiceImpl.class);
		
		/**
		 * �׽�Ʈ - ��ä��
		 */
		// 1. ���ǸŰ��� ����
		//saveSalesTotalPrice();
		
		// 2. ���ǸŰ��� ���� ��ȸ
		//findAllSalesTotalPrice();
		//findSTPByOrderNum() ;
		
		// 3. ���ǸŰ��� ���� ����
		deleteSalesTotalPrice();		
			
		context.close();
	}
	
	// 1. ���ǸŰ��� ����
	public static void saveSalesTotalPrice() {
		SalesTotalPrice salesTotalPrice = new SalesTotalPrice(202112110001l, 5000, 3000);
		stp_service.saveSalesTotalPrice(salesTotalPrice);
		System.out.println("SalesTotalPrice_Service_Test : ���ǸŰ��� ���� ���� �Ϸ�");
	}

		
	/**
	 * ���ǸŰ��� ���� ��ȸ
	 */
	// 2-1. ���ǸŰ��� ���� ��ü ��ȸ
	public static void findAllSalesTotalPrice() {
		List<SalesTotalPrice> stp_list = stp_service.findAllSalesTotalPrice();
		for(SalesTotalPrice stp : stp_list) {
			System.out.println(stp);
		}
	};
		
	// 2-2. ���ǸŰ��� ���� �ֹ���ȣ�� ��ȸ
	public static void findSTPByOrderNum() {
		List<SalesTotalPrice> stp_list = stp_service.findSTPByOrderNum(202112110001l);
		for(SalesTotalPrice stp : stp_list) {
			System.out.println(stp);
		}
		
	};

	// 3. ���ǸŰ��� ���� ���� - ȯ�� �� ���
	public static void deleteSalesTotalPrice() {
		stp_service.deleteSalesTotalPrice(202112110001l);
		System.out.println("���ǸŰ��� ���� ���� �Ϸ�");
	};

	

	
	
	
	
}
