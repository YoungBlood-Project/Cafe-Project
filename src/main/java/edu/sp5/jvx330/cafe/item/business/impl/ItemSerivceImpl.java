package edu.sp5.jvx330.cafe.item.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.customer.mileage.dao.impl.MileageDaoImpl;
import edu.sp5.jvx330.cafe.item.business.ItemService;
import edu.sp5.jvx330.cafe.item.dao.impl.ItemDaoImpl;
import edu.sp5.jvx330.cafe.item.domain.Item;
import edu.sp5.jvx330.cafe.item.salesHistory.dao.impl.SalesHistoryDaoImpl;
import edu.sp5.jvx330.cafe.item.salesHistory.domain.SalesHistory;

public class ItemSerivceImpl implements ItemService {
	@Autowired
	private ItemDaoImpl mDao;
	@Autowired
	private SalesHistoryDaoImpl shDao;
	@Autowired
	private MileageDaoImpl tmDao;
	
	/**
	 * 1. 관리메뉴
	 */
	//1-1. 메뉴 추가
	@Override
	public void addMenu(Item item) {
		mDao.addMenu(item);
	}
	
	//1-2. 메뉴 수정
	//메뉴 이름 수정
	@Override
	public Item setMenuName(Item item, String menuName) {
		return mDao.setMenuName(item, menuName);
	}

	//메뉴 가격 수정
	@Override
	public Item setMenuSales(Item item, Integer menuPrice) {
		return mDao.setMenuSales(item, menuPrice);
	}
	
	//1-3. 메뉴 삭제
	@Override
	public void deleteMenu(Item item) {	
		//삭제할 메뉴의 id로 판매내역 조회
		List<SalesHistory> sh_list = shDao.findSalesHistoryByMenu(item.getMid());
		Long deleteId = mDao.findMidByMenu("delete");
		System.out.println(deleteId);
		for(SalesHistory sh : sh_list) {
			shDao.setMenuIdFromSalesHistory(deleteId, sh);
		}
		
		//제약조건 삭제
		shDao.disableConstraintFromSH();
		//메뉴 삭제
		mDao.deleteMenu(item.getMenuName());
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
		List<Item> menu_list = mDao.findMidByCategory(category);
		List<Long> mid_list = new ArrayList<Long>();
		for(Item item : menu_list) {
			mid_list.add(item.getMid());
		}
		return mid_list;
	}
	//2-3. 메뉴 이름으로 메뉴 조회
	@Override
	public Item findMenuByMenuName(String menuName) {
		return mDao.findMenuByMenuName(menuName);
	}
	//2-4. 전체 메뉴 조회
	@Override
	public List<Item> findAllMenus() {
		return mDao.findAllMenus();
	}
	
	/**
	  * 3. 주문 목록 - 정혜윤 추가
	  */
	@Override
	//1. 주문 목록에 메뉴 추가
	public List<Item> addOrderList(Item item) {
		List<Item> order_list = new ArrayList<Item>();
		order_list.add(item);
		return order_list;
	};
	   
	@Override
	//2. 주문 목록에 메뉴 삭제
	public List<Item> deleteOrderList(int orderNum, List<Item> order_list){
		order_list.remove(orderNum);
		return order_list;
	};
	   
}
