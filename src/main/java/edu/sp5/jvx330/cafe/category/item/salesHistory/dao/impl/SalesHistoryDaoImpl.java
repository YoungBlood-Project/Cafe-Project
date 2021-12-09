package edu.sp5.jvx330.cafe.category.item.salesHistory.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.category.item.salesHistory.dao.SalesHistoryDao;
import edu.sp5.jvx330.cafe.category.item.salesHistory.dao.SalesHistoryMenuRowMapper;
import edu.sp5.jvx330.cafe.category.item.salesHistory.domain.SalesHistory;

public class SalesHistoryDaoImpl implements SalesHistoryDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * 1. 판매내역 추가(메뉴 id, 판매내역)
	 */
	@Override
	public void addSalesHistory(Long menuId, SalesHistory salesHistory) {
		String sql = "INSERT INTO SalesHistory(menuId, orderNum, numOfSales, paidPrice)"
				+ " VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, menuId, salesHistory.getOrderNum(), salesHistory.getNumOfSales(), salesHistory.getPaidPrice());
	}
	
	/**
	 * 2. 판매내역 조회
	 */
	//2-1. 판매내역 전체 조회
	@Override
	public List<SalesHistory> findAllSalesHistory() {
		String sql = "SELECT sid, menuId, numOfSales, orderNum, paidPrice, orderDate"
				+ " FROM SalesHistory";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper());
	}
	//2-2. 해당 날짜로 판매내역 조회
	@Override
	public List<SalesHistory> findSalesHistoryByOrderDate(Date orderDate) {
		String sql = "SELECT sid, menuId, numOfSales, orderNum, paidPrice, orderDate"
				+ " FROM SalesHistory WHERE Date(orderDate) = ?";
		//날짜로 검색
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), orderDate);
	}

	//2-3. 해당 메뉴로 판매내역 조회
	@Override
	public List<SalesHistory> findSalesHistoryByMenu(Long menuId) {
		String sql = "SELECT sid, menuId, numOfSales, orderNum, paidPrice, orderDate"
				+ " FROM SalesHistory WHERE menuId = ?";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), menuId);
	}
	
	//2-4. 주문번호로 판매내역 조회(Integer orderNum -> Long orderNum)
	public List<SalesHistory> findSalesHistoryByOrderNum(Long orderNum) {
		String sql = "SELECT sid, menuId, numOfSales, orderNum, paidPrice, orderDate"
				+ " FROM SalesHistory WHERE orderNum = ?";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), orderNum);
	}
	
	/**
	 * 3. 판매내역 삭제
	 */
	//3-1. 환불
	@Override
	public void deleteSalesHistoryBySid(Long sid) {
		String sql = "DELETE FROM SalesHistory WHERE sid = ?";
		jdbcTemplate.update(sql, sid);
	}
	//3-2. 해당 메뉴의 판매내역 전체 삭제
	@Override
	public void deleteAllSalesHistories(Long menuId) {
		String sql = "DELETE FROM SalesHistory WHERE menuId = ?";
		jdbcTemplate.update(sql, menuId);
	}
	
	/**
	 * 4. 메뉴삭제(판매내역 메뉴 id 변경)
	 */
	public void setItemIdFromSalesHistory(Long itemId, SalesHistory salesHistory) {
		String sql = "UPDATE SalesHistory SET itemId = ? WHERE itemId = ?";
		jdbcTemplate.update(sql, itemId, salesHistory.getItem().getItemId());
	};
	
	/**
	 * 0. 제약조건 변경
	 */
	//에러 발생(후에 고치기)
	//0-1. 제약조건 삭제
	public void disableConstraintFromSH() {
		String sql = "ALTER TABLE SalesHistory DROP CONSTRAINT SalesHistory_menuId_FK";
		jdbcTemplate.update(sql);
	}
	//0-2. 제약조건 추가
	public void enableConstraintFromSH() {
		String sql = "ALTER TABLE SalesHistory ADD CONSTRAINT SalesHistory_menuId_FK FOREIGN KEY(menuId) REFERENCES Menu(mid)";
		jdbcTemplate.update(sql);
	}
}
