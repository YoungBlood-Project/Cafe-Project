package edu.sp5.jvx330.cafe.category.item.salesHistory.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.jvx330.cafe.category.item.domain.Item;
import edu.sp5.jvx330.cafe.category.item.salesHistory.domain.SalesHistory;

public class SalesHistoryMenuRowMapper implements RowMapper<SalesHistory> {

	@Override
	public SalesHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
		Item item = new Item();
		item.setItemId(rs.getLong("itemId"));//mid를 가진 Menu 객체 생성
		
		SalesHistory salesHistory = new SalesHistory(item, rs.getInt("numOfSales"),
				rs.getInt("paidPrice"));
		salesHistory.setShid(rs.getLong("shId"));
		salesHistory.setOrderNum(rs.getLong("orderNum"));
		salesHistory.setOrderDate(rs.getTimestamp("orderDate"));
		
		return salesHistory;
	}
	
}
