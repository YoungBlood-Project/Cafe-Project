package edu.sp5.jvx330.cafe.item.business;

import java.util.List;

import edu.sp5.jvx330.cafe.item.domain.Item;

public interface ItemService {
	/**
	 * 1. 관리메뉴
	 */
	//1-1. 메뉴 추가 
	public void addMenu(Item item);
	
	//1-2. 메뉴 수정
	//1-2-1. 메뉴 이름 수정
	public Item setMenuName(Item item, String menuName);
	
	//1-2-2. 메뉴 가격 수정
	public Item setMenuSales(Item item, Integer menuPrice);
	
	//1-3. 메뉴 삭제
	public void deleteMenu(Item item);
	
	/**
	 * 2. 메뉴 조회
	 */
	//2-1. 메뉴 id 조회
	public Long findMidByMenuName(String menuName);
	//2-2. 카테고리별 메뉴 id 조회
	public List<Long> findMidByCategory(String category);
	//2-3. 메뉴 이름으로 메뉴 조회
	public Item findMenuByMenuName(String menuName);
	//2-4. 전체 메뉴 조회
	public List<Item> findAllMenus();
	
	/**
	 * 3. 주문 목록
	 */
	//1. 주문 목록에 메뉴 추가
	public List<Item> addOrderList(Item item);
	//2. 주문 목록에 메뉴 삭제
	public List<Item> deleteOrderList(int menuNum, List<Item> order_list);
}
