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
		 * �׽�Ʈ - ���ʿ�.
		 */
		// 1. �޴� �߰�/����/����
		addItem();
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
	public static void addItem() {
		Category category = new Category("deletedMenu");
		cService.findCategoryByCategoryName(null);
		Item item = new Item(category, "delete", 0);
		// Menu menu = new Menu("��Dao", "�ٴҶ�Dao", 5000);
		// Menu menu = new Menu("��Dao", "����Dao", 6000);
		// System.out.println(menu.getCustomer().getCid());
		service.addItem(item);
		System.out.println("MenuServiceTest : ���� �Ϸ�");
	}

	// 1-2-1. �޴� �̸� ����
	public static void setMenuName() {
		Item item = service.findItemByItemName("�ٴҶ�Dao");
		service.setItemName(item, "����Dao");
		System.out.println("MenuServiceTest : �̸� ���� �Ϸ�");
	}

	// 1-2-2. �޴� ���� ����
	public static void setMenuSales() {
		Item item = service.findItemByItemName("����Dao");
		service.setItemPrice(item, 4000);
		System.out.println("MenuServiceTest : ���� ���� �Ϸ�");
	}

	// 1-3. �޴�����
	public static void deleteItem() {
		Item item = service.findItemByItemName("����Dao");
		// System.out.println("testMService :" + menu);
		service.deleteItem(item);
		System.out.println("MenuServiceTest : ���� �Ϸ�");
	}

	/**
	 * 2. �޴� ��ȸ
	 */
	// 2-1. �޴� id ��ȸ(�޴� �̸����� id ��ȸ)
	public static void findItemIdByItemName() {
		Item item = service.findItemByItemName("����Dao");
		System.out.println("MenuServiceTest : id : " + service.findItemIdByItemName(item.getItemName()));
	}

	// 2-2. ī�װ��� �޴� id ��ȸ
	public static void findItemIdByCategory() {
		Category category = new Category("��Dao");
		List<Long> mid_list = service.findItemIdByCategory(category);
		for (Long mid : mid_list) {
			System.out.println("category's mid: " + mid);
		}
	}

	// 2-3. ������ �̸����� �޴� ��ȸ
	public static void findItemByItemName() {
		System.out.println(service.findItemByItemName("����Dao"));
	}

	// 2-4. ������ ��ü ��ȸ
	public static void findAllItems() {
		List<Item> mid_list = service.findAllItems();
		for (Item item : mid_list) {
			System.out.println(item);
		}
	}

	/**
	 * 3. �ֹ� ��� - ������
	 */
	// 1. �ֹ� ��Ͽ� �޴� �߰�
	public static void addOrderList() {
		Item item = service.findItemByItemName("����Dao");
		service.addOrderList(item);
		System.out.println("�޴� �߰�: " + item.getItemName() + " " + item.getItemPrice());
	}

	// 2. �ֹ� ��Ͽ� �޴� ����
	public static void deleteOrderList() {
		Item item = service.findItemByItemName("����Dao");
		List<Item> order_list = service.findAllItems();
		service.deleteOrderList(1, order_list);
		System.out.println("�޴� ���� �Ϸ�, ���� �׸�: " + item.getItemName() + " " + item.getItemPrice());

	}
}
