package edu.sp5.jvx330.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.menu.business.MenuService;
import edu.sp5.jvx330.cafe.menu.business.impl.MenuSerivceImpl;
import edu.sp5.jvx330.cafe.menu.domain.Menu;
import edu.sp5.jvx330.cafe.salesHistory.business.SalesHistoryService;
import edu.sp5.jvx330.cafe.salesHistory.business.impl.SalesHistoryServiceImpl;
import edu.sp5.jvx330.cafe.salesHistory.config.SalesHistoryConfig;
import edu.sp5.jvx330.cafe.salesHistory.domain.SalesHistory;

public class SalesHistorySerivceTest {
	private static SalesHistoryService sh_service;
	private static MenuService m_service;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SalesHistoryConfig.class);
		
		sh_service = context.getBean("salesHistoryServiceImpl", SalesHistoryServiceImpl.class);
		m_service = context.getBean("menuServiceImpl", MenuSerivceImpl.class);
		
		//addSalesHistory();
		findAllSalesHistory();
		//findSalesHistoryByOrderDate();
		//findSalesHistoryByMenu();
		//countSalesHistoryByOrderDate();
		
		context.close();
	}
	/**
	 * 1. 판매내역 추가
	 */
	public static void addSalesHistory() {
		Menu menu = m_service.findMenuByMenuName("바닐라Dao");
		SalesHistory salesHistory =
				new SalesHistory(menu, 3, menu.getMenuPrice()*3);
				//new SalesHistory(menu, 1, menu.getMenuPrice()*1);
		sh_service.addSalesHistory(menu, salesHistory);
		//System.out.println("SalesHistorySerivceTest : 판매내역 저장 완료");
	}
	
	/**
	 * 2. 판매내역 조회
	 */
	//2-1. 판매내역 전체 조회
	public static void findAllSalesHistory() {
		List<SalesHistory> sh_list = sh_service.findAllSalesHistory();
		for(SalesHistory sh : sh_list) {
			System.out.println(sh);
		}
	}
	//2-2. 해당 날짜로 판매내역 조회
	public static void findSalesHistoryByOrderDate() {
		List<SalesHistory> sh_list = sh_service.findSalesHistoryByOrderDate(new Date());
		for(SalesHistory sh : sh_list) {
			System.out.println(sh);
		}
	}
	//2-3. 해당 메뉴로 판매내역 조회(menuId 사용)
	public static void findSalesHistoryByMenu() {
		Menu menu = m_service.findMenuByMenuName("바닐라Dao");
		List<SalesHistory> sh_list = sh_service.findSalesHistoryByMenu(menu);
		for(SalesHistory sh : sh_list) {
			System.out.println(sh);
		}
	}
	
	/**
	 * 3. 판매내역 삭제
	 */
	//3-1. 환불
	public static void deleteSalesHistoryByOrderDate() {
		
	}
	//3-2. 해당 메뉴의 판매내역 전체 삭제
	public static void deleteAllSalesHistories() {
		
	}
	
	/**
	 * 4. 날짜별 판매내역 개수
	 */
	public static void countSalesHistoryByOrderDate() {
		System.out.println(sh_service.countSalesHistoryByOrderDate(new Date()));
	}
	
}
