package com.nttdata.pune.training.bookmytable.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nttdata.pune.training.bookmytable.model.beans.Bookings;
import com.nttdata.pune.training.bookmytable.repository.BookingsDAO;
import com.nttdata.pune.training.bookmytable.util.BookingsRowMapper;

@Repository
public class BookingsDAOImpl implements BookingsDAO {

	@Autowired
	private JdbcTemplate dbTemplate;
	
	@Override

	public int insert(Bookings bookings) {

		// TODO Auto-generated method stub
		int updatetable = dbTemplate.update("insert into bookings( user_id ,booking_id  ) values(?,?)", new Object[]{bookings.getUser_id(),bookings.getBooking_id()});
		return updatetable;

	}

	@Override
	public void delete(Bookings bookings) {
		// TODO Auto-generated method stub
		dbTemplate.update("DELETE FROM bookings where bookings.user_id=? and bookings.booking_id=?",new Object[]{bookings.getUser_id(),bookings.getBooking_id()});
	}

	@Override
	public List<Bookings> displayBookings() {
		// TODO Auto-generated method stub
		List<Bookings> listOfBookings=dbTemplate.query("select user_id ,booking_id from bookings",new BookingsRowMapper());
		return listOfBookings;
	}



}
