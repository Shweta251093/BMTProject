package com.nttdata.pune.training.bookmytable.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nttdata.pune.training.bookmytable.model.beans.BookedSeats;
import com.nttdata.pune.training.bookmytable.repository.BookedSeatsDAO;
import com.nttdata.pune.training.bookmytable.util.BookedSeatsRowMapper;
@Repository
public class BookedSeatsDAOImpl implements BookedSeatsDAO {

	@Autowired
	private JdbcTemplate dbTemplate;
	
	@Override
	public int insert(BookedSeats bookedSeats) {
		// TODO Auto-generated method stub
		int bookedseats = dbTemplate.update("insert into booked_seats(booking_id,hotel_id,no_of_seats,booking_date_time) values(?,?,?,?)",  new Object[]{bookedSeats.getBooking_id(),bookedSeats.getHotel_id(),bookedSeats.getNo_of_seats(),bookedSeats.getBooking_date()+" "+bookedSeats.getBooking_time()});
		return bookedseats;
		
	}

	@Override
	public void delete(BookedSeats bookedSeats) {
		// TODO Auto-generated method stub
		dbTemplate.update("delete from booked_seats where booking_id=? and hotel_id=?",new Object[]{bookedSeats.getBooking_id(),bookedSeats.getHotel_id()});
	}

	@Override
	public List<BookedSeats> displayAllBookedSeats() {
		// TODO Auto-generated method stub
		List<BookedSeats> listOfBookedSeats=dbTemplate.query("select booking_id,hotel_id,no_of_seats,(extract(YEAR from booking_date_time)||'-'||EXTRACT(Month FROM booking_date_time)||'-' ||EXTRACT(DAY FROM booking_date_time)),(extract(HOUR from booking_date_time)||':'||EXTRACT(MINUTE FROM booking_date_time)||':'||EXTRACT(SECOND FROM booking_date_time)) from booked_seats", new BookedSeatsRowMapper());
		return listOfBookedSeats;
	}


}
