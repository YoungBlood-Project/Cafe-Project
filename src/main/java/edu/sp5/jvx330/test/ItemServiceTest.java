package edu.sp5.jvx330.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.category.business.CategoryService;
import edu.sp5.jvx330.cafe.category.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.category.domain.Category;
import edu.sp5.jvx330.cafe.category.item.business.ItemService;
import edu.sp5.jvx330.cafe.category.item.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.category.item.config.ItemConfig;
import edu.sp5.jvx330.cafe.category.item.domain.Item;



public class ItemServiceTest {
	private static ItemService service;
	private static CategoryService cService;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ItemConfig.class);

		service = context.getBean("itemServiceImpl", ItemSerivceImpl.class);
		cService = context.getBean("categoryServiceImpl", CategoryServiceImpl.class);

		/**
		 * 테스트 - 이초원.
		 */
		// 1. 메뉴 추가/수정/삭제
		addItem();
		//setItemName();
		//setItemPrice();
		//deleteItem();

		// 2. 메뉴 조회(이름, 카테고리, id, 전부)
		//findItemIdByItemName();
		//findItemIdByCategory();
		//findItemByItemName();
		//findAllItems();
		
		// 3. 주문 목록 추가/삭제
		//addOrderList();
		//deleteOrderList();

		context.close();
	}

	/**
	 * 1. 관리메뉴
	 */
	// 1-1. 메뉴 추가 테스트
	public static void addItem() {
		//Category category = cService.findCategoryByCategoryName("deletedMenu");
		Category category = cService.findCategoryByCategoryName("라떼Dao");
		//Item item = new Item(category, "delete", 0); //deletedMenu 카테고리에 넣기
		Item item = new Item(category, "바닐라Dao", 5000);
		item.setItemUrl("주소");
		//Item item = new Item(category, "초코Dao", 6000);
		//System.out.println(menu.getCustomer().getCid());
		service.addItem(item);
		System.out.println("ItemServiceTest : 저장 완료");
	}

	// 1-2-1. 메뉴 이름 수정
	public static void setItemName() {
		Item item = service.findItemByItemName("바닐라Dao");
		System.out.println(item);
		service.setItemName(item, "딸기Dao");
		System.out.println("ItemServiceTest : 이름 변경 완료");
	}

	// 1-2-2. 메뉴 가격 수정
	public static void setItemPrice() {
		Item item = service.findItemByItemName("딸기Dao");
		service.setItemPrice(item, 4000);
		System.out.println("ItemServiceTest : 가격 변경 완료");
	}

	// 1-3. 메뉴삭제
	public static void deleteItem() {
		Item item = service.findItemByItemName("초코Dao");
		System.out.println("deleteItem :" + item);
		service.deleteItem(item);
		System.out.println("ItemServiceTest : 삭제 완료");
	}

	/**
	 * 2. 메뉴 조회
	 */
	// 2-1. 메뉴 id 조회(메뉴 이름으로 id 조회)
	public static void findItemIdByItemName() {
		Item item = service.findItemByItemName("딸기Dao");
		System.out.println("ItemServiceTest : id : " + service.findItemIdByItemName(item.getItemName()));
	}

	// 2-2. 카테고리별 메뉴 id 조회
	public static void findItemIdByCategory() {
		Category category = cService.findCategoryByCategoryName("라떼Dao");
		List<Item> item_list = service.findItemsByCategory(category);
		for (Item itme : item_list) {
			System.out.println("category's itemId: " + itme);
		}
	}

	// 2-3. 아이템 이름으로 메뉴 조회
	public static void findItemByItemName() {
		System.out.println(service.findItemByItemName("초코Dao"));
	}

	// 2-4. 아이템 전체 조회
	public static void findAllItems() {
		List<Item> mid_list = service.findAllItems();
		for (Item item : mid_list) {
			System.out.println(item);
		}
	}

	/**
	 * 3. 주문 목록 - 정혜윤
	 */
	// 1. 주문 목록에 메뉴 추가
	public static void addOrderList() {
		Item item = service.findItemByItemName("초코Dao");
		service.addOrderList(item);
		System.out.println("메뉴 추가: " + item.getItemName() + " " + item.getItemPrice());
	}

	// 2. 주문 목록에 메뉴 삭제
	public static void deleteOrderList() {
		Item item = service.findItemByItemName("초코Dao");
		List<Item> order_list = service.findAllItems();
		service.deleteOrderList(1, order_list);
		System.out.println("메뉴 삭제 완료, 삭제 항목: " + item.getItemName() + " " + item.getItemPrice());

	}
}
