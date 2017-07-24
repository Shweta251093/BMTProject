package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.HotelAdmin;

public class HotelAdminRowMapper implements RowMapper<HotelAdmin>{
	
	@Override
	public HotelAdmin mapRow(ResultSet rs, int a) throws SQLException {

		HotelAdmin hotelAdmin=new HotelAdmin();
		hotelAdmin.setHotel_id(rs.getString("hotel_id"));
		hotelAdmin.setHotel_name(rs.getString("hotel_name"));
		hotelAdmin.setLocation(rs.getString("location"));
		hotelAdmin.setContact_no(rs.getString("contact_no"));
		hotelAdmin.setPassword(rs.getString("password"));	
		return hotelAdmin;
	}
}
