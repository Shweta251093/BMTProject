package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.BillGenerator;

public class DiscountRowMapper implements RowMapper<BillGenerator> {

	@Override
	public BillGenerator mapRow(ResultSet rs, int arg1) throws SQLException {
		BillGenerator billGenerator = new BillGenerator();
		billGenerator.setOffer_id(rs.getString("offer_id"));
		billGenerator.setTable_id(rs.getInt("TABLE_ID"));
		billGenerator.setFood_name(rs.getString("FOOD_NAME"));
		billGenerator.setRate(rs.getInt("RATE"));
		billGenerator.setQuantity(rs.getInt("quantity"));
		billGenerator.setDiscount(rs.getString("discount"));
		billGenerator.setDiscountAmount(Integer.toString(rs.getInt("discountAmount")));
		return billGenerator;
	}

}
