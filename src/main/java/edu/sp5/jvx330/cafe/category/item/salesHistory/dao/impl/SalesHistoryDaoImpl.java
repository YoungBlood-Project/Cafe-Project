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
	 * 1. �Ǹų��� �߰�(�޴� id, �Ǹų���)
	 */
	@Override
	public void addSalesHistory(Long menuId, SalesHistory salesHistory) {
		String sql = "INSERT INTO SalesHistory(menuId, orderNum, numOfSales, paidPrice)"
				+ " VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, menuId, salesHistory.getOrderNum(), salesHistory.getNumOfSales(), salesHistory.getPaidPrice());
	}
	
	/**
	 * 2. �Ǹų��� ��ȸ
	 */
	//2-1. �Ǹų��� ��ü ��ȸ
	@Override
	public List<SalesHistory> findAllSalesHistory() {
		String sql = "SELECT sid, menuId, numOfSales, orderNum, paidPrice, orderDate"
				+ " FROM SalesHistory";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper());
	}
	//2-2. �ش� ��¥�� �Ǹų��� ��ȸ
	@Override
	public List<SalesHistory> findSalesHistoryByOrderDate(Date orderDate) {
		String sql = "SELECT sid, menuId, numOfSales, orderNum, paidPrice, orderDate"
				+ " FROM SalesHistory WHERE Date(orderDate) = ?";
		//��¥�� �˻�
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), orderDate);
	}

	//2-3. �ش� �޴��� �Ǹų��� ��ȸ
	@Override
	public List<SalesHistory> findSalesHistoryByMenu(Long menuId) {
		String sql = "SELECT sid, menuId, numOfSales, orderNum, paidPrice, orderDate"
				+ " FROM SalesHistory WHERE menuId = ?";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), menuId);
	}
	
	//2-4. �ֹ���ȣ�� �Ǹų��� ��ȸ(Integer orderNum -> Long orderNum)
	public List<SalesHistory> findSalesHistoryByOrderNum(Long orderNum) {
		String sql = "SELECT sid, menuId, numOfSales, orderNum, paidPrice, orderDate"
				+ " FROM SalesHistory WHERE orderNum = ?";
		return jdbcTemplate.query(sql, new SalesHistoryMenuRowMapper(), orderNum);
	}
	
	/**
	 * 3. �Ǹų��� ����
	 */
	//3-1. ȯ��
	@Override
	public void deleteSalesHistoryBySid(Long sid) {
		String sql = "DELETE FROM SalesHistory WHERE sid = ?";
		jdbcTemplate.update(sql, sid);
	}
	//3-2. �ش� �޴��� �Ǹų��� ��ü ����
	@Override
	public void deleteAllSalesHistories(Long menuId) {
		String sql = "DELETE FROM SalesHistory WHERE menuId = ?";
		jdbcTemplate.update(sql, menuId);
	}
	
	/**
	 * 4. �޴�����(�Ǹų��� �޴� id ����)
	 */
	public void setItemIdFromSalesHistory(Long itemId, SalesHistory salesHistory) {
		String sql = "UPDATE SalesHistory SET itemId = ? WHERE itemId = ?";
		jdbcTemplate.update(sql, itemId, salesHistory.getItem().getItemId());
	};
	
	/**
	 * 0. �������� ����
	 */
	//���� �߻�(�Ŀ� ��ġ��)
	//0-1. �������� ����
	public void disableConstraintFromSH() {
		String sql = "ALTER TABLE SalesHistory DROP CONSTRAINT SalesHistory_menuId_FK";
		jdbcTemplate.update(sql);
	}
	//0-2. �������� �߰�
	public void enableConstraintFromSH() {
		String sql = "ALTER TABLE SalesHistory ADD CONSTRAINT SalesHistory_menuId_FK FOREIGN KEY(menuId) REFERENCES Menu(mid)";
		jdbcTemplate.update(sql);
	}
}
