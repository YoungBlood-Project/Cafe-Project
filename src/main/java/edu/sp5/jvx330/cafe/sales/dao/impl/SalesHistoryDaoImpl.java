package edu.sp5.jvx330.cafe.sales.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.sales.dao.SalesHistoryDao;
import edu.sp5.jvx330.cafe.sales.dao.SalesHistoryMenuRowMapper;
import edu.sp5.jvx330.cafe.sales.dao.SalesTotalPriceRowMapper;
import edu.sp5.jvx330.cafe.sales.domain.SalesHistory;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

public class SalesHistoryDaoImpl implements SalesHistoryDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * 1. �Ǹų��� �߰�(�޴� id, �Ǹų���)
	 */
	@Override
	public void addSalesHistory(Long itemId, SalesHistory salesHistory) {
		String sql = "INSERT INTO SalesHistory(itemId, orderNum, numOfSales, paidPrice)"
				+ " VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, itemId, salesHistory.getOrderNum(), salesHistory.getNumOfSales(), salesHistory.getPaidPrice());
	}
	
	/**
	 * 2. �Ǹų��� ��ȸ
	 */
	//2-1. �Ǹų��� ��ü ��ȸ
	@Override
	public List<SalesHistory> findAllSalesHistory() {
		String sql = "SELECT shId, itemId, orderNum, numOfSales, paidPrice, orderDate"
				+ " FROM SalesHistory";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper());
	}
	//2-2. �ش� ��¥�� �Ǹų��� ��ȸ
	@Override
	public List<SalesHistory> findSalesHistoryByOrderDate(Date orderDate) {
		String sql = "SELECT shId, itemId, orderNum, numOfSales, paidPrice, orderDate"
				+ " FROM SalesHistory WHERE Date(orderDate) = ?";
		//��¥�� �˻�
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), orderDate);
	}

	//2-3. �ش� �޴��� �Ǹų��� ��ȸ
	@Override
	public List<SalesHistory> findSalesHistoryByItem(Long itemId) {
		String sql = "SELECT shId, itemId, orderNum, numOfSales, paidPrice, orderDate"
				+ " FROM SalesHistory WHERE itemId = ?";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), itemId);
	}
	
	//2-4. �ֹ���ȣ�� �Ǹų��� ��ȸ(Integer orderNum -> Long orderNum)
	public List<SalesHistory> findSalesHistoryByOrderNum(Long orderNum) {
		String sql = "SELECT shId, itemId, orderNum, numOfSales, paidPrice, orderDate"
				+ " FROM SalesHistory WHERE orderNum = ?";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), orderNum); 
	}
	//2-5 ���� �Ǹų��� ��ȸ
	public List<SalesHistory> findSalesHistoryByMonth(Date date1, Date date2) {
		String sql = "SELECT shId, itemId, orderNum, numOfSales, paidPrice, orderDate"
				+ " FROM SalesHistory WHERE Date(orderDate)>=? AND Date(orderDate)<?";
		
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), date1, date2);
	}
	//2-6 ���� �����ۺ� �� ����, �� ���ұݾ� ��ȸ
	@Override
	public List<SalesHistory> sumSalesHistoryByMonth(Date date1, Date date2) {
		String sql = "SELECT itemId, SUM(numOfSales), SUM(paidPrice) "
				+ " FROM SalesHistory WHERE Date(orderDate)>=? AND Date(orderDate)<?";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), date1, date2);
	}
	
	//2-7 ���� �����ۺ� �� ���� ��ȸ
	@Override
	public List<SalesHistory> sumNumOfSalesByMonth(Date date1, Date date2) {
		String sql = "SELECT itemId, SUM(numOfSales)"
				+ " FROM SalesHistory WHERE Date(orderDate)>=? AND Date(orderDate)<?";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), date1, date2);
	}
		
	//2-8 ���� �����ۺ� �� ���ұݾ� ��ȸ
	@Override
	public List<SalesHistory> sumPaidPriceByMonth(Date date1, Date date2) {
		String sql = "SELECT itemId, SUM(paidPrice)"
				+ " FROM SalesHistory WHERE Date(orderDate)>=? AND Date(orderDate)<?";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), date1, date2);
	}
	
	//2 test ���� �����ۺ� �� ����, �� ���ұݾ� ��ȸ
	@Override
	public List<SalesHistory> sumNumOfSalesAndSumPaidPriceByMonth(Date date1, Date date2) {
		String sql = "SELECT itemId, SUM(numOfSales), SUM(paidPrice)"
				+ " FROM SalesHistory WHERE Date(orderDate)>=? AND Date(orderDate)<?";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), date1, date2);
	}
		
	
	/**
	 * 3. �Ǹų��� ����
	 */
	//3-1. ȯ��
	@Override
	public void deleteSalesHistoryBySHid(Long shid) {
		String sql = "DELETE FROM SalesHistory WHERE shId = ?";
		jdbcTemplate.update(sql, shid);
	}
	//3-2. �ش� �޴��� �Ǹų��� ��ü ����
	@Override
	public void deleteAllSalesHistories(Long itemId) {
		String sql = "DELETE FROM SalesHistory WHERE itemId = ?";
		jdbcTemplate.update(sql, itemId);
	}
	
	/**
	 * 4. �޴�����(�Ǹų��� �޴� id ����)
	 */
	public void setItemIdFromSalesHistory(Long itemId, SalesHistory salesHistory) {
		String sql = "UPDATE SalesHistory SET itemId = ? WHERE itemId = ?";
		jdbcTemplate.update(sql, itemId, salesHistory.getItem().getItemId());
	};
	
	/**
	 * 5. �ش� ��¥�� �Ǹų����� ������ �� ����
	 */
	public Integer sumNumOfSalesByOrderNum(Long orderNum) {
		String sql = "SELECT SUM(numOfSales) AS totalNumOfSales "
				+ " FROM SalesHistory WHERE orderNum = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, orderNum);
	};
	
	/**
	 * 0. �������� ����
	 */
	//���� �߻�(�Ŀ� ��ġ��)
	//0-1. �������� ����
	public void disableConstraintFromSH() {
		String sql = "ALTER TABLE SalesHistory DROP CONSTRAINT SalesHistory_itemId_FK";
		jdbcTemplate.update(sql);
	}
	//0-2. �������� �߰�
	public void enableConstraintFromSH() {
		String sql = "ALTER TABLE SalesHistory ADD CONSTRAINT SalesHistory_itemId_FK FOREIGN KEY(itemId) REFERENCES Item(itemId)";
		jdbcTemplate.update(sql);
	}
}
