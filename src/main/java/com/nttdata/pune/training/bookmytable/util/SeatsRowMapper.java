package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.Seats;

public class SeatsRowMapper implements RowMapper<Seats> {

	@Override
	public Seats mapRow(ResultSet rs, int a) throws SQLException {
		// TODO Auto-generated method stub
		Seats seats=new Seats();
		//seats.setHotel_id(rs.getString("hotel_id"));
		seats.setNo_of_seats(rs.getInt("no_of_seats"));
		//seats.setBooking_date(rs.getString("extract(YEAR from booking_date_time)||'-'||EXTRACT(Month FROM booking_date_time)||'-' ||EXTRACT(DAY FROM booking_date_time)"));
		//seats.setBooking_time(rs.getString("extract(HOUR from booking_date_time)||':'||EXTRACT(MINUTE FROM booking_date_time)||':'||EXTRACT(SECOND FROM booking_date_time"));
		seats.setBooking_date(rs.getString("booking_date"));
		seats.setBooking_time(rs.getString("booking_time"));
		return seats;
	}

}
