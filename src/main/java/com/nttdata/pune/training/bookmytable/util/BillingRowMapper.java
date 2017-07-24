package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.BillGenerator;

public class BillingRowMapper implements RowMapper<BillGenerator> {

	@Override
	public BillGenerator mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		BillGenerator billGenerator = new BillGenerator();
		billGenerator.setTable_id(rs.getInt("TABLE_ID"));
		billGenerator.setFood_name(rs.getString("FOOD_NAME"));
		billGenerator.setRate(rs.getInt("RATE"));
		billGenerator.setQuantity(rs.getInt("quantity"));
		billGenerator.setSub_total(Integer.toString(rs.getInt("subTotal")));
		return billGenerator;
	}

}
