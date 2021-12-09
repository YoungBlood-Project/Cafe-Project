package edu.sp5.jvx330.cafe.customer.mileage.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileage.dao.MileageDao;
import edu.sp5.jvx330.cafe.customer.mileage.dao.MileageRowMapper;
import edu.sp5.jvx330.cafe.customer.mileage.domain.Mileage;



public class MileageDaoImpl implements MileageDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 수정 - 혜윤
	 * @param customer
	 */

	@Override
	public void addMileage(Long customerId, Mileage mileage) {
		String sql = "INSERT INTO Mileage(customerId, orderNum, mBalance)"
				+ " VALUES(?, ?, ?)";
		
		jdbcTemplate.update(sql, customerId, mileage.getOrderNum(), mileage.getMBalance());
	}

	@Override
	public List<Mileage> findMileageByOrderNum(Long orderNum) {
		String sql = "SELECT mileageId, customerId, orderNum, mBalance, regDate FROM Mileage"
				+ " WHERE orderNum = ?";
		
		return jdbcTemplate.query(sql, new MileageRowMapper(), orderNum);
	}
	
	/**
	 * 초원
	 */
	//1. 전체 마일리지 조회
	@Override
	public List<Mileage> findMileageByUserInfo(Customer customer) {
		String sql = "SELECT mileageId, customerId, orderNum, mBalance, regDate FROM Mileage"
				+ " WHERE customerId = ?";
		
		return jdbcTemplate.query(sql, new MileageRowMapper(), customer.getCid());
	};
	
	//2. 마일리지 금액 수정(마일리지 사용)
	@Override
	public void setMileage(Customer customer, Integer mileage) {
		String sql = "UPDATE Mileage SET mBalance = ? WHERE customerId = ?";
		
		jdbcTemplate.update(sql, mileage, customer.getCid());
	};
	
	//3. 마일리지 삭제
	@Override
	public void deleteMileage(Customer customer) {
		String sql = "DELETE FROM Mileage WHERE customerId = ?";
		
		jdbcTemplate.update(sql, customer.getCid());
	}

}

