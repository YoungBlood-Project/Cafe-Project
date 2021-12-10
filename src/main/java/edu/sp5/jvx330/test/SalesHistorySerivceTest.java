package edu.sp5.jvx330.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.category.item.business.ItemService;
import edu.sp5.jvx330.cafe.category.item.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.category.item.domain.Item;
import edu.sp5.jvx330.cafe.category.item.salesHistory.business.SalesHistoryService;
import edu.sp5.jvx330.cafe.category.item.salesHistory.business.impl.SalesHistoryServiceImpl;
import edu.sp5.jvx330.cafe.category.item.salesHistory.config.SalesHistoryConfig;
import edu.sp5.jvx330.cafe.category.item.salesHistory.domain.SalesHistory;

public class SalesHistorySerivceTest {
	private static SalesHistoryService sh_service;
	private static ItemService item_service;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SalesHistoryConfig.class);
		
		sh_service = context.getBean("salesHistoryServiceImpl", SalesHistoryServiceImpl.class);
		item_service = context.getBean("itemServiceImpl", ItemSerivceImpl.class);
		
		/**
		 * �׽�Ʈ - ������.
		 */
		// 1. �Ǹ� ���� �߰�
		//addSalesHistory();
		
		// 2. �Ǹ� ���� ��ȸ
		//findAllSalesHistory();
		//findSalesHistoryByOrderDate();
		//findSalesHistoryByMenu();
		//findSalesHistoryByOrderNum();
		
		// 3. ȯ��
		//deleteSalesHistoryBySHid();
		deleteAllSalesHistories();
		
		// 4. ��¥�� �Ǹ� ���� ����
		//countSalesHistoryByOrderDate();
	
		context.close();
	}
	/**
	 * 1. �Ǹų��� �߰�
	 */
	public static void addSalesHistory() {
		Item item = item_service.findItemByItemName("����Dao");
		SalesHistory salesHistory =
				new SalesHistory(item, 3, item.getItemPrice()*3);
		salesHistory.setOrderNum(202112070001l);
				//new SalesHistory(menu, 1, menu.getMenuPrice()*1);
		sh_service.addSalesHistory(item, salesHistory);
		System.out.println("SalesHistorySerivceTest : �Ǹų��� ���� �Ϸ�");
	}
	
	/**
	 * 2. �Ǹų��� ��ȸ
	 */
	//2-1. �Ǹų��� ��ü ��ȸ
	public static void findAllSalesHistory() {
		List<SalesHistory> sh_list = sh_service.findAllSalesHistory();
		for(SalesHistory sh : sh_list) {
			System.out.println(sh);
		}
	}
	//2-2. �ش� ��¥�� �Ǹų��� ��ȸ
	public static void findSalesHistoryByOrderDate() {
		List<SalesHistory> sh_list = sh_service.findSalesHistoryByOrderDate(new Date());
		for(SalesHistory sh : sh_list) {
			System.out.println(sh);
		}
	}
	//2-3. �ش� �޴��� �Ǹų��� ��ȸ(menuId ���)
	public static void findSalesHistoryByMenu() {
		Item item = item_service.findItemByItemName("����Dao");
		List<SalesHistory> sh_list = sh_service.findSalesHistoryByMenu(item);
		for(SalesHistory sh : sh_list) {
			System.out.println(sh);
		}
	}
	
	/**
	 * �߰� - ����
	 * 2-4. �ش� �ֹ� ��ȣ�� �Ǹ� ���� ��ȸ, 3. �Ǹ� ���� ���� �κ�
	 */
	
	//2-4. �ش� �ֹ� ��ȣ�� �Ǹ� ���� ��ȸ
	public static void findSalesHistoryByOrderNum() {
		List<SalesHistory> sh_list = sh_service.findSalesHistoryByOrderNum(202112070001l);
		for (SalesHistory sh : sh_list) {
			System.out.println(sh);
		}
	}
	
	/**
	 * 3. �Ǹ� ���� ����
	 */
	//3-1. ȯ��
	public static void deleteSalesHistoryBySHid() {
		Item item = item_service.findItemByItemName("����Dao");
		List<SalesHistory> sh_list = sh_service.findSalesHistoryByMenu(item);
		System.out.println("�Ǹ� ���� ���� �Ϸ�: " + item.getItemName() + "�� ù��° �Ǹų���");
		sh_service.deleteSalesHistoryBySHid(sh_list.get(0));
	}
	
	//3-2. �ش� �޴��� �Ǹų��� ��ü ����
	public static void deleteAllSalesHistories() {
		Item item = item_service.findItemByItemName("����Dao");
		sh_service.deleteAllSalesHistories(item);
		System.out.println("�Ǹ� ���� ��ü ���� �Ϸ�");
	}
	
	/**
	 * 4. ��¥�� �Ǹų��� ����
	 */
	public static void countSalesHistoryByOrderDate() {
		System.out.println(sh_service.countSalesHistoryByOrderDate(new Date()));
	}
	
}

