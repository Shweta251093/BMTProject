package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.AdminSearchResults;

public class GetBookingDetailsRowMapper implements RowMapper<AdminSearchResults> {

	@Override
	public AdminSearchResults mapRow(ResultSet rs, int a) throws SQLException {

		AdminSearchResults adminSearchResults = new AdminSearchResults();

		adminSearchResults.setUser_id(rs.getString("user_id"));
		adminSearchResults.setBooking_id(rs.getString("booking_id"));
		adminSearchResults.setFull_name(rs.getString("full_name"));
		adminSearchResults.setBooking_date(rs.getString("booking_date"));
		adminSearchResults.setBooking_time(rs.getString("booking_time"));
		adminSearchResults.setNo_of_seats(rs.getString("no_of_seats"));
		adminSearchResults.setContact_no(rs.getString("contact_no"));
		return adminSearchResults;

	}

}
