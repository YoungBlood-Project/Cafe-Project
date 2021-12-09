package edu.sp5.jvx330.cafe.category.item.salesHistory.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.category.item.dao.impl.ItemDaoImpl;
import edu.sp5.jvx330.cafe.category.item.domain.Item;
import edu.sp5.jvx330.cafe.category.item.salesHistory.business.SalesHistoryService;
import edu.sp5.jvx330.cafe.category.item.salesHistory.dao.impl.SalesHistoryDaoImpl;
import edu.sp5.jvx330.cafe.category.item.salesHistory.domain.SalesHistory;
import edu.sp5.jvx330.cafe.customer.mileage.business.impl.MileageServiceImpl;
import edu.sp5.jvx330.cafe.customer.mileageHistory.business.impl.MileageHistoryServiceImpl;

public class SalesHistoryServiceImpl implements SalesHistoryService {
	@Autowired
	ItemDaoImpl iDao;
	@Autowired
	SalesHistoryDaoImpl shDao;
	
	@Autowired
	MileageServiceImpl mileageService;
	@Autowired
	MileageServiceImpl tmService;
	
	/**
	 * 1. 판매내역 추가
	 */
	@Override
	public void addSalesHistory(Item item, SalesHistory salesHistory) {
		Long mid = iDao.findItemIdByItemName(item.getItemName());
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
	
	//2-3. 해당 메뉴로 판매내역 조회(menuId 사용할 것)
	@Override
	public List<SalesHistory> findSalesHistoryByMenu(Item item) {
		//메뉴 이름 받아서 id 조회
		Long mid = iDao.findItemIdByItemName(item.getItemName());
		return shDao.findSalesHistoryByMenu(mid);
	}
	
	/**
	 * 정혜윤 추가
	 * (Integer orderNum -> Long orderNum)
	 * @param orderNum
	 * @return
	 */
	// 2-4. 해당 주문 번호로 판매내역 조회
	public List<SalesHistory> findSalesHistoryByOrderNum(Long orderNum) {
		return shDao.findSalesHistoryByOrderNum(orderNum);
	}
	
	/**
	 * 3. 판매내역 삭제
	 */
	//3-1. 환불
	@Override
	//3-1. 환불(해당 SalesHistory)
	public void deleteSalesHistoryBySid(SalesHistory salesHistory) {
		shDao.deleteSalesHistoryBySid(salesHistory.getShid());
	}
	//3-2. 해당 메뉴의 판매내역 전체 삭제
	@Override
	public void deleteAllSalesHistories(Item item) {
		Long mid = iDao.findItemIdByItemName(item.getItemName());
		shDao.deleteAllSalesHistories(mid);
	}

	/**
	 * 4. 날짜별 판매내역 개수
	 */
	@Override
	public Integer countSalesHistoryByOrderDate(Date orderDate) {
		return findSalesHistoryByOrderDate(orderDate).size();
	}
}
