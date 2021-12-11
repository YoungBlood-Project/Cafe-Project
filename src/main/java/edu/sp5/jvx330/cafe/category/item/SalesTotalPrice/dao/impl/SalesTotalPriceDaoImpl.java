package edu.sp5.jvx330.cafe.category.item.SalesTotalPrice.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.category.item.SalesTotalPrice.dao.SalesTotalPriceDao;
import edu.sp5.jvx330.cafe.category.item.SalesTotalPrice.dao.SalesTotalPriceRowMapper;
import edu.sp5.jvx330.cafe.category.item.SalesTotalPrice.domain.SalesTotalPrice;
import edu.sp5.jvx330.cafe.category.item.salesHistory.dao.SalesHistoryMenuRowMapper;

public class SalesTotalPriceDaoImpl implements SalesTotalPriceDao  {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 1. ���ǸŰ��� ����
	@Override
	public void saveSalesTotalPrice(SalesTotalPrice salesTotalPrice) {
		String sql ="INSERT INTO SalesTotalPrice(orderNum, totalPrice, reducedPrice)"
				+ " VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, salesTotalPrice.getOrderNum(), salesTotalPrice.getTotalPrice(), salesTotalPrice.getReducePrice());
	}

	/**
	 * ���ǸŰ��� ���� ��ȸ
	 */
	// 2-1. ���ǸŰ��� ���� ��ü ��ȸ
	@Override
	public List<SalesTotalPrice> findAllSalesTotalPrice() {
		String sql = "SELECT stpId, orderNum, totalPrice, reducedPrice, orderDate"
				+ " FROM SalesTotalPrice";
		return jdbcTemplate.query(sql, new SalesTotalPriceRowMapper());
	}
		
	// 2-2. ���ǸŰ��� ���� �ֹ���ȣ�� ��ȸ
	@Override
	public List<SalesTotalPrice> findSTPByOrderNum(Long orderNum) {
		String sql = "SELECT stpId, orderNum, totalPrice, reducedPrice, orderDate"
				+ " FROM SalesTotalPrice WHERE orderNum = ?";
		return jdbcTemplate.query(sql, new SalesTotalPriceRowMapper(), orderNum);
	}

	
	// 3. ���ǸŰ��� ���� ��� ���� - ȯ�� �� ���
	@Override
	public void deleteSalesTotalPrice(Long orderNum) {
		String sql = "DELETE FROM SalesTotalPrice WHERE orderNum = ?";
		jdbcTemplate.update(sql, orderNum);
	}
	
}
