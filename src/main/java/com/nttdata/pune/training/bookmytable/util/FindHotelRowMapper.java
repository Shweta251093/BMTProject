package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.HotelAdminSeats;

public class FindHotelRowMapper implements RowMapper<HotelAdminSeats> {

	@Override
	public HotelAdminSeats mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
HotelAdminSeats hotelAdmin=new HotelAdminSeats();

hotelAdmin.setHotel_id(rs.getString("HOTEL_ID"));
		hotelAdmin.setHotel_name(rs.getString("HOTEL_NAME"));
		hotelAdmin.setLocation(rs.getString("LOCATION"));
		hotelAdmin.setContact_no(rs.getString("CONTACT_NO"));
		hotelAdmin.setNo_of_seats(rs.getInt("NO_OF_SEATS"));
		hotelAdmin.setBooking_date(rs.getString("Booking_date"));
		hotelAdmin.setBooking_time(rs.getString("Booking_time"));
		return (hotelAdmin);
	}
}
