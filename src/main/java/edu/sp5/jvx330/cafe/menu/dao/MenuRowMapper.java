package edu.sp5.jvx330.cafe.menu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.jvx330.cafe.customer.domain.Customer;
import edu.sp5.jvx330.cafe.menu.domain.Menu;

public class MenuRowMapper implements RowMapper<Menu> {

	@Override
	public Menu mapRow(ResultSet rs, int rowNum) 
			throws SQLException {
		
		Menu menu = new Menu(rs.getString("category"), rs.getString("menuName"),
				rs.getInt("menuPrice"));
		menu.setMid(rs.getLong("mid"));
		
		return menu;
	}
	
}
