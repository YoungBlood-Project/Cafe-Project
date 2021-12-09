package edu.sp5.jvx330.cafe.customer.mileageHistory.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.customer.mileageHistory.dao.MileageDao;
import edu.sp5.jvx330.cafe.customer.mileageHistory.dao.MileageRowMapper;
import edu.sp5.jvx330.cafe.customer.mileageHistory.domain.MileageHistory;

public class MileageDaoImpl implements MileageDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * ���� - ����
	 * @param customer
	 */

	@Override
	public void addMileage(Long customerId, MileageHistory mileage) {
		String sql = "INSERT INTO Mileage(customerId, orderNum, mBalance)"
				+ " VALUES(?, ?, ?)";
		
		jdbcTemplate.update(sql, customerId, mileage.getOrderNum(), mileage.getMBalance());
	}

	@Override
	public List<MileageHistory> findMileageByOrderNum(Long orderNum) {
		String sql = "SELECT mileageId, customerId, orderNum, mBalance, regDate FROM Mileage"
				+ " WHERE orderNum = ?";
		
		return jdbcTemplate.query(sql, new MileageRowMapper(), orderNum);
	}
	
	/**
	 * �ʿ�
	 */
	//1. ��ü ���ϸ��� ��ȸ
	@Override
	public List<MileageHistory> findMileageByUserInfo(Customer customer) {
		String sql = "SELECT mileageId, customerId, orderNum, mBalance, regDate FROM Mileage"
				+ " WHERE customerId = ?";
		
		return jdbcTemplate.query(sql, new MileageRowMapper(), customer.getCid());
	};
	
	//2. ���ϸ��� �ݾ� ����(���ϸ��� ���)
	@Override
	public void setMileage(Customer customer, Integer mileage) {
		String sql = "UPDATE Mileage SET mBalance = ? WHERE customerId = ?";
		
		jdbcTemplate.update(sql, mileage, customer.getCid());
	};
	
	//3. ���ϸ��� ����
	@Override
	public void deleteMileage(Customer customer) {
		String sql = "DELETE FROM Mileage WHERE customerId = ?";
		
		jdbcTemplate.update(sql, customer.getCid());
	}

}

