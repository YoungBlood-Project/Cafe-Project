package edu.sp5.jvx330.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.item.business.ItemService;
import edu.sp5.jvx330.cafe.item.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.item.config.ItemConfig;
import edu.sp5.jvx330.cafe.item.domain.Item;

public class ItemServiceTest {
	private static ItemService service;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ItemConfig.class);

		service = context.getBean("menuServiceImpl", ItemSerivceImpl.class);

		/**
		 * 테스트 - 정헤윤.
		 */
		// 1. 메뉴 추가/수정/삭제
		// addMenu();
		// setMenuName();
		// setMenuSales();
		// deleteMenu();

		// 2. 메뉴 조회(이름, 카테고리, id, 전부)
		// findMidByMenuName();
		// findMidByCategory();
		// findMenuByMenuName();
		// findAllMenus();

		// 3. 주문 목록 추가/삭제
		// addOrderList();
		// deleteOrderList();

		context.close();
	}

	/**
	 * 1. 관리메뉴
	 */
	// 1-1. 메뉴 추가 테스트
	public static void addMenu() {
		Item item = new Item("deletedMenu", "delete", 0);
		// Menu menu = new Menu("라떼Dao", "바닐라Dao", 5000);
		// Menu menu = new Menu("라떼Dao", "초코Dao", 6000);
		// System.out.println(menu.getCustomer().getCid());
		service.addMenu(item);
		System.out.println("MenuServiceTest : 저장 완료");
	}

	// 1-2-1. 메뉴 이름 수정
	public static void setMenuName() {
		Item item = service.findMenuByMenuName("바닐라Dao");
		service.setMenuName(item, "딸기Dao");
		System.out.println("MenuServiceTest : 이름 변경 완료");
	}

	// 1-2-2. 메뉴 가격 수정
	public static void setMenuSales() {
		Item item = service.findMenuByMenuName("딸기Dao");
		service.setMenuSales(item, 4000);
		System.out.println("MenuServiceTest : 가격 변경 완료");
	}

	// 1-3. 메뉴삭제
	public static void deleteMenu() {
		Item item = service.findMenuByMenuName("초코Dao");
		// System.out.println("testMService :" + menu);
		service.deleteMenu(item);
		System.out.println("MenuServiceTest : 삭제 완료");
	}

	/**
	 * 2. 메뉴 조회
	 */
	// 2-1. 메뉴 id 조회(메뉴 이름으로 id 조회)
	public static void findMidByMenuName() {
		Item item = service.findMenuByMenuName("딸기Dao");
		System.out.println("MenuServiceTest : id : " + service.findMidByMenuName(item.getMenuName()));
	}

	// 2-2. 카테고리별 메뉴 id 조회
	public static void findMidByCategory() {
		List<Long> mid_list = service.findMidByCategory("라떼Dao");
		for (Long mid : mid_list) {
			System.out.println("category's mid: " + mid);
		}
	}

	// 2-3. 메뉴 이름으로 메뉴 조회
	public static void findMenuByMenuName() {
		System.out.println(service.findMenuByMenuName("초코Dao"));
	}

	// 2-4. 메뉴 전체 조회
	public static void findAllMenus() {
		List<Item> mid_list = service.findAllMenus();
		for (Item item : mid_list) {
			System.out.println(item);
		}
	}

	/**
	 * 3. 주문 목록 - 정혜윤
	 */
	// 1. 주문 목록에 메뉴 추가
	public static void addOrderList() {
		Item item = service.findMenuByMenuName("초코Dao");
		service.addOrderList(item);
		System.out.println("메뉴 추가: " + item.getMenuName() + " " + item.getMenuPrice());
	}

	// 2. 주문 목록에 메뉴 삭제
	public static void deleteOrderList() {
		Item item = service.findMenuByMenuName("초코Dao");
		List<Item> order_list = service.findAllMenus();
		service.deleteOrderList(1, order_list);
		System.out.println("메뉴 삭제 완료, 삭제 항목: " + item.getMenuName() + " " + item.getMenuPrice());

	}
}
