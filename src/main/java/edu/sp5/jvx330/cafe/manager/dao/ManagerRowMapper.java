package edu.sp5.jvx330.cafe.manager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.jvx330.cafe.manager.domain.Manager;

public class ManagerRowMapper implements RowMapper<Manager> {
	@Override
	public Manager mapRow(ResultSet rs, int rowNum) throws SQLException {
		Manager Manager = new Manager(rs.getString("managerName"), rs.getString("passwd"));
		Manager.setManagerId(rs.getLong("managerId"));
		
		return Manager;
	}
}
