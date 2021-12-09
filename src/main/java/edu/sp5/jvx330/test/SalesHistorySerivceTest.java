package edu.sp5.jvx330.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.menu.business.MenuService;
import edu.sp5.jvx330.cafe.menu.business.impl.MenuSerivceImpl;
import edu.sp5.jvx330.cafe.menu.domain.Menu;
import edu.sp5.jvx330.cafe.menu.salesHistory.business.SalesHistoryService;
import edu.sp5.jvx330.cafe.menu.salesHistory.business.impl.SalesHistoryServiceImpl;
import edu.sp5.jvx330.cafe.menu.salesHistory.config.SalesHistoryConfig;
import edu.sp5.jvx330.cafe.menu.salesHistory.domain.SalesHistory;

public class SalesHistorySerivceTest {
	private static SalesHistoryService sh_service;
	private static MenuService m_service;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SalesHistoryConfig.class);
		
		sh_service = context.getBean("salesHistoryServiceImpl", SalesHistoryServiceImpl.class);
		m_service = context.getBean("menuServiceImpl", MenuSerivceImpl.class);
		
		/**
		 * 테스트 - 정혜윤.
		 */
		// 1. 판매 내역 추가
		// addSalesHistory();
		
		// 2. 판매 내역 조회
		// findAllSalesHistory();
		// findSalesHistoryByOrderDate();
		// findSalesHistoryByMenu();
		// findSalesHistoryByOrderNum();
		
		// 3. 환불
		// deleteSalesHistoryBySid();
		// deleteAllSalesHistories();
		
		// 4. 날짜별 판매 내역 개수
		//countSalesHistoryByOrderDate();
	
		context.close();
	}
	/**
	 * 1. 판매내역 추가
	 */
	public static void addSalesHistory() {
		Menu menu = m_service.findMenuByMenuName("딸기Dao");
		SalesHistory salesHistory =
				new SalesHistory(menu, 3, menu.getMenuPrice()*3);
		salesHistory.setOrderNum(202112070001l);
				//new SalesHistory(menu, 1, menu.getMenuPrice()*1);
		sh_service.addSalesHistory(menu, salesHistory);
		System.out.println("SalesHistorySerivceTest : 판매내역 저장 완료");
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
		Menu menu = m_service.findMenuByMenuName("딸기Dao");
		List<SalesHistory> sh_list = sh_service.findSalesHistoryByMenu(menu);
		for(SalesHistory sh : sh_list) {
			System.out.println(sh);
		}
	}
	
	/**
	 * 추가 - 혜윤
	 * 2-4. 해당 주문 번호로 판매 내역 조회, 3. 판매 내역 삭제 부분
	 */
	
	//2-4. 해당 주문 번호로 판매 내역 조회
	public static void findSalesHistoryByOrderNum() {
		List<SalesHistory> sh_list = sh_service.findSalesHistoryByOrderNum(202112070001l);
		for (SalesHistory sh : sh_list) {
			System.out.println(sh);
		}
	}
	
	/**
	 * 3. 판매 내역 삭제
	 */
	//3-1. 환불
	public static void deleteSalesHistoryBySid() {
		Menu menu = m_service.findMenuByMenuName("딸기Dao");
		List<SalesHistory> sh_list = sh_service.findSalesHistoryByMenu(menu);
		System.out.println("판매 내역 삭제 완료: " + menu.getMenuName());
	}
	
	//3-2. 해당 메뉴의 판매내역 전체 삭제
	public static void deleteAllSalesHistories() {
		Menu menu = m_service.findMenuByMenuName("초코Dao");
		sh_service.deleteAllSalesHistories(menu);
		System.out.println("판매 내역 전체 삭제 완료");
	}
	
	/**
	 * 4. 날짜별 판매내역 개수
	 */
	public static void countSalesHistoryByOrderDate() {
		System.out.println(sh_service.countSalesHistoryByOrderDate(new Date()));
	}
	
}

