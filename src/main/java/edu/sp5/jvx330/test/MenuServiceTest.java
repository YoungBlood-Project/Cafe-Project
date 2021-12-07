package edu.sp5.jvx330.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.menu.business.MenuService;
import edu.sp5.jvx330.cafe.menu.business.impl.MenuSerivceImpl;
import edu.sp5.jvx330.cafe.menu.config.MenuConfig;
import edu.sp5.jvx330.cafe.menu.dao.MenuDao;
import edu.sp5.jvx330.cafe.menu.dao.impl.MenuDaoImpl;
import edu.sp5.jvx330.cafe.menu.domain.Menu;

public class MenuServiceTest {
	private static MenuService service;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(MenuConfig.class);
		
		service = context.getBean("menuServiceImpl", MenuSerivceImpl.class);
		
		addMenu();
		//setMenuName();
		//setMenuSales();
		//deleteMenu();
		//findMidByMenuName();
		//findMidByCategory();
		//findMenuByMenuName();
		findAllMenus();
		
		context.close();
	}
	
	//1-1. 메뉴 추가 테스트
	public static void addMenu() {
		Menu menu = new Menu("delete", 0, "deletedMenu");
		//Menu menu = new Menu("바닐라Dao", 5000, "라떼Dao");
		//Menu menu = new Menu("초코Dao", 6000, "라떼Dao");
		//System.out.println(menu.getCustomer().getCid());
		service.addMenu(menu);
		System.out.println("MenuServiceTest : 저장 완료");
	}
	
	//1-2-1. 메뉴 이름 수정
	public static void setMenuName() {
		Menu menu = service.findMenuByMenuName("바닐라Dao");
		service.setMenuName(menu, "딸기Dao");
		System.out.println("MenuServiceTest : 이름 변경 완료");
	}
	//1-2-2. 메뉴 가격 수정
	public static void setMenuSales() {
		Menu menu = service.findMenuByMenuName("딸기Dao");
		service.setMenuSales(menu, 4000);
		System.out.println("MenuServiceTest : 가격 변경 완료");
	}
	//1-3. 메뉴삭제
	public static void deleteMenu() {
		Menu menu = service.findMenuByMenuName("바닐라Dao");
		service.deleteMenu(menu);
		System.out.println("MenuServiceTest : 삭제 완료");
	}
	
	//2-1. 메뉴 id 조회(메뉴 이름으로 id 조회)
	public static void findMidByMenuName() {
		Menu menu = service.findMenuByMenuName("바닐라Dao");
		System.out.println("MenuServiceTest : id : "+service.findMidByMenuName(menu.getMenuName()));
	}
	//2-2. 카테고리별 메뉴 id 조회
	public static void findMidByCategory() {
		List<Long> mid_list = service.findMidByCategory("라떼Dao");
		for(Long mid : mid_list) {
			System.out.println(mid);
		}
	}
	//2-3. 메뉴 이름으로 메뉴 조회
	public static void findMenuByMenuName() {
		System.out.println(service.findMenuByMenuName("바닐라Dao"));
	}
	//2-4. 메뉴 전체 조회
	public static void findAllMenus() {
		List<Menu> mid_list = service.findAllMenus();
		for(Menu menu : mid_list) {
			System.out.println(menu);
		}
	}
}
