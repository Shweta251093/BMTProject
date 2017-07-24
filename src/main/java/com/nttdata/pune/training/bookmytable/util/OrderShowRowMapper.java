package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.HotelTable;

public class OrderShowRowMapper implements RowMapper<HotelTable> {

	@Override
	public HotelTable mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		HotelTable hotelTable = new HotelTable();

		hotelTable.setMenu_id(arg0.getString("menu_id"));

		hotelTable.setQuantity(arg0.getString("quantity"));
		hotelTable.setStatus(arg0.getString("status"));
		return hotelTable;
	}

}
