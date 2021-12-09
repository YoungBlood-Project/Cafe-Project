package edu.sp5.jvx330.cafe.item.business;

import java.util.List;

import edu.sp5.jvx330.cafe.item.domain.Menu;

public interface MenuService {
	/**
	 * 1. 관리메뉴
	 */
	//1-1. 메뉴 추가 
	public void addMenu(Menu menu);
	
	//1-2. 메뉴 수정
	//1-2-1. 메뉴 이름 수정
	public Menu setMenuName(Menu menu, String menuName);
	
	//1-2-2. 메뉴 가격 수정
	public Menu setMenuSales(Menu menu, Integer menuPrice);
	
	//1-3. 메뉴 삭제
	public void deleteMenu(Menu menu);
	
	/**
	 * 2. 메뉴 조회
	 */
	//2-1. 메뉴 id 조회
	public Long findMidByMenuName(String menuName);
	//2-2. 카테고리별 메뉴 id 조회
	public List<Long> findMidByCategory(String category);
	//2-3. 메뉴 이름으로 메뉴 조회
	public Menu findMenuByMenuName(String menuName);
	//2-4. 전체 메뉴 조회
	public List<Menu> findAllMenus();
	
	/**
	 * 3. 주문 목록
	 */
	//1. 주문 목록에 메뉴 추가
	public List<Menu> addOrderList(Menu menu);
	//2. 주문 목록에 메뉴 삭제
	public List<Menu> deleteOrderList(int menuNum, List<Menu> order_list);
}
