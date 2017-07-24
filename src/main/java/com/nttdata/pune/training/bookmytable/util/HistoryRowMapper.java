package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.History;

public class HistoryRowMapper implements RowMapper<History> {
	// ResultSet is returned & will pass that row to the RowMapper class via the
	// mapRow() method

	@Override
	public History mapRow(ResultSet rs, int a) throws SQLException {
		// sets the parameter to string value
		History history = new History();
		history.setUser_id(rs.getString("user_id"));
		history.setBooking_id(rs.getString("booking_id"));
		history.setFood_name(rs.getString("food_name"));
		history.setHotel_id(rs.getString("hotel_id"));
		history.setQuantity(rs.getString("quantity"));
		history.setRating(rs.getString("rating"));
		history.setReview(rs.getString("review"));
		return history;

	}

}
