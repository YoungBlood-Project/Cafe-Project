package edu.sp5.jvx330.cafe.sales.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import edu.sp5.jvx330.cafe.menu.domain.Item;
import edu.sp5.jvx330.cafe.sales.dao.SalesHistoryDao;
import edu.sp5.jvx330.cafe.sales.dao.SalesHistoryMenuRowMapper;
import edu.sp5.jvx330.cafe.sales.dao.SalesTotalPriceRowMapper;
import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

public class SalesHistoryDaoImpl implements SalesHistoryDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * 1. 판매내역 추가(메뉴 id, 판매내역)
	 */
	@Override
	public void addSalesHistory(Long itemId, SalesHistory salesHistory) {
		String sql = "INSERT INTO SalesHistory(itemId, orderNum, numOfSales, paidPrice)"
				+ " VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, itemId, salesHistory.getOrderNum(), salesHistory.getNumOfSales(), salesHistory.getPaidPrice());
	}
	
	/**
	 * 2. 판매내역 조회
	 */
	//2-1. 판매내역 전체 조회
	@Override
	public List<SalesHistory> findAllSalesHistory() {
		String sql = "SELECT shId, itemId, orderNum, numOfSales, paidPrice, orderDate"
				+ " FROM SalesHistory";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper());
	}
	//2-2. 해당 날짜로 판매내역 조회
	@Override
	public List<SalesHistory> findSalesHistoryByOrderDate(Date orderDate) {
		String sql = "SELECT shId, itemId, orderNum, numOfSales, paidPrice, orderDate"
				+ " FROM SalesHistory WHERE Date(orderDate) = ?";
		//날짜로 검색
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), orderDate);
	}

	//2-3. 해당 메뉴로 판매내역 조회
	@Override
	public List<SalesHistory> findSalesHistoryByItem(Long itemId) {
		String sql = "SELECT shId, itemId, orderNum, numOfSales, paidPrice, orderDate"
				+ " FROM SalesHistory WHERE itemId = ?";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), itemId);
	}
	
	//2-4. 주문번호로 판매내역 조회(Integer orderNum -> Long orderNum)
	public List<SalesHistory> findSalesHistoryByOrderNum(Long orderNum) {
		String sql = "SELECT shId, itemId, orderNum, numOfSales, paidPrice, orderDate"
				+ " FROM SalesHistory WHERE orderNum = ?";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), orderNum); 
	}
	//2-5 월별 판매내역 조회
	public List<SalesHistory> findSalesHistoryByMonth(Date date1, Date date2) {
		String sql = "SELECT shId, itemId, orderNum, numOfSales, paidPrice, orderDate"
				+ " FROM SalesHistory WHERE Date(orderDate)>=? AND Date(orderDate)<?";
		
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), date1, date2);
	}
	//2-6 월별 아이템별 총 수량, 총 지불금액 조회
	@Override
	public List<SalesHistory> sumNumOfSalesAndSumPaidPriceByMonth(Date date1, Date date2) {
		String sql = "SELECT itemId, SUM(numOfSales) AS numOfSales, SUM(paidPrice) AS paidPrice"
				+ " FROM SalesHistory WHERE Date(orderDate)>=? AND Date(orderDate)<?"
				+ " GROUP BY itemId ORDER BY SUM(numOfSales) DESC";
		return jdbcTemplate.query(sql, new RowMapper<SalesHistory>() {

			@Override
			public SalesHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
				Item item = new Item();
				item.setItemId(rs.getLong("itemId"));//mid를 가진 Menu 객체 생성
				SalesHistory salesHistory = new SalesHistory(item, rs.getInt("numOfSales"),
						rs.getInt("paidPrice"));
				return salesHistory;
			}
			
		}, date1, date2);
	}
	
	//2-7. 해당 날짜로 월별 아이템별 총 수량, 총 지불금액 조회
		public List<SalesHistory> sumNumOfSalesAndSumPaidPriceByDate(Date date) {
			String sql = "SELECT itemId, SUM(numOfSales) AS numOfSales, SUM(paidPrice) AS paidPrice"
					+ " FROM SalesHistory WHERE Date(orderDate)=?"
					+ " GROUP BY itemId ORDER BY SUM(numOfSales) DESC";
			return jdbcTemplate.query(sql, new RowMapper<SalesHistory>() {

				@Override
				public SalesHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
					Item item = new Item();
					item.setItemId(rs.getLong("itemId"));//mid를 가진 Menu 객체 생성
					SalesHistory salesHistory = new SalesHistory(item, rs.getInt("numOfSales"),
							rs.getInt("paidPrice"));
					return salesHistory;
				}
				
			}, date);
			
		}
	
	/**
	 * 3. 판매내역 삭제
	 */
	//3-1. 환불
	@Override
	public void deleteSalesHistoryBySHid(Long shid) {
		String sql = "DELETE FROM SalesHistory WHERE shId = ?";
		jdbcTemplate.update(sql, shid);
	}
	//3-2. 해당 메뉴의 판매내역 전체 삭제
	@Override
	public void deleteAllSalesHistories(Long itemId) {
		String sql = "DELETE FROM SalesHistory WHERE itemId = ?";
		jdbcTemplate.update(sql, itemId);
	}
	//3-3. 해당 메뉴의 주문번호로 삭제
	@Override
	public void deleteSalesHistoryByOrderNum(Long orderNum) {
		String sql = "DELETE FROM SalesHistory WHERE orderNum = ?";
		jdbcTemplate.update(sql, orderNum);
	}
	
	/**
	 * 4. 메뉴삭제(판매내역 메뉴 id 변경)
	 */
	public void setItemIdFromSalesHistory(Long itemId, SalesHistory salesHistory) {
		String sql = "UPDATE SalesHistory SET itemId = ? WHERE itemId = ?";
		jdbcTemplate.update(sql, itemId, salesHistory.getItem().getItemId());
	};
	
	/**
	 * 5. 해당 날짜의 판매내역별 수량의 총 수량
	 */
	public Integer sumNumOfSalesByOrderNum(Long orderNum) {
		String sql = "SELECT SUM(numOfSales) AS totalNumOfSales "
				+ " FROM SalesHistory WHERE orderNum = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, orderNum);
	};
	
	/**
	 * 0. 제약조건 변경
	 */
	//에러 발생(후에 고치기)
	//0-1. 제약조건 삭제
	public void disableConstraintFromSH() {
		String sql = "ALTER TABLE SalesHistory DROP CONSTRAINT SalesHistory_itemId_FK";
		jdbcTemplate.update(sql);
	}
	//0-2. 제약조건 추가
	public void enableConstraintFromSH() {
		String sql = "ALTER TABLE SalesHistory ADD CONSTRAINT SalesHistory_itemId_FK FOREIGN KEY(itemId) REFERENCES Item(itemId)";
		jdbcTemplate.update(sql);
	}
}
