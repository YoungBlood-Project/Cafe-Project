package edu.sp5.jvx330.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sp5.jvx330.cafe.config.ItemConfig;
import edu.sp5.jvx330.cafe.menu.business.CategoryService;
import edu.sp5.jvx330.cafe.menu.business.ItemService;
import edu.sp5.jvx330.cafe.menu.business.impl.CategoryServiceImpl;
import edu.sp5.jvx330.cafe.menu.business.impl.ItemSerivceImpl;
import edu.sp5.jvx330.cafe.menu.dao.ItemRowMapper;
import edu.sp5.jvx330.cafe.menu.domain.Category;
import edu.sp5.jvx330.cafe.menu.domain.Item;

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
		// addItem();
		// setItemName();
		// setItemPrice();
		// deleteItem();

		// 2. �޴� ��ȸ(�̸�, ī�װ�, id, ����)
		// findItemIdByItemName();
		// findItemIdByCategory();
		// findItemByItemName();
		// findAllItems();
		
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
		// �����ϴ� ��� ī�װ�
		Category delete_category = cService.findCategoryByCategoryName("deletedMenu");
		Category coffee_category = cService.findCategoryByCategoryName("Coffee");
		Category tea_category = cService.findCategoryByCategoryName("Tea");
		Category drink_category = cService.findCategoryByCategoryName("Drink");
		Category cake_category = cService.findCategoryByCategoryName("Cake");
		Category meal_category = cService.findCategoryByCategoryName("Meal");
		Category bread_category = cService.findCategoryByCategoryName("Bread");
		Category md_category = cService.findCategoryByCategoryName("MD");
		
		Item deleted_item = new Item(delete_category, "deletedItem", 0);
		service.addItem(deleted_item);

		// item ����
		// 1. Ŀ��
		Item coffee_item1 = new Item(coffee_category, "�Ƹ޸�ī��", 3800);
		coffee_item1.setItemUrl("images/coffee/�Ƹ޸�ī��.jpg");
		service.addItem(coffee_item1);

		Item coffee_item2 = new Item(coffee_category, "�պ�", 4300);
		coffee_item2.setItemUrl("images/coffee/�պ�.jpg");
		service.addItem(coffee_item2);

		Item coffee_item3 = new Item(coffee_category, "�ݵ���", 5000);
		coffee_item3.setItemUrl("images/coffee/�ݵ���.jpg");
		service.addItem(coffee_item3);

		Item coffee_item4 = new Item(coffee_category, "�ݵ����", 5500);
		coffee_item4.setItemUrl("images/coffee/�ݵ����.jpg");
		service.addItem(coffee_item4);

		Item coffee_item5 = new Item(coffee_category, "ī���", 4800);
		coffee_item5.setItemUrl("images/coffee/ī���.jpg");
		service.addItem(coffee_item5);

		Item coffee_item6 = new Item(coffee_category, "��ī���", 5200);
		coffee_item6.setItemUrl("images/coffee/��ī���.jpg");
		service.addItem(coffee_item6);

		Item coffee_item7 = new Item(coffee_category, "�ٴҶ�ī���", 5300);
		coffee_item7.setItemUrl("images/coffee/�ٴҶ�ī���.png");
		service.addItem(coffee_item7);

		Item coffee_item8 = new Item(coffee_category, "����Ͻ�����ī���", 5900);
		coffee_item8.setItemUrl("images/coffee/����Ͻ�����ī���.jpg");
		service.addItem(coffee_item8);

		Item coffee_item9 = new Item(coffee_category, "īǪġ��", 5500);
		coffee_item9.setItemUrl("images/coffee/īǪġ��.jpg");
		service.addItem(coffee_item9);

		Item coffee_item10 = new Item(coffee_category, "ī��ḶŰ�ƶ�", 5900);
		coffee_item10.setItemUrl("images/coffee/ī��ḶŰ�ƶ�.jpg");
		service.addItem(coffee_item10);

		Item coffee_item11 = new Item(coffee_category, "ī���ī", 5300);
		coffee_item11.setItemUrl("images/coffee/ī���ī.jpg");
		service.addItem(coffee_item11);

		Item coffee_item12 = new Item(coffee_category, "ī���ġ��ũ����", 6300);
		coffee_item12.setItemUrl("images/coffee/ī���ġ��ũ����.jpg");
		service.addItem(coffee_item12);

		Item coffee_item13 = new Item(coffee_category, "������ī���", 5800);
		coffee_item13.setItemUrl("images/coffee/������ī���.jpg");
		service.addItem(coffee_item13);

		Item coffee_item14 = new Item(coffee_category, "a-LIST_ĸ��Ŀ��(���׶���)", 30000);
		coffee_item14.setItemUrl("images/coffee/a-LIST_ĸ��Ŀ��(���׶���).jpg");
		service.addItem(coffee_item14);

		Item coffee_item15 = new Item(coffee_category, "a-LIST_�ݵ���RTD����", 15000);
		coffee_item15.setItemUrl("images/coffee/a-LIST_�ݵ���RTD����.jpg");
		service.addItem(coffee_item15);

		Item coffee_item16 = new Item(coffee_category, "a-LIST_��ƽĿ��(��ī����)", 18000);
		coffee_item16.setItemUrl("images/coffee/a-LIST_��ƽĿ��(��ī����).jpg");
		service.addItem(coffee_item16);

		// 2. ��(Tea)
		Item tea_item1 = new Item(tea_category, "1837��Ƽ", 5500);
		tea_item1.setItemUrl("images/tea/1837��Ƽ.jpg");
		service.addItem(tea_item1);

		Item tea_item2 = new Item(tea_category, "�ױ۸����귺�۽�Ʈ", 5500);
		tea_item2.setItemUrl("images/tea/�ױ۸����귺�۽�Ʈ.jpg");
		service.addItem(tea_item2);

		Item tea_item3 = new Item(tea_category, "ī����", 5000);
		tea_item3.setItemUrl("images/tea/ī����.jpg");
		service.addItem(tea_item3);

		Item tea_item4 = new Item(tea_category, "����ġ��׷���", 5300);
		tea_item4.setItemUrl("images/tea/����ġ��׷���.jpg");
		service.addItem(tea_item4);

		Item tea_item5 = new Item(tea_category, "TWG�ó����Ƽ", 5800);
		tea_item5.setItemUrl("images/tea/TWG�ó����Ƽ.jpg");
		service.addItem(tea_item5);

		Item tea_item6 = new Item(tea_category, "������������", 4800);
		tea_item6.setItemUrl("images/tea/������������.jpg");
		service.addItem(tea_item6);

		Item tea_item7 = new Item(tea_category, "�ñ״�ó���", 6500);
		tea_item7.setItemUrl("images/tea/�ñ״�ó���.jpg");
		service.addItem(tea_item7);

		Item tea_item8 = new Item(tea_category, "�׳��͹�ƮƼ", 5300);
		tea_item8.setItemUrl("images/tea/�׳��͹�ƮƼ.jpg");
		service.addItem(tea_item8);

		Item tea_item9 = new Item(tea_category, "��Ϸ���Ƽ", 5600);
		tea_item9.setItemUrl("images/tea/��Ϸ���Ƽ.jpg");
		service.addItem(tea_item9);

		Item tea_item10 = new Item(tea_category, "���ù�ƮƼ", 5400);
		tea_item10.setItemUrl("images/tea/���ù�ƮƼ.jpg");
		service.addItem(tea_item10);

		Item tea_item11 = new Item(tea_category, "���ڷ���Ƽ", 5800);
		tea_item11.setItemUrl("images/tea/���ڷ���Ƽ.jpg");
		service.addItem(tea_item11);

		Item tea_item12 = new Item(tea_category, "�������ڸ�Ƽ", 5800);
		tea_item12.setItemUrl("images/tea/�������ڸ�Ƽ.jpg");
		service.addItem(tea_item12);

		Item tea_item13 = new Item(tea_category, "������Ʈ��Ų�����", 6800);
		tea_item13.setItemUrl("images/tea/������Ʈ��Ų�����.jpg");
		service.addItem(tea_item13);

		Item tea_item14 = new Item(tea_category, "�ξ��ũƼ", 6000);
		tea_item14.setItemUrl("images/tea/�ξ��ũƼ.jpg");
		service.addItem(tea_item14);

		Item tea_item15 = new Item(tea_category, "���̽�����׸�Ƽ��", 6200);
		tea_item15.setItemUrl("images/tea/���̽�����׸�Ƽ��.jpg");
		service.addItem(tea_item15);

		Item tea_item16 = new Item(tea_category, "���̽������ũƼ", 6200);
		tea_item16.setItemUrl("images/tea/���̽������ũƼ.jpg");
		service.addItem(tea_item16);

		// 3. Drink Menu
		Item drink_item1 = new Item(drink_category, "��īĨĿ��������", 6200);
		drink_item1.setItemUrl("images/drink/��īĨĿ��������.jpg");
		service.addItem(drink_item1);

		Item drink_item2 = new Item(drink_category, "���ָ���������", 6500);
		drink_item2.setItemUrl("images/drink/���ָ���������.jpg");
		service.addItem(drink_item2);

		Item drink_item3 = new Item(drink_category, "ī���Ŀ��������", 6500);
		drink_item3.setItemUrl("images/drink/ī���Ŀ��������.jpg");
		service.addItem(drink_item3);

		Item drink_item4 = new Item(drink_category, "���Ʈ������", 6300);
		drink_item4.setItemUrl("images/drink/���Ʈ������.jpg");
		service.addItem(drink_item4);

		Item drink_item5 = new Item(drink_category, "��Ʈ�κ�����ġ������", 6800);
		drink_item5.setItemUrl("images/drink/��Ʈ�κ�����ġ������.jpg");
		service.addItem(drink_item5);

		Item drink_item6 = new Item(drink_category, "����������", 6600);
		drink_item6.setItemUrl("images/drink/����������.jpg");
		service.addItem(drink_item6);

		Item drink_item7 = new Item(drink_category, "������Ʈ��Ų������", 6900);
		drink_item7.setItemUrl("images/drink/������Ʈ��Ų������.jpg");
		service.addItem(drink_item7);

		Item drink_item8 = new Item(drink_category, "����", 6300);
		drink_item8.setItemUrl("images/drink/����.jpg");
		service.addItem(drink_item8);

		Item drink_item9 = new Item(drink_category, "�����ƿ��̵�", 5900);
		drink_item9.setItemUrl("images/drink/�����ƿ��̵�.jpg");
		service.addItem(drink_item9);

		Item drink_item10 = new Item(drink_category, "���θӽ�Ĺû�������̵�", 6100);
		drink_item10.setItemUrl("images/drink/���θӽ�Ĺû�������̵�.jpg");
		service.addItem(drink_item10);

		Item drink_item11 = new Item(drink_category, "��Ʈ����������", 6700);
		drink_item11.setItemUrl("images/drink/��Ʈ����������.jpg");
		service.addItem(drink_item11);

		Item drink_item12 = new Item(drink_category, "ī�����Ŀ��������", 6900);
		drink_item12.setItemUrl("images/drink/ī�����Ŀ��������.jpg");
		service.addItem(drink_item12);

		Item drink_item13 = new Item(drink_category, "������", 6500);
		drink_item13.setItemUrl("images/drink/������.jpg");
		service.addItem(drink_item13);

		Item drink_item14 = new Item(drink_category, "�׸�Ƽ��", 6600);
		drink_item14.setItemUrl("images/drink/�׸�Ƽ��.jpg");
		service.addItem(drink_item14);

		Item drink_item15 = new Item(drink_category, "��Ʈ�κ������ݸ�������", 6800);
		drink_item15.setItemUrl("images/drink/��Ʈ�κ������ݸ�������.jpg");
		service.addItem(drink_item15);

		Item drink_item16 = new Item(drink_category, "����ٳ�����", 6700);
		drink_item16.setItemUrl("images/drink/����ٳ�����.jpg");
		service.addItem(drink_item16);

		// 4. Cake menu

		Item cake_item1 = new Item(cake_category, "������ũ��ũ��", 35000);
		cake_item1.setItemUrl("images/cake/������ũ��ũ��.jpg");
		service.addItem(cake_item1);

		Item cake_item2 = new Item(cake_category, "�����ũ��1ȣ", 31000);
		cake_item2.setItemUrl("images/cake/�����ũ��1ȣ.jpg");
		service.addItem(cake_item2);

		Item cake_item3 = new Item(cake_category, "���座��", 32000);
		cake_item3.setItemUrl("images/cake/���座��.jpg");
		service.addItem(cake_item3);

		Item cake_item4 = new Item(cake_category, "����ī����Ƽ��̼�", 33500);
		cake_item4.setItemUrl("images/cake/����ī����Ƽ��̼�.jpg");
		service.addItem(cake_item4);

		Item cake_item5 = new Item(cake_category, "�̶�Ŭ ������Ƽ", 34500);
		cake_item5.setItemUrl("images/cake/�̶�Ŭ������Ƽ.jpg");
		service.addItem(cake_item5);

		Item cake_item6 = new Item(cake_category, "�̶�Ŭ ���ݸ�����", 32500);
		cake_item6.setItemUrl("images/cake/�̶�Ŭ���ݸ�����.jpg");
		service.addItem(cake_item6);

		Item cake_item7 = new Item(cake_category, "�ͽ��庣�����ݸ���ũ��", 34500);
		cake_item7.setItemUrl("images/cake/�ͽ��庣�����ݸ���ũ��.jpg");
		service.addItem(cake_item7);

		Item cake_item8 = new Item(cake_category, "��Ʈ�κ������ݸ���ũ��", 36000);
		cake_item8.setItemUrl("images/cake/��Ʈ�κ������ݸ���ũ��.jpg");
		service.addItem(cake_item8);

		Item cake_item9 = new Item(cake_category, "���ͺ��̹�����ũ", 33000);
		cake_item9.setItemUrl("images/cake/���ͺ��̹�����ũ.jpg");
		service.addItem(cake_item9);

		Item cake_item10 = new Item(cake_category, "����ĳ��", 38000);
		cake_item10.setItemUrl("images/cake/����ĳ��.jpg");
		service.addItem(cake_item10);

		Item cake_item11 = new Item(cake_category, "Ŭ���İ�����ݶ�", 36500);
		cake_item11.setItemUrl("images/cake/Ŭ���İ�����ݶ�.jpg");
		service.addItem(cake_item11);

		Item cake_item12 = new Item(cake_category, "���潺��캣��", 37000);
		cake_item12.setItemUrl("images/cake/���潺��캣��.jpg");
		service.addItem(cake_item12);

		Item cake_item13 = new Item(cake_category, "Ʈ���ú�����ũ��", 33000);
		cake_item13.setItemUrl("images/cake/Ʈ���ú�����ũ��.jpg");
		service.addItem(cake_item13);

		Item cake_item14 = new Item(cake_category, "��Ƽ�ѵ��ⷹ��ġ��", 33000);
		cake_item14.setItemUrl("images/cake/��Ƽ�ѵ��ⷹ��ġ��.jpg");
		service.addItem(cake_item14);

		Item cake_item15 = new Item(cake_category, "��Ƽ�Ѿ��̽��ڽ�", 35000);
		cake_item15.setItemUrl("images/cake/��Ƽ�Ѿ��̽��ڽ�.jpg");
		service.addItem(cake_item15);

		Item cake_item16 = new Item(cake_category, "ȭ��Ʈ�ٴҶ�󹫽�", 34500);
		cake_item16.setItemUrl("images/cake/ȭ��Ʈ�ٴҶ�󹫽�.jpg");
		service.addItem(cake_item16);

		// 5. Meal Menu

		Item meal_item1 = new Item(meal_category, "��ī����ġŲ������", 8000);
		meal_item1.setItemUrl("images/meal/��ī����ġŲ������.jpg");
		service.addItem(meal_item1);

		Item meal_item2 = new Item(meal_category, "�׸���ġŲ������", 8500);
		meal_item2.setItemUrl("images/meal/�׸���ġŲ������.jpg");
		service.addItem(meal_item2);

		Item meal_item3 = new Item(meal_category, "��¥������", 7500);
		meal_item3.setItemUrl("images/meal/��¥������.jpg");
		service.addItem(meal_item3);

		Item meal_item4 = new Item(meal_category, "�������߻�����", 8000);
		meal_item4.setItemUrl("images/meal/�������߻�����.jpg");
		service.addItem(meal_item4);

		Item meal_item5 = new Item(meal_category, "�������߻�����", 7500);
		meal_item5.setItemUrl("images/meal/�������߻�����.jpg");
		service.addItem(meal_item5);

		Item meal_item6 = new Item(meal_category, "ī������������", 8100);
		meal_item6.setItemUrl("images/meal/ī������������.jpg");
		service.addItem(meal_item6);

		Item meal_item7 = new Item(meal_category, "ũ������ġŲ������ġ", 6500);
		meal_item7.setItemUrl("images/meal/ũ������ġŲ������ġ.jpg");
		service.addItem(meal_item7);

		Item meal_item8 = new Item(meal_category, "��ũ�����׻�����ġ", 4500);
		meal_item8.setItemUrl("images/meal/��ũ�����׻�����ġ.jpg");
		service.addItem(meal_item8);

		Item meal_item9 = new Item(meal_category, "�߽�ĭ�Ĵϴ�", 5500);
		meal_item9.setItemUrl("images/meal/�߽�ĭ�Ĵϴ�.jpg");
		service.addItem(meal_item9);

		Item meal_item10 = new Item(meal_category, "�ٺ�ťġŲ�Ĵϴ�", 6500);
		meal_item10.setItemUrl("images/meal/�ٺ�ťġŲ�Ĵϴ�.jpg");
		service.addItem(meal_item10);

		Item meal_item11 = new Item(meal_category, "�ø���ġŲ�Ĵϴ�", 5500);
		meal_item11.setItemUrl("images/meal/�ø���ġŲ�Ĵϴ�.jpg");
		service.addItem(meal_item11);

		Item meal_item12 = new Item(meal_category, "���������佺Ʈ", 5900);
		meal_item12.setItemUrl("images/meal/���������佺Ʈ.jpg");
		service.addItem(meal_item12);

		Item meal_item13 = new Item(meal_category, "�����̽�ġŲ�����左", 3500);
		meal_item13.setItemUrl("images/meal/�����̽�ġŲ�����左.jpg");
		service.addItem(meal_item13);

		Item meal_item14 = new Item(meal_category, "�Ĺ�����ü���ȴϹ�Ʈ�����左", 3800);
		meal_item14.setItemUrl("images/meal/�Ĺ�����ü���ȴϹ�Ʈ�����左.jpg");
		service.addItem(meal_item14);

		Item meal_item15 = new Item(meal_category, "���׺������긮����", 6600);
		meal_item15.setItemUrl("images/meal/���׺������긮����.jpg");
		service.addItem(meal_item15);

		Item meal_item16 = new Item(meal_category, "��ȣ��ũ��ġ�������ġ", 6900);
		meal_item16.setItemUrl("images/meal/��ȣ��ũ��ġ�������ġ.jpg");
		service.addItem(meal_item16);

		// 6. Bread Menu

		Item bread_item1 = new Item(bread_category, "�긮������ũ��", 3000);
		bread_item1.setItemUrl("images/bread/�긮������ũ��.jpg");
		service.addItem(bread_item1);

		Item bread_item2 = new Item(bread_category, "�������ݶ�", 2000);
		bread_item2.setItemUrl("images/bread/�������ݶ�.jpg");
		service.addItem(bread_item2);

		Item bread_item3 = new Item(bread_category, "����Ŀ���͵�", 2000);
		bread_item3.setItemUrl("images/bread/����Ŀ���͵�.jpg");
		service.addItem(bread_item3);

		Item bread_item4 = new Item(bread_category, "�ҽ������̽�Ʈ��", 2500);
		bread_item4.setItemUrl("images/bread/�ҽ������̽�Ʈ��.jpg");
		service.addItem(bread_item4);

		Item bread_item5 = new Item(bread_category, "ũ��ƻ�", 3000);
		bread_item5.setItemUrl("images/bread/ũ��ƻ�.jpg");
		service.addItem(bread_item5);

		Item bread_item6 = new Item(bread_category, "�ĸ���ũ��ƻ�", 3500);
		bread_item6.setItemUrl("images/bread/�ĸ���ũ��ƻ�.jpg");
		service.addItem(bread_item6);

		Item bread_item7 = new Item(bread_category, "�丶�亣�������ֺ극��", 4000);
		bread_item7.setItemUrl("images/bread/�丶�亣�������ֺ극��.jpg");
		service.addItem(bread_item7);

		Item bread_item8 = new Item(bread_category, "6ġ����ֺ극��", 4500);
		bread_item8.setItemUrl("images/bread/6ġ����ֺ극��.jpg");
		service.addItem(bread_item8);

		Item bread_item9 = new Item(bread_category, "����ũ��ġ��ũ�������̽�Ʈ��", 4300);
		bread_item9.setItemUrl("images/bread/����ũ��ġ��ũ�������̽�Ʈ��.jpg");
		service.addItem(bread_item9);

		Item bread_item10 = new Item(bread_category, "���", 2000);
		bread_item10.setItemUrl("images/bread/���.jpg");
		service.addItem(bread_item10);

		Item bread_item11 = new Item(bread_category, "���̽���Ʈ�������鷻", 2000);
		bread_item11.setItemUrl("images/bread/���̽���Ʈ�������鷻.jpg");
		service.addItem(bread_item11);

		Item bread_item12 = new Item(bread_category, "TWG��ũ���Ŀ��", 3800);
		bread_item12.setItemUrl("images/bread/TWG��ũ���Ŀ��.jpg");
		service.addItem(bread_item12);

		Item bread_item13 = new Item(bread_category, "�÷��κ��̱�", 3500);
		bread_item13.setItemUrl("images/bread/�÷��κ��̱�.jpg");
		service.addItem(bread_item13);

		Item bread_item14 = new Item(bread_category, "ȣ�κ��̱�", 4500);
		bread_item14.setItemUrl("images/bread/ȣ�κ��̱�.jpg");
		service.addItem(bread_item14);

		Item bread_item15 = new Item(bread_category, "���׺��������̽�Ʈ��", 6000);
		bread_item15.setItemUrl("images/bread/���׺��������̽�Ʈ��.jpg");
		service.addItem(bread_item15);

		Item bread_item16 = new Item(bread_category, "���������ݶ��Ŀ��", 3000);
		bread_item16.setItemUrl("images/bread/���������ݶ��Ŀ��.jpg");
		service.addItem(bread_item16);

		// 7. Md Menu

		Item md_item1 = new Item(md_category, "���� ������ ���ٸӱ�[�׷���]", 25000);
		md_item1.setItemUrl("images/md/���溣�������ٸӱ�_�׷���.png");
		service.addItem(md_item1);

		Item md_item2 = new Item(md_category, "���� ������ ���ٸӱ�[ȭ��Ʈ]", 25000);
		md_item2.setItemUrl("images/md/���溣�������ٸӱ�_ȭ��Ʈ.jpg");
		service.addItem(md_item2);

		Item md_item3 = new Item(md_category, "���� ������ �����Һ�[�׷���]", 38000);
		md_item3.setItemUrl("images/md/���溣���������Һ�_�׷���.png");
		service.addItem(md_item3);

		Item md_item4 = new Item(md_category, "���溣���������Һ�[ȭ��Ʈ]", 38000);
		md_item4.setItemUrl("images/md/���溣���������Һ�_ȭ��Ʈ.jpg");
		service.addItem(md_item4);

		Item md_item5 = new Item(md_category, "���� �׷��� �ոӱ�", 28000);
		md_item5.setItemUrl("images/md/����׷��̷ոӱ�.jpg");
		service.addItem(md_item5);

		Item md_item6 = new Item(md_category, "���� ȭ��Ʈ �ոӱ�", 2800);
		md_item6.setItemUrl("images/md/����ȭ��Ʈ�ոӱ�.jpg");
		service.addItem(md_item6);

		Item md_item7 = new Item(md_category, "���� �׷��� �ӱ�", 23000);
		md_item7.setItemUrl("images/md/����׷��̸ӱ�.jpg");
		service.addItem(md_item7);

		Item md_item8 = new Item(md_category, "���� ȭ��Ʈ �ӱ�", 23000);
		md_item8.setItemUrl("images/md/����ȭ��Ʈ�ӱ�.jpg");
		service.addItem(md_item8);

		Item md_item9 = new Item(md_category, "�̶�Ŭ ����Ʈ�� ��Ʈ", 39000);
		md_item9.setItemUrl("images/md/�̶�Ŭ����Ʈ����Ʈ.jpg");
		service.addItem(md_item9);

		Item md_item10 = new Item(md_category, "�̶�Ŭ ������", 35000);
		md_item10.setItemUrl("images/md/�̶�Ŭ������.jpg");
		service.addItem(md_item10);

		Item md_item11 = new Item(md_category, "�̶�Ŭ ��Ʈ�ο� �Һ�", 38500);
		md_item11.setItemUrl("images/md/�̶�Ŭ��Ʈ�ο��Һ�.jpg");
		service.addItem(md_item11);

		Item md_item12 = new Item(md_category, "�̶�Ŭ MAX �����Һ�", 40000);
		md_item12.setItemUrl("images/md/�̶�ŬMAX�����Һ�.jpg");
		service.addItem(md_item12);

		Item md_item13 = new Item(md_category, "����X�̸� ķ����[�׸�]", 35000);
		md_item13.setItemUrl("images/md/����X�̸�ķ����_�׸�.jpg");
		service.addItem(md_item13);

		Item md_item14 = new Item(md_category, "����X�̸� ķ����[���ο�]", 35000);
		md_item14.setItemUrl("images/md/����X�̸�ķ����_���ο�.jpg");
		service.addItem(md_item14);

		Item md_item15 = new Item(md_category, "����X�̸� �Һ�[�׸�]", 50000);
		md_item15.setItemUrl("images/md/����X�̸��Һ�_�׸�.jpg");
		service.addItem(md_item15);

		Item md_item16 = new Item(md_category, "����X�̸� �Һ�[���ο�]", 50000);
		md_item16.setItemUrl("images/md/����X�̸��Һ�_���ο�.jpg");
		service.addItem(md_item16);
	      
		System.out.println("ItemServiceTest: ���� �Ϸ�.");

		// ������ ���� test��
		// Category category = cService.findCategoryByCategoryName("deletedMenu");
		// Category category = cService.findCategoryByCategoryName("��Dao");
		// Item item = new Item(category, "delete", 0); //deletedMenu ī�װ��� �ֱ�
		// Item item = new Item(category, "�ٴҶ�Dao", 5000);
		// item.setItemUrl("�ּ�");
		// Item item = new Item(category, "����Dao", 6000);
		// System.out.println(menu.getCustomer().getCid());
		// service.addItem(item);
		// System.out.println("ItemServiceTest : ���� �Ϸ�");
	}

	// 1-2-1. �޴� �̸� ����
	public static void setItemName() {
		Item item = service.findItemByItemName("�ٴҶ�Dao");
		System.out.println(item);
		service.setItemName(item, "����Dao");
		System.out.println("ItemServiceTest : �̸� ���� �Ϸ�");
	}

	// 1-2-2. �޴� ���� ����
	public static void setItemPrice() {
		Item item = service.findItemByItemName("����Dao");
		service.setItemPrice(item, 4000);
		System.out.println("ItemServiceTest : ���� ���� �Ϸ�");
	}

	// 1-3. �޴�����
	public static void deleteItem() {
		Item item = service.findItemByItemName("����Dao");
		System.out.println("deleteItem :" + item);
		service.deleteItem(item);
		System.out.println("ItemServiceTest : ���� �Ϸ�");
	}

	/**
	 * 2. �޴� ��ȸ
	 */
	// 2-1. �޴� id ��ȸ(�޴� �̸����� id ��ȸ)
	public static void findItemIdByItemName() {
		Item item = service.findItemByItemName("����Dao");
		System.out.println("ItemServiceTest : id : " + service.findItemIdByItemName(item.getItemName()));
	}

	// 2-2. ī�װ��� �޴� id ��ȸ
	public static void findItemIdByCategory() {
		Category category = cService.findCategoryByCategoryName("��Dao");
		List<Item> item_list = service.findItemsByCategory(category);
		for (Item itme : item_list) {
			System.out.println("category's itemId: " + itme);
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
	
	//2-5. �޴�������id�� �޴������� ��ȸ
	public static void findItemByItemId() {
		Item item = service.findItemByItemId(1l);
		System.out.println(item.getItemName());
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
