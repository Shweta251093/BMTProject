package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nttdata.pune.training.bookmytable.model.beans.Seats;

public class SeatsHotelRowMapper implements ResultSetExtractor<Seats> {

	
	Seats seats=new Seats();

	@Override
	public Seats extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		// TODO Auto-generated method stub
		seats.setNo_of_seats(rs.getInt("seats"));
		seats.setBooking_date(rs.getString("date"));
		seats.setBooking_time(rs.getString("time"));
		return seats;
	}
	
	}
