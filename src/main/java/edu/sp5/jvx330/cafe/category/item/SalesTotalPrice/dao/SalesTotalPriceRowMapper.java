package edu.sp5.jvx330.cafe.category.item.SalesTotalPrice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.sp5.jvx330.cafe.category.item.SalesTotalPrice.domain.SalesTotalPrice;

public class SalesTotalPriceRowMapper implements RowMapper<SalesTotalPrice> {

	@Override
	public SalesTotalPrice mapRow(ResultSet rs, int rowNum) throws SQLException {
		SalesTotalPrice stp = new SalesTotalPrice();
		
		stp.setStpId(rs.getLong("stpId"));
		stp.setOrderNum(rs.getLong("orderNum"));
		stp.setTotalPrice(rs.getInt("totalPrice"));
		stp.setReducePrice(rs.getInt("reducedPrice"));
		stp.setOrderDate(rs.getTimestamp("orderDate"));
		
		return stp;
	}

}
