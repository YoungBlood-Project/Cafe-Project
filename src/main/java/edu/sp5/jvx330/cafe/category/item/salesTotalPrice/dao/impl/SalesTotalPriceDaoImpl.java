package edu.sp5.jvx330.cafe.category.item.salesTotalPrice.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.category.item.salesHistory.dao.SalesHistoryMenuRowMapper;
import edu.sp5.jvx330.cafe.category.item.salesTotalPrice.dao.SalesTotalPriceDao;
import edu.sp5.jvx330.cafe.category.item.salesTotalPrice.dao.SalesTotalPriceRowMapper;
import edu.sp5.jvx330.cafe.category.item.salesTotalPrice.domain.SalesTotalPrice;

public class SalesTotalPriceDaoImpl implements SalesTotalPriceDao  {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 1. 총판매가격 저장
	@Override
	public void saveSalesTotalPrice(SalesTotalPrice salesTotalPrice) {
		String sql ="INSERT INTO SalesTotalPrice(orderNum, totalPrice, reducedPrice)"
				+ " VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, salesTotalPrice.getOrderNum(), salesTotalPrice.getTotalPrice(), salesTotalPrice.getReducePrice());
	}

	/**
	 * 총판매가격 내역 조회
	 */
	// 2-1. 총판매가격 내역 전체 조회
	@Override
	public List<SalesTotalPrice> findAllSalesTotalPrice() {
		String sql = "SELECT stpId, orderNum, totalPrice, reducedPrice, orderDate"
				+ " FROM SalesTotalPrice";
		return jdbcTemplate.query(sql, new SalesTotalPriceRowMapper());
	}

	// 2-2. 총판매가격 내역 주문번호로 조회
	@Override
	public List<SalesTotalPrice> findSTPByOrderNum(Long orderNum) {
		String sql = "SELECT stpId, orderNum, totalPrice, reducedPrice, orderDate"
				+ " FROM SalesTotalPrice WHERE orderNum = ?";
		return jdbcTemplate.query(sql, new SalesTotalPriceRowMapper(), orderNum);
	}


	// 3. 총판매가격 내역 기록 삭제 - 환불 시 사용
	@Override
	public void deleteSalesTotalPrice(Long orderNum) {
		String sql = "DELETE FROM SalesTotalPrice WHERE orderNum = ?";
		jdbcTemplate.update(sql, orderNum);
	}

}