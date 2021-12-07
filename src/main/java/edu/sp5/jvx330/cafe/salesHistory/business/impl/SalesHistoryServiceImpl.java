package edu.sp5.jvx330.cafe.salesHistory.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.jvx330.cafe.menu.dao.impl.MenuDaoImpl;
import edu.sp5.jvx330.cafe.menu.domain.Menu;
import edu.sp5.jvx330.cafe.mileage.business.impl.MileageServiceImpl;
import edu.sp5.jvx330.cafe.mileage.dao.impl.MileageDaoImpl;
import edu.sp5.jvx330.cafe.salesHistory.business.SalesHistoryService;
import edu.sp5.jvx330.cafe.salesHistory.dao.impl.SalesHistoryDaoImpl;
import edu.sp5.jvx330.cafe.salesHistory.domain.SalesHistory;
import edu.sp5.jvx330.cafe.salesHistory.util.OrderNumGenerator;
import edu.sp5.jvx330.cafe.totalMileage.business.impl.TotalMileageServiceImpl;
import edu.sp5.jvx330.cafe.totalMileage.dao.impl.TotalMileageDaoImpl;

public class SalesHistoryServiceImpl implements SalesHistoryService {
	@Autowired
	MenuDaoImpl mDao;
	@Autowired
	SalesHistoryDaoImpl shDao;
	
	@Autowired
	MileageServiceImpl mileageService;
	@Autowired
	TotalMileageServiceImpl tmService;
	
	/**
	 * 1. 판매내역 추가
	 */
	@Override
	public void addSalesHistory(Menu menu, SalesHistory salesHistory) {
		Long mid = mDao.findMidByMenu(menu.getMenuName());
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
	public List<SalesHistory> findSalesHistoryByMenu(Menu menu) {
		//메뉴 이름 받아서 id 조회
		Long mid = mDao.findMidByMenu(menu.getMenuName());
		return shDao.findSalesHistoryByMenu(mid);
	}
	
	/**
	 * 3. 판매내역 삭제
	 */
	//3-1. 환불
	@Override
	//3-1. 환불(해당 SalesHistory)
	public void deleteSalesHistoryBySid(SalesHistory salesHistory) {
		shDao.deleteSalesHistoryBySid(salesHistory.getSid());
	}
	//3-2. 해당 메뉴의 판매내역 전체 삭제
	@Override
	public void deleteAllSalesHistories(Menu menu) {
		Long mid = mDao.findMidByMenu(menu.getMenuName());
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
