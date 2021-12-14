package edu.sp5.jvx330.cafe.manager.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.jvx330.cafe.manager.dao.ManagerDao;
import edu.sp5.jvx330.cafe.manager.dao.ManagerRowMapper;
import edu.sp5.jvx330.cafe.manager.domain.Manager;

public class ManagerDaoImpl implements ManagerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//1. 매니저 로그
	@Override
	public Manager managerLogin(Manager manager) {
		String sql = "SELECT managerId, managerName, passwd FROM Manager"
				+ " WHERE managerName = ? AND passwd = ?";
		return jdbcTemplate.queryForObject(sql, new ManagerRowMapper(), manager.getManagerName(), manager.getPasswd());	
	};
	
}
