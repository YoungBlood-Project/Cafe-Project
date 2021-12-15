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
		 * 테스트 - 이초원.
		 */
		// 1. 메뉴 추가/수정/삭제
		//addItem();
		// setItemName();
		// setItemPrice();
		// deleteItem();

		// 2. 메뉴 조회(이름, 카테고리, id, 전부)
		// findItemIdByItemName();
		// findItemIdByCategory();
		// findItemByItemName();
		// findAllItems();
		findItemByItemId();

		// 3. 주문 목록 추가/삭제
		// addOrderList();
		// deleteOrderList();

		context.close();
	}

	/**
	 * 1. 관리메뉴
	 */
	// 1-1. 메뉴 추가 테스트
	public static void addItem() {
		// 존재하는 모든 카테고리
		//Category delete_category = cService.findCategoryByCategoryName("deletedMenu");
		Category coffee_category = cService.findCategoryByCategoryName("Coffee");
		Category tea_category = cService.findCategoryByCategoryName("Tea");
		Category drink_category = cService.findCategoryByCategoryName("Drink");
		Category cake_category = cService.findCategoryByCategoryName("Cake");
		Category meal_category = cService.findCategoryByCategoryName("Meal");
		Category bread_category = cService.findCategoryByCategoryName("Bread");
		Category md_category = cService.findCategoryByCategoryName("MD");

		// item 생성
		// 1. 커피
		Item coffee_item1 = new Item(coffee_category, "아메리카노", 3800);
		coffee_item1.setItemUrl("images/coffee/아메리카노.jpg");
		service.addItem(coffee_item1);

		Item coffee_item2 = new Item(coffee_category, "롱블랙", 4300);
		coffee_item2.setItemUrl("images/coffee/롱블랙.jpg");
		service.addItem(coffee_item2);

		Item coffee_item3 = new Item(coffee_category, "콜드브루", 5000);
		coffee_item3.setItemUrl("images/coffee/콜드브루.jpg");
		service.addItem(coffee_item3);

		Item coffee_item4 = new Item(coffee_category, "콜드브루라떼", 5500);
		coffee_item4.setItemUrl("images/coffee/콜드브루라떼.jpg");
		service.addItem(coffee_item4);

		Item coffee_item5 = new Item(coffee_category, "카페라떼", 4800);
		coffee_item5.setItemUrl("images/coffee/카페라떼.jpg");
		service.addItem(coffee_item5);

		Item coffee_item6 = new Item(coffee_category, "숏카페라떼", 5200);
		coffee_item6.setItemUrl("images/coffee/숏카페라떼.jpg");
		service.addItem(coffee_item6);

		Item coffee_item7 = new Item(coffee_category, "바닐라카페라떼", 5300);
		coffee_item7.setItemUrl("images/coffee/바닐라카페라떼.png");
		service.addItem(coffee_item7);

		Item coffee_item8 = new Item(coffee_category, "스페니쉬연유카페라떼", 5900);
		coffee_item8.setItemUrl("images/coffee/스페니쉬연유카페라떼.jpg");
		service.addItem(coffee_item8);

		Item coffee_item9 = new Item(coffee_category, "카푸치노", 5500);
		coffee_item9.setItemUrl("images/coffee/카푸치노.jpg");
		service.addItem(coffee_item9);

		Item coffee_item10 = new Item(coffee_category, "카라멜마키아또", 5900);
		coffee_item10.setItemUrl("images/coffee/카라멜마키아또.jpg");
		service.addItem(coffee_item10);

		Item coffee_item11 = new Item(coffee_category, "카페모카", 5300);
		coffee_item11.setItemUrl("images/coffee/카페모카.jpg");
		service.addItem(coffee_item11);

		Item coffee_item12 = new Item(coffee_category, "카라멜치즈크림라떼", 6300);
		coffee_item12.setItemUrl("images/coffee/카라멜치즈크림라떼.jpg");
		service.addItem(coffee_item12);

		Item coffee_item13 = new Item(coffee_category, "흑임자카페라떼", 5800);
		coffee_item13.setItemUrl("images/coffee/흑임자카페라떼.jpg");
		service.addItem(coffee_item13);

		Item coffee_item14 = new Item(coffee_category, "a-LIST_캡슐커피(블랙그라운드)", 30000);
		coffee_item14.setItemUrl("images/coffee/a-LIST_캡슐커피(블랙그라운드).jpg");
		service.addItem(coffee_item14);

		Item coffee_item15 = new Item(coffee_category, "a-LIST_콜드브루RTD원액", 15000);
		coffee_item15.setItemUrl("images/coffee/a-LIST_콜드브루RTD원액.jpg");
		service.addItem(coffee_item15);

		Item coffee_item16 = new Item(coffee_category, "a-LIST_스틱커피(디카페인)", 18000);
		coffee_item16.setItemUrl("images/coffee/a-LIST_스틱커피(디카페인).jpg");
		service.addItem(coffee_item16);

		// 2. 차(Tea)
		Item tea_item1 = new Item(tea_category, "1837블랙티", 5500);
		tea_item1.setItemUrl("images/tea/1837블랙티.jpg");
		service.addItem(tea_item1);

		Item tea_item2 = new Item(tea_category, "잉글리쉬브렉퍼스트", 5500);
		tea_item2.setItemUrl("images/tea/잉글리쉬브렉퍼스트.jpg");
		service.addItem(tea_item2);

		Item tea_item3 = new Item(tea_category, "카모마일", 5000);
		tea_item3.setItemUrl("images/tea/카모마일.jpg");
		service.addItem(tea_item3);

		Item tea_item4 = new Item(tea_category, "프렌치얼그레이", 5300);
		tea_item4.setItemUrl("images/tea/프렌치얼그레이.jpg");
		service.addItem(tea_item4);

		Item tea_item5 = new Item(tea_category, "TWG시나몬블랙티", 5800);
		tea_item5.setItemUrl("images/tea/TWG시나몬블랙티.jpg");
		service.addItem(tea_item5);

		Item tea_item6 = new Item(tea_category, "제주유기농녹차", 4800);
		tea_item6.setItemUrl("images/tea/제주유기농녹차.jpg");
		service.addItem(tea_item6);

		Item tea_item7 = new Item(tea_category, "시그니처뱅쇼", 6500);
		tea_item7.setItemUrl("images/tea/시그니처뱅쇼.jpg");
		service.addItem(tea_item7);

		Item tea_item8 = new Item(tea_category, "그나와민트티", 5300);
		tea_item8.setItemUrl("images/tea/그나와민트티.jpg");
		service.addItem(tea_item8);

		Item tea_item9 = new Item(tea_category, "허니레몬티", 5600);
		tea_item9.setItemUrl("images/tea/허니레몬티.jpg");
		service.addItem(tea_item9);

		Item tea_item10 = new Item(tea_category, "애플민트티", 5400);
		tea_item10.setItemUrl("images/tea/애플민트티.jpg");
		service.addItem(tea_item10);

		Item tea_item11 = new Item(tea_category, "유자레몬티", 5800);
		tea_item11.setItemUrl("images/tea/유자레몬티.jpg");
		service.addItem(tea_item11);

		Item tea_item12 = new Item(tea_category, "오렌지자몽티", 5800);
		tea_item12.setItemUrl("images/tea/오렌지자몽티.jpg");
		service.addItem(tea_item12);

		Item tea_item13 = new Item(tea_category, "딜라이트펌킨슈페너", 6800);
		tea_item13.setItemUrl("images/tea/딜라이트펌킨슈페너.jpg");
		service.addItem(tea_item13);

		Item tea_item14 = new Item(tea_category, "로얄밀크티", 6000);
		tea_item14.setItemUrl("images/tea/로얄밀크티.jpg");
		service.addItem(tea_item14);

		Item tea_item15 = new Item(tea_category, "아이스버블그린티라떼", 6200);
		tea_item15.setItemUrl("images/tea/아이스버블그린티라떼.jpg");
		service.addItem(tea_item15);

		Item tea_item16 = new Item(tea_category, "아이스버블밀크티", 6200);
		tea_item16.setItemUrl("images/tea/아이스버블밀크티.jpg");
		service.addItem(tea_item16);

		// 3. Drink Menu
		Item drink_item1 = new Item(drink_category, "모카칩커피프라페", 6200);
		drink_item1.setItemUrl("images/drink/모카칩커피프라페.jpg");
		service.addItem(drink_item1);

		Item drink_item2 = new Item(drink_category, "제주말차프라페", 6500);
		drink_item2.setItemUrl("images/drink/제주말차프라페.jpg");
		service.addItem(drink_item2);

		Item drink_item3 = new Item(drink_category, "카라멜커피프라페", 6500);
		drink_item3.setItemUrl("images/drink/카라멜커피프라페.jpg");
		service.addItem(drink_item3);

		Item drink_item4 = new Item(drink_category, "요거트프라페", 6300);
		drink_item4.setItemUrl("images/drink/요거트프라페.jpg");
		service.addItem(drink_item4);

		Item drink_item5 = new Item(drink_category, "스트로베리피치프라페", 6800);
		drink_item5.setItemUrl("images/drink/스트로베리피치프라페.jpg");
		service.addItem(drink_item5);

		Item drink_item6 = new Item(drink_category, "망고프라페", 6600);
		drink_item6.setItemUrl("images/drink/망고프라페.jpg");
		service.addItem(drink_item6);

		Item drink_item7 = new Item(drink_category, "딜라이트펌킨프라페", 6900);
		drink_item7.setItemUrl("images/drink/딜라이트펌킨프라페.jpg");
		service.addItem(drink_item7);

		Item drink_item8 = new Item(drink_category, "쑥라떼", 6300);
		drink_item8.setItemUrl("images/drink/쑥라떼.jpg");
		service.addItem(drink_item8);

		Item drink_item9 = new Item(drink_category, "복숭아에이드", 5900);
		drink_item9.setItemUrl("images/drink/복숭아에이드.jpg");
		service.addItem(drink_item9);

		Item drink_item10 = new Item(drink_category, "샤인머스캣청포도에이드", 6100);
		drink_item10.setItemUrl("images/drink/샤인머스캣청포도에이드.jpg");
		service.addItem(drink_item10);

		Item drink_item11 = new Item(drink_category, "민트초코프라페", 6700);
		drink_item11.setItemUrl("images/drink/민트초코프라페.jpg");
		service.addItem(drink_item11);

		Item drink_item12 = new Item(drink_category, "카라멜팝커피프라페", 6900);
		drink_item12.setItemUrl("images/drink/카라멜팝커피프라페.jpg");
		service.addItem(drink_item12);

		Item drink_item13 = new Item(drink_category, "고구마라떼", 6500);
		drink_item13.setItemUrl("images/drink/고구마라떼.jpg");
		service.addItem(drink_item13);

		Item drink_item14 = new Item(drink_category, "그린티라떼", 6600);
		drink_item14.setItemUrl("images/drink/그린티라떼.jpg");
		service.addItem(drink_item14);

		Item drink_item15 = new Item(drink_category, "스트로베리초콜릿프라페", 6800);
		drink_item15.setItemUrl("images/drink/스트로베리초콜릿프라페.jpg");
		service.addItem(drink_item15);

		Item drink_item16 = new Item(drink_category, "망고바나나라떼", 6700);
		drink_item16.setItemUrl("images/drink/망고바나나라떼.jpg");
		service.addItem(drink_item16);

		// 4. Cake menu

		Item cake_item1 = new Item(cake_category, "고구마밀크생크림", 35000);
		cake_item1.setItemUrl("images/cake/고구마밀크생크림.jpg");
		service.addItem(cake_item1);

		Item cake_item2 = new Item(cake_category, "딸기생크림1호", 31000);
		cake_item2.setItemUrl("images/cake/딸기생크림1호.jpg");
		service.addItem(cake_item2);

		Item cake_item3 = new Item(cake_category, "레드벨벳", 32000);
		cake_item3.setItemUrl("images/cake/레드벨벳.jpg");
		service.addItem(cake_item3);

		Item cake_item4 = new Item(cake_category, "마스카포네티라미수", 33500);
		cake_item4.setItemUrl("images/cake/마스카포네티라미수.jpg");
		service.addItem(cake_item4);

		Item cake_item5 = new Item(cake_category, "미라클 윈터파티", 34500);
		cake_item5.setItemUrl("images/cake/미라클윈터파티.jpg");
		service.addItem(cake_item5);

		Item cake_item6 = new Item(cake_category, "미라클 초콜릿무스", 32500);
		cake_item6.setItemUrl("images/cake/미라클초콜릿무스.jpg");
		service.addItem(cake_item6);

		Item cake_item7 = new Item(cake_category, "믹스드베리초콜릿생크림", 34500);
		cake_item7.setItemUrl("images/cake/믹스드베리초콜릿생크림.jpg");
		service.addItem(cake_item7);

		Item cake_item8 = new Item(cake_category, "스트로베리초콜릿생크림", 36000);
		cake_item8.setItemUrl("images/cake/스트로베리초콜릿생크림.jpg");
		service.addItem(cake_item8);

		Item cake_item9 = new Item(cake_category, "윈터보늬밤케이크", 33000);
		cake_item9.setItemUrl("images/cake/윈터보늬밤케이크.jpg");
		service.addItem(cake_item9);

		Item cake_item10 = new Item(cake_category, "퀸즈캐롯", 38000);
		cake_item10.setItemUrl("images/cake/퀸즈캐롯.jpg");
		service.addItem(cake_item10);

		Item cake_item11 = new Item(cake_category, "클래식가토쇼콜라", 36500);
		cake_item11.setItemUrl("images/cake/클래식가토쇼콜라.jpg");
		service.addItem(cake_item11);

		Item cake_item12 = new Item(cake_category, "투썸스노우베어", 37000);
		cake_item12.setItemUrl("images/cake/투썸스노우베어.jpg");
		service.addItem(cake_item12);

		Item cake_item13 = new Item(cake_category, "트리플베리생크림", 33000);
		cake_item13.setItemUrl("images/cake/트리플베리생크림.jpg");
		service.addItem(cake_item13);

		Item cake_item14 = new Item(cake_category, "파티팩딸기레어치즈", 33000);
		cake_item14.setItemUrl("images/cake/파티팩딸기레어치즈.jpg");
		service.addItem(cake_item14);

		Item cake_item15 = new Item(cake_category, "파티팩아이스박스", 35000);
		cake_item15.setItemUrl("images/cake/파티팩아이스박스.jpg");
		service.addItem(cake_item15);

		Item cake_item16 = new Item(cake_category, "화이트바닐라빈무스", 34500);
		cake_item16.setItemUrl("images/cake/화이트바닐라빈무스.jpg");
		service.addItem(cake_item16);

		// 5. Meal Menu

		Item meal_item1 = new Item(meal_category, "과카몰리치킨샐러드", 8000);
		meal_item1.setItemUrl("images/meal/과카몰리치킨샐러드.jpg");
		service.addItem(meal_item1);

		Item meal_item2 = new Item(meal_category, "그릴드치킨샐러드", 8500);
		meal_item2.setItemUrl("images/meal/그릴드치킨샐러드.jpg");
		service.addItem(meal_item2);

		Item meal_item3 = new Item(meal_category, "분짜샐러드", 7500);
		meal_item3.setItemUrl("images/meal/분짜샐러드.jpg");
		service.addItem(meal_item3);

		Item meal_item4 = new Item(meal_category, "쉬림프콥샐러드", 8000);
		meal_item4.setItemUrl("images/meal/쉬림프콥샐러드.jpg");
		service.addItem(meal_item4);

		Item meal_item5 = new Item(meal_category, "찰보리콥샐러드", 7500);
		meal_item5.setItemUrl("images/meal/찰보리콥샐러드.jpg");
		service.addItem(meal_item5);

		Item meal_item6 = new Item(meal_category, "카프레제샐러드", 8100);
		meal_item6.setItemUrl("images/meal/카프레제샐러드.jpg");
		service.addItem(meal_item6);

		Item meal_item7 = new Item(meal_category, "크랜베리치킨샌드위치", 6500);
		meal_item7.setItemUrl("images/meal/크랜베리치킨샌드위치.jpg");
		service.addItem(meal_item7);

		Item meal_item8 = new Item(meal_category, "스크램블에그샌드위치", 4500);
		meal_item8.setItemUrl("images/meal/스크램블에그샌드위치.jpg");
		service.addItem(meal_item8);

		Item meal_item9 = new Item(meal_category, "멕시칸파니니", 5500);
		meal_item9.setItemUrl("images/meal/멕시칸파니니.jpg");
		service.addItem(meal_item9);

		Item meal_item10 = new Item(meal_category, "바베큐치킨파니니", 6500);
		meal_item10.setItemUrl("images/meal/바베큐치킨파니니.jpg");
		service.addItem(meal_item10);

		Item meal_item11 = new Item(meal_category, "올리브치킨파니니", 5500);
		meal_item11.setItemUrl("images/meal/올리브치킨파니니.jpg");
		service.addItem(meal_item11);

		Item meal_item12 = new Item(meal_category, "스윗에그토스트", 5900);
		meal_item12.setItemUrl("images/meal/스윗에그토스트.jpg");
		service.addItem(meal_item12);

		Item meal_item13 = new Item(meal_category, "스파이시치킨샐러드랩", 3500);
		meal_item13.setItemUrl("images/meal/스파이시치킨샐러드랩.jpg");
		service.addItem(meal_item13);

		Item meal_item14 = new Item(meal_category, "식물성대체육옴니미트샐러드랩", 3800);
		meal_item14.setItemUrl("images/meal/식물성대체육옴니미트샐러드랩.jpg");
		service.addItem(meal_item14);

		Item meal_item15 = new Item(meal_category, "에그베이컨브리오슈", 6600);
		meal_item15.setItemUrl("images/meal/에그베이컨브리오슈.jpg");
		service.addItem(meal_item15);

		Item meal_item16 = new Item(meal_category, "단호박크림치즈샌드위치", 6900);
		meal_item16.setItemUrl("images/meal/단호박크림치즈샌드위치.jpg");
		service.addItem(meal_item16);

		// 6. Bread Menu

		Item bread_item1 = new Item(bread_category, "브리오슈슈크레", 3000);
		bread_item1.setItemUrl("images/bread/브리오슈슈크레.jpg");
		service.addItem(bread_item1);

		Item bread_item2 = new Item(bread_category, "뺑오쇼콜라", 2000);
		bread_item2.setItemUrl("images/bread/뺑오쇼콜라.jpg");
		service.addItem(bread_item2);

		Item bread_item3 = new Item(bread_category, "뺑오커스터드", 2000);
		bread_item3.setItemUrl("images/bread/뺑오커스터드.jpg");
		service.addItem(bread_item3);

		Item bread_item4 = new Item(bread_category, "소시지페이스트리", 2500);
		bread_item4.setItemUrl("images/bread/소시지페이스트리.jpg");
		service.addItem(bread_item4);

		Item bread_item5 = new Item(bread_category, "크루아상", 3000);
		bread_item5.setItemUrl("images/bread/크루아상.jpg");
		service.addItem(bread_item5);

		Item bread_item6 = new Item(bread_category, "파마산크루아상", 3500);
		bread_item6.setItemUrl("images/bread/파마산크루아상.jpg");
		service.addItem(bread_item6);

		Item bread_item7 = new Item(bread_category, "토마토베이컨블루밍브레드", 4000);
		bread_item7.setItemUrl("images/bread/토마토베이컨블루밍브레드.jpg");
		service.addItem(bread_item7);

		Item bread_item8 = new Item(bread_category, "6치즈블루밍브레드", 4500);
		bread_item8.setItemUrl("images/bread/6치즈블루밍브레드.jpg");
		service.addItem(bread_item8);

		Item bread_item9 = new Item(bread_category, "넛츠크림치즈크럼블페이스트리", 4300);
		bread_item9.setItemUrl("images/bread/넛츠크림치즈크럼블페이스트리.jpg");
		service.addItem(bread_item9);

		Item bread_item10 = new Item(bread_category, "까눌레", 2000);
		bread_item10.setItemUrl("images/bread/까눌레.jpg");
		service.addItem(bread_item10);

		Item bread_item11 = new Item(bread_category, "생미쉘시트러스마들렌", 2000);
		bread_item11.setItemUrl("images/bread/생미쉘시트러스마들렌.jpg");
		service.addItem(bread_item11);

		Item bread_item12 = new Item(bread_category, "TWG밀크리파운드", 3800);
		bread_item12.setItemUrl("images/bread/TWG밀크리파운드.jpg");
		service.addItem(bread_item12);

		Item bread_item13 = new Item(bread_category, "플레인베이글", 3500);
		bread_item13.setItemUrl("images/bread/플레인베이글.jpg");
		service.addItem(bread_item13);

		Item bread_item14 = new Item(bread_category, "호두베이글", 4500);
		bread_item14.setItemUrl("images/bread/호두베이글.jpg");
		service.addItem(bread_item14);

		Item bread_item15 = new Item(bread_category, "에그베이컨페이스트리", 6000);
		bread_item15.setItemUrl("images/bread/에그베이컨페이스트리.jpg");
		service.addItem(bread_item15);

		Item bread_item16 = new Item(bread_category, "오렌지쇼콜라파운드", 3000);
		bread_item16.setItemUrl("images/bread/오렌지쇼콜라파운드.jpg");
		service.addItem(bread_item16);

		// 7. Md Menu

		Item md_item1 = new Item(md_category, "투썸 베이직 스텐머그[그레이]", 25000);
		md_item1.setItemUrl("images/md/투썸베이직스텐머그_그레이.png");
		service.addItem(md_item1);

		Item md_item2 = new Item(md_category, "투썸 베이직 스텐머그[화이트]", 25000);
		md_item2.setItemUrl("images/md/투썸베이직스텐머그_화이트.jpg");
		service.addItem(md_item2);

		Item md_item3 = new Item(md_category, "투썸 베이직 스텐텀블러[그레이]", 38000);
		md_item3.setItemUrl("images/md/투썸베이직스텐텀블러_그레이.png");
		service.addItem(md_item3);

		Item md_item4 = new Item(md_category, "투썸베이직스텐텀블러[화이트]", 38000);
		md_item4.setItemUrl("images/md/투썸베이직스텐텀블러_화이트.jpg");
		service.addItem(md_item4);

		Item md_item5 = new Item(md_category, "투썸 그레이 롱머그", 28000);
		md_item5.setItemUrl("images/md/투썸그레이롱머그.jpg");
		service.addItem(md_item5);

		Item md_item6 = new Item(md_category, "투썸 화이트 롱머그", 2800);
		md_item6.setItemUrl("images/md/투썸화이트롱머그.jpg");
		service.addItem(md_item6);

		Item md_item7 = new Item(md_category, "투썸 그레이 머그", 23000);
		md_item7.setItemUrl("images/md/투썸그레이머그.jpg");
		service.addItem(md_item7);

		Item md_item8 = new Item(md_category, "투썸 화이트 머그", 23000);
		md_item8.setItemUrl("images/md/투썸화이트머그.jpg");
		service.addItem(md_item8);

		Item md_item9 = new Item(md_category, "미라클 디저트볼 세트", 39000);
		md_item9.setItemUrl("images/md/미라클디저트볼세트.jpg");
		service.addItem(md_item9);

		Item md_item10 = new Item(md_category, "미라클 스텐컵", 35000);
		md_item10.setItemUrl("images/md/미라클스텐컵.jpg");
		service.addItem(md_item10);

		Item md_item11 = new Item(md_category, "미라클 스트로우 텀블러", 38500);
		md_item11.setItemUrl("images/md/미라클스트로우텀블러.jpg");
		service.addItem(md_item11);

		Item md_item12 = new Item(md_category, "미라클 MAX 스텐텀블러", 40000);
		md_item12.setItemUrl("images/md/미라클MAX스텐텀블러.jpg");
		service.addItem(md_item12);

		Item md_item13 = new Item(md_category, "투썸X미르 캠프컵[그린]", 35000);
	      md_item13.setItemUrl("images/md/투썸X미르캠프컵_그린.jpg");

	    Item md_item14 = new Item(md_category, "투썸X미르 캠프컵[옐로우]", 35000);
	      md_item14.setItemUrl("images/md/투썸X미르캠프컵_옐로우.jpg");

	    Item md_item15 = new Item(md_category, "투썸X미르 텀블러[그린]", 50000);
	      md_item15.setItemUrl("images/md/투썸X미르텀블러_그린.jpg");

	    Item md_item16 = new Item(md_category, "투썸X미르 텀블러[옐로우]", 50000);
	      md_item16.setItemUrl("images/md/투썸X미르텀블러_옐로우.jpg");
	      
	      System.out.println("ItemServiceTest: 저장 완료.");

		// 옛날에 쓰던 test문
		// Category category = cService.findCategoryByCategoryName("deletedMenu");
		// Category category = cService.findCategoryByCategoryName("라떼Dao");
		// Item item = new Item(category, "delete", 0); //deletedMenu 카테고리에 넣기
		// Item item = new Item(category, "바닐라Dao", 5000);
		// item.setItemUrl("주소");
		// Item item = new Item(category, "초코Dao", 6000);
		// System.out.println(menu.getCustomer().getCid());
		// service.addItem(item);
		// System.out.println("ItemServiceTest : 저장 완료");
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
	
	//2-5. 메뉴아이템id로 메뉴아이템 조회
	public static void findItemByItemId() {
		Item item = service.findItemByItemId(1l);
		System.out.println(item.getItemName());
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
