package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.BookedSeats;

public class BookedSeatsRowMapper implements RowMapper<BookedSeats> {

	@Override
	public BookedSeats mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		BookedSeats bookedSeats=new BookedSeats();
		bookedSeats.setBooking_id(arg0.getString("booking_id"));
		bookedSeats.setHotel_id(arg0.getString("hotel_id"));
		bookedSeats.setNo_of_seats(arg0.getInt("no_of_seats"));
		bookedSeats.setBooking_date(arg0.getString("extract(YEAR from booking_date_time)||'-'||EXTRACT(Month FROM booking_date_time)||'-' ||EXTRACT(DAY FROM booking_date_time)"));
		bookedSeats.setBooking_time(arg0.getString("extract(HOUR from booking_date_time)||':'||EXTRACT(MINUTE FROM booking_date_time)||':'||EXTRACT(SECOND FROM booking_date_time)"));
		return bookedSeats;
	}

}
