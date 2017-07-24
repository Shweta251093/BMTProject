package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.CheckedIn;

public class GetBookingIdRowMapper implements RowMapper<CheckedIn> {

	@Override
	public CheckedIn mapRow(ResultSet rs, int arg1) throws SQLException {
		CheckedIn checkedIn = new CheckedIn();
		checkedIn.setBooking_id(rs.getString("booking_id"));
		return checkedIn;
	}

}
