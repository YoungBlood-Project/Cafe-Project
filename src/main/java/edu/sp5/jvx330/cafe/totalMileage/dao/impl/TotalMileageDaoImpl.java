package edu.sp5.jvx330.cafe.totalMileage.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.totalMileage.dao.TotalMileageDao;
import edu.sp5.jvx330.cafe.totalMileage.dao.TotalMileageRowMapper;
import edu.sp5.jvx330.cafe.totalMileage.domain.TotalMileage;

public class TotalMileageDaoImpl implements TotalMileageDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//1. Total Mileage 추가
	public void addTotalMileage(Long customerId, Integer init_mileage) {
		String sql = "INSERT INTO TotalMileage(customerId, mileageTotal)"
				+ " VALUES(?,?)";
		jdbcTemplate.update(sql, customerId, init_mileage);
	}
	
	//2. Total Mileage 변경
	@Override
	public void setTotalMileage(Long customerId, Integer mileageTotal) {
		String sql = "UPDATE TotalMileage SET mileageTotal = ? WHERE customerId = ?";
		
		jdbcTemplate.update(sql, mileageTotal, customerId);
	}

	//3. Total Mileage 조회
	/**
	 * 수정 - 정혜윤
	 * SELECT tmid, customerId, mileageTotal WHERE customerId = ?
	 * -> SELECE tmid, customerId, mileageTotal FROM TotalMileage WHERE customerId = ?
	 */
	@Override
	public Integer findTotalMileage(Long customerId) {
		String sql = "SELECT tmId, customerId, mileageTotal FROM TotalMileage WHERE customerId = ?";
		TotalMileage totalMileage = jdbcTemplate.queryForObject(sql, new TotalMileageRowMapper(), customerId);
		return totalMileage.getMileageTotal();
	}

	//4. Total Mileage 삭제
	@Override
	public void deleteTotalMileage(Long customerId) {
		String sql = "DELETE FROM TotalMileage WHERE customerId = ?";
		jdbcTemplate.update(sql, customerId);
	}
	
	/**
	 * 0. 제약조건 변경 - 정혜윤.
	 */
	//0-1. 제약조건 삭제
	public void disableConstraintFromSH() {
		String sql = "ALTER TABLE TotalMileage DROP CONSTRAINT TotalMileage_customerId_FK";
		jdbcTemplate.update(sql);
	}
	//0-2. 제약조건 추가
	public void enableConstraintFromSH() {
		String sql = "ALTER TABLE TotalMileage ADD CONSTRAINT TotalMileage_customerId_FK FOREIGN KEY(menuId) REFERENCES Menu(mid)";
		jdbcTemplate.update(sql);
	}
}
