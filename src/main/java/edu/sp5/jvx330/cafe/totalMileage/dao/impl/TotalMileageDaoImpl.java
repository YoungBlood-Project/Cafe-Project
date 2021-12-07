package edu.sp5.jvx330.cafe.totalMileage.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.totalMileage.dao.TotalMileageDao;
import edu.sp5.jvx330.cafe.totalMileage.dao.TotalMileageRowMapper;
import edu.sp5.jvx330.cafe.totalMileage.domain.TotalMileage;

public class TotalMileageDaoImpl implements TotalMileageDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//1. Total Mileage �߰�
	public void addTotalMileage(Long customerId, Integer init_mileage) {
		String sql = "INSERT INTO TotalMileage(customerId, mileageTotal)"
				+ " VALUES(?,?)";
		jdbcTemplate.update(sql, customerId, init_mileage);
	}
	
	//2. Total Mileage ����
	@Override
	public void setTotalMileage(Long customerId, Integer mileageTotal) {
		String sql = "UPDATE TotalMileage SET mileageTotal = ? WHERE customerId = ?";
		
		jdbcTemplate.update(sql, mileageTotal, customerId);
	}

	//3. Total Mileage ��ȸ
	@Override
	public Integer findTotalMileage(Long customerId) {
		String sql = "SELECT tmId, customerId, mileageTotal WHERE customerId = ?";
		TotalMileage totalMileage = jdbcTemplate.queryForObject(sql, new TotalMileageRowMapper(), customerId);
		return totalMileage.getMileageTotal();
	}

	//4. Total Mileage ����
	@Override
	public void deleteTotalMileage(Long customerId) {
		String sql = "DELETE FROM TotalMileage WHERE customerId = ?";
		jdbcTemplate.update(sql, customerId);
	}
}
