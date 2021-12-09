package edu.sp5.jvx330.cafe.customer.mileage.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.customer.mileage.dao.MileageDao;
import edu.sp5.jvx330.cafe.customer.mileage.dao.MileageRowMapper;
import edu.sp5.jvx330.cafe.customer.mileage.domain.Mileage;

public class MileageDaoImpl implements MileageDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//1. Mileage �߰�
	public void insertMileage(Long customerId, Integer init_mileage) {
		String sql = "INSERT INTO Mileage(customerId, mTotal)"
				+ " VALUES(?,?)";
		jdbcTemplate.update(sql, customerId, init_mileage);
	}
	
	//2. Mileage ����
	@Override
	public void setMileage(Long customerId, Integer mTotal) {
		String sql = "UPDATE Mileage SET mTotal = ? WHERE customerId = ?";
		
		jdbcTemplate.update(sql, mTotal, customerId);
	}

	//3. Mileage ��ȸ
	/**
	 * ���� - ������
	 * 
	 *  SELECT tmid, customerId, mileageTotal FROM TotalMileage WHERE customerId = ?
	 *  -> SELECT mid, customerId, mTotal FROM Mileage ";
	 */
	@Override
	public Integer findMileage(Long customerId) {
		String sql = "SELECT mId, customerId, mTotal FROM Mileage WHERE customerId = ?";

		try {
			Mileage mileage = jdbcTemplate.queryForObject(sql, new MileageRowMapper(), customerId);
			return mileage.getMTotal();
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	//4. Mileage ����
	@Override
	public void deleteMileage(Long customerId) {
		String sql = "DELETE FROM Mileage WHERE customerId = ?";
		jdbcTemplate.update(sql, customerId);
	}
	
}
