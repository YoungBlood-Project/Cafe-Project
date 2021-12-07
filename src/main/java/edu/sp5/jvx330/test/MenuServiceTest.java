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
	
	//1-1. �޴� �߰� �׽�Ʈ
	public static void addMenu() {
		Menu menu = new Menu("delete", 0, "deletedMenu");
		//Menu menu = new Menu("�ٴҶ�Dao", 5000, "��Dao");
		//Menu menu = new Menu("����Dao", 6000, "��Dao");
		//System.out.println(menu.getCustomer().getCid());
		service.addMenu(menu);
		System.out.println("MenuServiceTest : ���� �Ϸ�");
	}
	
	//1-2-1. �޴� �̸� ����
	public static void setMenuName() {
		Menu menu = service.findMenuByMenuName("�ٴҶ�Dao");
		service.setMenuName(menu, "����Dao");
		System.out.println("MenuServiceTest : �̸� ���� �Ϸ�");
	}
	//1-2-2. �޴� ���� ����
	public static void setMenuSales() {
		Menu menu = service.findMenuByMenuName("����Dao");
		service.setMenuSales(menu, 4000);
		System.out.println("MenuServiceTest : ���� ���� �Ϸ�");
	}
	//1-3. �޴�����
	public static void deleteMenu() {
		Menu menu = service.findMenuByMenuName("�ٴҶ�Dao");
		service.deleteMenu(menu);
		System.out.println("MenuServiceTest : ���� �Ϸ�");
	}
	
	//2-1. �޴� id ��ȸ(�޴� �̸����� id ��ȸ)
	public static void findMidByMenuName() {
		Menu menu = service.findMenuByMenuName("�ٴҶ�Dao");
		System.out.println("MenuServiceTest : id : "+service.findMidByMenuName(menu.getMenuName()));
	}
	//2-2. ī�װ��� �޴� id ��ȸ
	public static void findMidByCategory() {
		List<Long> mid_list = service.findMidByCategory("��Dao");
		for(Long mid : mid_list) {
			System.out.println(mid);
		}
	}
	//2-3. �޴� �̸����� �޴� ��ȸ
	public static void findMenuByMenuName() {
		System.out.println(service.findMenuByMenuName("�ٴҶ�Dao"));
	}
	//2-4. �޴� ��ü ��ȸ
	public static void findAllMenus() {
		List<Menu> mid_list = service.findAllMenus();
		for(Menu menu : mid_list) {
			System.out.println(menu);
		}
	}
}
