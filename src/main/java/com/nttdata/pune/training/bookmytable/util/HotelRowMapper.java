package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class HotelRowMapper implements RowMapper<String> {

	@Override
	public String mapRow(ResultSet rs, int arg1) throws SQLException {
		System.out.println("Inside hotel row mapper");

		String hotelName = rs.getString("hotel_name");

		return hotelName;
	}

}
