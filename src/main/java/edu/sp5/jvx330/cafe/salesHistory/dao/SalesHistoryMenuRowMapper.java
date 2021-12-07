package edu.sp5.jvx330.cafe.salesHistory.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.jvx330.cafe.menu.domain.Menu;
import edu.sp5.jvx330.cafe.salesHistory.domain.SalesHistory;

public class SalesHistoryMenuRowMapper implements RowMapper<SalesHistory> {

	@Override
	public SalesHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
		Menu menu = new Menu();
		menu.setMid(rs.getLong("menuId"));//mid�� ���� Menu ��ü ����
		
		SalesHistory salesHistory = new SalesHistory(menu, rs.getInt("numOfSales"),
				rs.getInt("paidPrice"));
		salesHistory.setSid(rs.getLong("sid"));
		salesHistory.setOrderNum(rs.getLong("orderNum"));
		salesHistory.setOrderDate(rs.getTimestamp("orderDate"));
		
		return salesHistory;
	}
	
}
