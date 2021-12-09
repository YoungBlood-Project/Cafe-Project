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
		 * �׽�Ʈ - ������.
		 */
		// 1. �޴� �߰�/����/����
		// addMenu();
		// setMenuName();
		// setMenuSales();
		// deleteMenu();

		// 2. �޴� ��ȸ(�̸�, ī�װ�, id, ����)
		// findMidByMenuName();
		// findMidByCategory();
		// findMenuByMenuName();
		// findAllMenus();

		// 3. �ֹ� ��� �߰�/����
		// addOrderList();
		// deleteOrderList();

		context.close();
	}

	/**
	 * 1. �����޴�
	 */
	// 1-1. �޴� �߰� �׽�Ʈ
	public static void addMenu() {
		Item item = new Item("deletedMenu", "delete", 0);
		// Menu menu = new Menu("��Dao", "�ٴҶ�Dao", 5000);
		// Menu menu = new Menu("��Dao", "����Dao", 6000);
		// System.out.println(menu.getCustomer().getCid());
		service.addMenu(item);
		System.out.println("MenuServiceTest : ���� �Ϸ�");
	}

	// 1-2-1. �޴� �̸� ����
	public static void setMenuName() {
		Item item = service.findMenuByMenuName("�ٴҶ�Dao");
		service.setMenuName(item, "����Dao");
		System.out.println("MenuServiceTest : �̸� ���� �Ϸ�");
	}

	// 1-2-2. �޴� ���� ����
	public static void setMenuSales() {
		Item item = service.findMenuByMenuName("����Dao");
		service.setMenuSales(item, 4000);
		System.out.println("MenuServiceTest : ���� ���� �Ϸ�");
	}

	// 1-3. �޴�����
	public static void deleteMenu() {
		Item item = service.findMenuByMenuName("����Dao");
		// System.out.println("testMService :" + menu);
		service.deleteMenu(item);
		System.out.println("MenuServiceTest : ���� �Ϸ�");
	}

	/**
	 * 2. �޴� ��ȸ
	 */
	// 2-1. �޴� id ��ȸ(�޴� �̸����� id ��ȸ)
	public static void findMidByMenuName() {
		Item item = service.findMenuByMenuName("����Dao");
		System.out.println("MenuServiceTest : id : " + service.findMidByMenuName(item.getMenuName()));
	}

	// 2-2. ī�װ��� �޴� id ��ȸ
	public static void findMidByCategory() {
		List<Long> mid_list = service.findMidByCategory("��Dao");
		for (Long mid : mid_list) {
			System.out.println("category's mid: " + mid);
		}
	}

	// 2-3. �޴� �̸����� �޴� ��ȸ
	public static void findMenuByMenuName() {
		System.out.println(service.findMenuByMenuName("����Dao"));
	}

	// 2-4. �޴� ��ü ��ȸ
	public static void findAllMenus() {
		List<Item> mid_list = service.findAllMenus();
		for (Item item : mid_list) {
			System.out.println(item);
		}
	}

	/**
	 * 3. �ֹ� ��� - ������
	 */
	// 1. �ֹ� ��Ͽ� �޴� �߰�
	public static void addOrderList() {
		Item item = service.findMenuByMenuName("����Dao");
		service.addOrderList(item);
		System.out.println("�޴� �߰�: " + item.getMenuName() + " " + item.getMenuPrice());
	}

	// 2. �ֹ� ��Ͽ� �޴� ����
	public static void deleteOrderList() {
		Item item = service.findMenuByMenuName("����Dao");
		List<Item> order_list = service.findAllMenus();
		service.deleteOrderList(1, order_list);
		System.out.println("�޴� ���� �Ϸ�, ���� �׸�: " + item.getMenuName() + " " + item.getMenuPrice());

	}
}
