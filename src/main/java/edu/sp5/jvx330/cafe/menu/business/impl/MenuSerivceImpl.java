package edu.sp5.jvx330.cafe.menu.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.menu.business.MenuService;
import edu.sp5.jvx330.cafe.menu.dao.impl.MenuDaoImpl;
import edu.sp5.jvx330.cafe.menu.domain.Menu;
import edu.sp5.jvx330.cafe.salesHistory.dao.impl.SalesHistoryDaoImpl;
import edu.sp5.jvx330.cafe.salesHistory.domain.SalesHistory;
import edu.sp5.jvx330.cafe.totalMileage.dao.impl.TotalMileageDaoImpl;

public class MenuSerivceImpl implements MenuService {
	@Autowired
	private MenuDaoImpl mDao;
	@Autowired
	private SalesHistoryDaoImpl shDao;
	@Autowired
	private TotalMileageDaoImpl tmDao;
	
	/**
	 * 1. 관리메뉴
	 */
	//1-1. 메뉴 추가
	@Override
	public void addMenu(Menu menu) {
		mDao.addMenu(menu);
	}
	
	//1-2. 메뉴 수정
	//메뉴 이름 수정
	@Override
	public Menu setMenuName(Menu menu, String menuName) {
		return mDao.setMenuName(menu, menuName);
	}

	//메뉴 가격 수정
	@Override
	public Menu setMenuSales(Menu menu, Integer menuPrice) {
		return mDao.setMenuSales(menu, menuPrice);
	}
	
	//1-3. 메뉴 삭제
	@Override
	public void deleteMenu(Menu menu) {	
		//삭제할 메뉴의 id로 판매내역 조회
		List<SalesHistory> sh_list = shDao.findSalesHistoryByMenu(menu.getMid());
		Long deleteId = mDao.findMidByMenu("delete");
		System.out.println(deleteId);
		for(SalesHistory sh : sh_list) {
			shDao.setMenuIdFromSalesHistory(deleteId, sh);
		}
		
		//제약조건 삭제
		shDao.disableConstraintFromSH();
		//메뉴 삭제
		mDao.deleteMenu(menu.getMenuName());
		//제약조건 추가
		shDao.enableConstraintFromSH();
	}

	/**
	 * 2. 메뉴 조회
	 */
	//2-1. 메뉴 id 조회
	@Override
	public Long findMidByMenuName(String menuName) {
		return mDao.findMidByMenu(menuName);
	}

	//2-2. 카테고리별 메뉴 id 조회
	@Override
	public List<Long> findMidByCategory(String category) {
		List<Menu> menu_list = mDao.findMidByCategory(category);
		List<Long> mid_list = new ArrayList<Long>();
		for(Menu menu : menu_list) {
			mid_list.add(menu.getMid());
		}
		return mid_list;
	}
	//2-3. 메뉴 이름으로 메뉴 조회
	@Override
	public Menu findMenuByMenuName(String menuName) {
		return mDao.findMenuByMenuName(menuName);
	}
	//2-4. 전체 메뉴 조회
	@Override
	public List<Menu> findAllMenus() {
		return mDao.findAllMenus();
	}
	
	/**
	  * 3. 주문 목록 - 정혜윤 추가
	  */
	@Override
	//1. 주문 목록에 메뉴 추가
	public List<Menu> addOrderList(Menu menu) {
		List<Menu> order_list = new ArrayList<Menu>();
		order_list.add(menu);
		return order_list;
	};
	   
	@Override
	//2. 주문 목록에 메뉴 삭제
	public List<Menu> deleteOrderList(int orderNum, List<Menu> order_list){
		order_list.remove(orderNum);
		return order_list;
	};
	   
}
