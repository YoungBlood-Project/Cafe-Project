package edu.sp5.jvx330.cafe.menu.dao;

import java.util.List;

import edu.sp5.jvx330.cafe.menu.domain.Category;
import edu.sp5.jvx330.cafe.menu.domain.Item;

public interface ItemDao {
	/**
	 * 1. 관리메뉴
	 */
	//1-1. 메뉴 추가 
	public void addItem(Item item);
	
	//1-2. 메뉴 수정
	//메뉴 이름 수정
	public Item setItemName(Item item, String itemName);
	
	//메뉴 가격 수정
	public Item setItemPrice(Item item, Integer itemPrice);
	
	//1-3. 메뉴 삭제(메뉴 이름으로 삭제)
	public void deleteItem(String itemName);
	
	/**
	 * 2. 메뉴 조회
	 */
	//2-1. 메뉴 id 조회(메뉴 이름으로 조회)
	//SalesHistoryServiceImpl에서 사용
	public Long findItemIdByItemName(String itemName);
	//2-2. 카테고리별 메뉴 조회
	public List<Item> findItemsByCategory(Category category);
	//2-3. 메뉴이름으로 메뉴 조회
	public Item findItemByItemName(String itemName);
	//2-4. 전체 메뉴 조회
	public List<Item> findAllItems();
	//2-5. 메뉴아이템id로 메뉴아이템 조회
	public Item findItemByItemId(Long itemId);
	
}
