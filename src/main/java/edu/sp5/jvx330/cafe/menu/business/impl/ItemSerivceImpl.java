package edu.sp5.jvx330.cafe.menu.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.menu.business.ItemService;
import edu.sp5.jvx330.cafe.menu.dao.impl.ItemDaoImpl;
import edu.sp5.jvx330.cafe.menu.domain.Category;
import edu.sp5.jvx330.cafe.menu.domain.Item;
import edu.sp5.jvx330.cafe.sales.dao.impl.SalesHistoryDaoImpl;
import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;

public class ItemSerivceImpl implements ItemService {
	@Autowired
	private ItemDaoImpl iDao;
	@Autowired
	private SalesHistoryDaoImpl shDao;
	
	/**
	 * 1. 관리메뉴
	 */
	//1-1. 아이템 추가
	@Override
	public void addItem(Item item) {
		iDao.addItem(item);
	}
	
	//1-2. 아이템 수정
	//아이템 이름 수정
	@Override
	public Item setItemName(Item item, String itemName) {
		return iDao.setItemName(item, itemName);
	}

	//아이템 가격 수정
	@Override
	public Item setItemPrice(Item item, Integer itemPrice) {
		return iDao.setItemPrice(item, itemPrice);
	}
	
	//1-3. 아이템 삭제
	@Override
	public void deleteItem(Item item) {	
		//삭제할 아이템의 id로 판매내역 조회
		List<SalesHistory> sh_list = shDao.findSalesHistoryByItem(item.getItemId());
		Long deleteId = iDao.findItemIdByItemName(item.getItemName());
		//넣은 item의 이름으로 삭제될 itemId 조회
		System.out.println(deleteId);
		for(SalesHistory sh : sh_list) {
			shDao.setItemIdFromSalesHistory(deleteId, sh);
		}
		
		//제약조건 삭제
		shDao.disableConstraintFromSH();
		//메뉴 삭제
		iDao.deleteItem(item.getItemName());
		//제약조건 추가
		shDao.enableConstraintFromSH();
	}

	/**
	 * 2. 메뉴 조회
	 */
	//2-1. 메뉴 id 조회
	@Override
	public Long findItemIdByItemName(String itemName) {
		return iDao.findItemIdByItemName(itemName);
	}

	//2-2. 카테고리별 메뉴 조회
	@Override
	public List<Item> findItemsByCategory(Category category) {
		List<Item> item_list = iDao.findItemsByCategory(category);

		return item_list;
	}

	//2-3. 메뉴 이름으로 메뉴 조회
	@Override
	public Item findItemByItemName(String itemName) {
		return iDao.findItemByItemName(itemName);
	}
	//2-4. 전체 메뉴 조회
	@Override
	public List<Item> findAllItems() {
		return iDao.findAllItems();
	}
	
	//2-5. 메뉴아이템id로 메뉴아이템 조회
	@Override
	public Item findItemByItemId(Long itemId) {
		return iDao.findItemByItemId(itemId);
	};
	
	
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
