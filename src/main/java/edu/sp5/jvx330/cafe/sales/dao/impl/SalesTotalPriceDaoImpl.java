package edu.sp5.jvx330.cafe.sales.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.sales.dao.SalesHistoryMenuRowMapper;
import edu.sp5.jvx330.cafe.sales.dao.SalesTotalPriceDao;
import edu.sp5.jvx330.cafe.sales.dao.SalesTotalPriceRowMapper;
import edu.sp5.jvx330.cafe.sales.domain.SalesTotalPrice;

public class SalesTotalPriceDaoImpl implements SalesTotalPriceDao  {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 1. ���ǸŰ��� ����
	@Override
	public void saveSalesTotalPrice(SalesTotalPrice salesTotalPrice) {
		String sql ="INSERT INTO SalesTotalPrice(orderNum, totalPrice, reducedPrice)"
				+ " VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, salesTotalPrice.getOrderNum(), salesTotalPrice.getTotalPrice(), salesTotalPrice.getReducedPrice());
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
	public SalesTotalPrice findSTPByOrderNum(Long orderNum) {
		String sql = "SELECT stpId, orderNum, totalPrice, reducedPrice, orderDate"
				+ " FROM SalesTotalPrice WHERE orderNum = ?";
		return jdbcTemplate.queryForObject(sql, new SalesTotalPriceRowMapper(), orderNum);
	}
	
	// 2-4 ���ǸŰ��� ���� ��ȸ
	@Override
	public List<SalesTotalPrice> findSalesTotalPriceByMonth(Date date1, Date date2) {
		String sql = "SELECT stpId, orderNum, totalPrice, reducedPrice, orderDate"
				+ " FROM SalesTotalPrice WHERE Date(orderDate)>=? AND Date(orderDate)<?";
		return jdbcTemplate.query(sql, new SalesTotalPriceRowMapper(), date1, date2);
	};
	
	// 3. ���ǸŰ��� ���� ��� ���� - ȯ�� �� ���
	@Override
	public void deleteSalesTotalPrice(Long orderNum) {
		String sql = "DELETE FROM SalesTotalPrice WHERE orderNum = ?";
		jdbcTemplate.update(sql, orderNum);
	}

}