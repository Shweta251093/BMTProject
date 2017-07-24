package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.Bookings;

public class BookingsRowMapper implements RowMapper<Bookings> {

	@Override
	public Bookings mapRow(ResultSet rs, int arg) throws SQLException {
		// TODO Auto-generated method stub
		Bookings bookings=new Bookings();
		bookings.setUser_id(rs.getString("user_id"));
		bookings.setBooking_id(rs.getString("booking_id"));
		return bookings;
	}

}
