package edu.sp5.jvx330.cafe.sales.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import edu.sp5.jvx330.cafe.menu.dao.impl.ItemDaoImpl;
import edu.sp5.jvx330.cafe.menu.domain.Item;
import edu.sp5.jvx330.cafe.sales.business.SalesHistoryService;
import edu.sp5.jvx330.cafe.sales.dao.impl.SalesHistoryDaoImpl;
import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;


public class SalesHistoryServiceImpl implements SalesHistoryService {
	@Autowired
	ItemDaoImpl iDao;
	@Autowired
	SalesHistoryDaoImpl shDao;
	
	/**
	 * 1. 판매내역 추가
	 */
	@Override
	public void addSalesHistory(String itemName, SalesHistory salesHistory) {
		Long mid = iDao.findItemIdByItemName(itemName);
		//주문 번호는 컨트롤러에서 넣어줘야할 거 같다.  
		shDao.addSalesHistory(mid, salesHistory);
	}
	
	/**
	 * 2. 판매내역 조회
	 */
	//2-1. 판매내역 전체 조회
	@Override
	public List<SalesHistory> findAllSalesHistory() {
		return shDao.findAllSalesHistory();
	}
	//2-2. 해당 날짜로 판매내역 조회
	@Override
	public List<SalesHistory> findSalesHistoryByOrderDate(Date orderDate) {
		return shDao.findSalesHistoryByOrderDate(orderDate);
	}
	
	//2-3. 해당 메뉴로 판매내역 조회(ItemId 사용할 것)
	@Override
	public List<SalesHistory> findSalesHistoryByItem(Item item) {
		//메뉴 이름 받아서 id 조회
		Long itemId = iDao.findItemIdByItemName(item.getItemName());
		return shDao.findSalesHistoryByItem(itemId);
	}
	
	/**
	 * 정혜윤 추가
	 * (Integer orderNum -> Long orderNum)
	 * @param orderNum
	 * @return
	 */
	// 2-4. 해당 주문 번호로 판매내역 조회
	public List<SalesHistory> findSalesHistoryByOrderNum(Long orderNum) {
		try {
		List<SalesHistory> sh_list = shDao.findSalesHistoryByOrderNum(orderNum);
		return sh_list;
		} catch(NumberFormatException e) {
			return null;
		} catch(EmptyResultDataAccessException e) {
			return null;
		} 
	}
	
	/**
	 * 3. 판매내역 삭제
	 */
	//3-1. 환불
	@Override
	//3-1. 환불(해당 SalesHistory)
	public void deleteSalesHistoryBySHid(SalesHistory salesHistory) {
		shDao.deleteSalesHistoryBySHid(salesHistory.getShid());
	}
	//3-2. 해당 메뉴의 판매내역 전체 삭제
	@Override
	public void deleteAllSalesHistories(Item item) {
		Long itemId = iDao.findItemIdByItemName(item.getItemName());
		shDao.deleteAllSalesHistories(itemId);
	}

	/**
	 * 4. 날짜별 판매내역 개수
	 */
	@Override
	public Integer countSalesHistoryByOrderDate(Date orderDate) {
		return findSalesHistoryByOrderDate(orderDate).size();
	}
	
	/**
	 * 5. 해당 주문번호의 판매내역별 수량의 총 수량
	 */
	@Override
	public Integer sumNumOfSalesByOrderNum(Long orderNum) {
		return shDao.sumNumOfSalesByOrderNum(orderNum);
	};
}
