package edu.sp5.jvx330.cafe.customer.mileageHistory.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileageHistory.dao.MileageHistoryDao;
import edu.sp5.jvx330.cafe.customer.mileageHistory.dao.MileageHistoryRowMapper;
import edu.sp5.jvx330.cafe.customer.mileageHistory.domain.MileageHistory;

public class MileageHistoryDaoImpl implements MileageHistoryDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 수정 - 혜윤
	 * @param customer
	 */

	@Override
	public void addMileageHistory(Long customerId, MileageHistory mileage) {
		String sql = "INSERT INTO MileageHistory(customerId, orderNum, mBalance)"
				+ " VALUES(?, ?, ?)";
		
		jdbcTemplate.update(sql, customerId, mileage.getOrderNum(), mileage.getMBalance());
	}

	@Override

	public List<MileageHistory> findMHByOrderNum(Long orderNum) {
		String sql = "SELECT mileageId, customerId, orderNum, mBalance, regDate FROM MileageHistory"
				+ " WHERE orderNum = ?";
		
		return jdbcTemplate.query(sql, new MileageHistoryRowMapper(), orderNum);
	}
	
	/**
	 * 초원
	 */
	//1. 전체 마일리지 조회
	@Override
	public List<MileageHistory> findMHByUserInfo(Customer customer) {
		String sql = "SELECT mileageId, customerId, orderNum, mBalance, regDate FROM MileageHistory"
				+ " WHERE customerId = ?";
		
		return jdbcTemplate.query(sql, new MileageHistoryRowMapper(), customer.getCid());
	};
	
	//2. 마일리지 금액 수정(마일리지 사용)
	@Override
	public void setMileageHistory(Customer customer, Integer mileage) {
		String sql = "UPDATE MileageHistory SET mBalance = ? WHERE customerId = ?";
		
		jdbcTemplate.update(sql, mileage, customer.getCid());
	};
	
	//3. 마일리지 삭제
	@Override
	public void deleteMileageHistory(Customer customer) {
		String sql = "DELETE FROM MileageHistory WHERE customerId = ?";
		
		jdbcTemplate.update(sql, customer.getCid());
	}

}

