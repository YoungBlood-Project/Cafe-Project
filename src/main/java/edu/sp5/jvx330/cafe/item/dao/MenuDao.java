package edu.sp5.jvx330.cafe.item.dao;

import java.util.List;

import edu.sp5.jvx330.cafe.item.domain.Menu;

public interface MenuDao {
	/**
	 * 1. 관리메뉴
	 */
	//1-1. 메뉴 추가 
	public void addMenu(Menu menu);
	
	//1-2. 메뉴 수정
	//메뉴 이름 수정
	public Menu setMenuName(Menu menu, String menuName);
	
	//메뉴 가격 수정
	public Menu setMenuSales(Menu menu, Integer menuPrice);
	
	//1-3. 메뉴 삭제(메뉴 이름으로 삭제)
	public void deleteMenu(String menuName);
	
	/**
	 * 2. 메뉴 조회
	 */
	//2-1. 메뉴 id 조회(메뉴 이름으로 조회)
	//SalesHistoryServiceImpl에서 사용
	public Long findMidByMenu(String menuName);
	//2-2. 카테고리별 메뉴 조회
	public List<Menu> findMidByCategory(String category);
	//2-3. 메뉴이름으로 메뉴 조회
	public Menu findMenuByMenuName(String menuName);
	//2-4. 전체 메뉴 조회
	public List<Menu> findAllMenus();
}
