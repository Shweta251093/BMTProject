package com.nttdata.pune.training.bookmytable.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nttdata.pune.training.bookmytable.model.beans.Seats;
import com.nttdata.pune.training.bookmytable.repository.SeatsDAO;
import com.nttdata.pune.training.bookmytable.util.SeatsRowMapper;
import com.nttdata.pune.training.bookmytable.util.TimeSlotsRowMapper;

@Repository
public class SeatsDAOImpl implements SeatsDAO {

	@Autowired
	private JdbcTemplate dbTemplate;

	@Override
	public void insert(Seats seats) {
		// TODO Auto-generated method stub
		dbTemplate
				.update("insert into seats(hotel_id,no_of_seats,booking_date_time) values(?,?,?)",
						new Object[] {
								seats.getHotel_id(),
								seats.getNo_of_seats(),
								seats.getBooking_date() + " "
										+ seats.getBooking_time() });
	}

	@Override
	public int update(Seats seats) {
		// TODO Auto-generated method stub
		int updateSeats = dbTemplate
				.update("update seats set no_of_seats=? where hotel_id=? and to_char(booking_date_time,'HH24:MI')=? and to_char(booking_date_time,'YYYY-MM-DD')=?",
						new Object[] { seats.getNo_of_seats(),
								seats.getHotel_id(), seats.getBooking_time(),
								seats.getBooking_date() });
		return updateSeats;
	}

	@Override
	public int updateHotelSeats(Seats seats) {
		// UPdate seats as per time slot
		System.err.println("Before seats update query");
		int seatUpdate = dbTemplate
				.update("update seats set no_of_seats=? where hotel_id=? and to_char(booking_date_time,'DD-MM-YYYY')=? and to_char(booking_date_time,'HH24:MI:SS')=? ",
						new Object[] { seats.getNo_of_seats(),
								seats.getHotel_id(), seats.getBooking_date(),
								seats.getBooking_time(), });
		System.err.println("After seats update query");
		return seatUpdate;
	}

	@Override
	public List<Seats> displayAllSeats(String hotelId) {
		// TODO Auto-generated method stub

		System.out.println("Before seats query");

		List<Seats> listOfSeats = dbTemplate
				.query("select no_of_seats,to_char(booking_date_time,'HH24:MI:SS') as booking_time,to_char(booking_date_time,'DD-MM-YYYY') as booking_date  from seats where hotel_id=?",
						new SeatsRowMapper(), new Object[] { hotelId });
		System.out.println("Seats" + listOfSeats);

		System.out.println("Seats" + listOfSeats);

		return listOfSeats;
	}

	@Override
	public List<Seats> displayTimeSlots() {
		System.out.println("helloooo");
		List<Seats> timeSlots = dbTemplate.query("select sysdate from dual",
				new TimeSlotsRowMapper());
		return timeSlots;

	}

	/*
	 * @Override public List<Seats> displayAllSeats(Seats seats) {
	 * System.out.println(seats.getBooking_date()); List<Seats> listOfSeats =
	 * dbTemplate .query(
	 * "select hotel_id,no_of_seats,to_char(booking_date_time,'HH24:MI:SS') as booking_time,to_char(booking_date_time,'DD-MM-YYYY') as booking_date  from seats where booking_date_time='?'"
	 * , new Object[] { seats.getBooking_date() }, new SeatsRowMapper());
	 * 
	 * return listOfSeats; }
	 */
	@Override
	public int registerSeats(Seats seats) {

		// Register the seats for first time
		int status = 0;

		status = dbTemplate
				.update("insert into seats(hotel_id,no_of_seats,booking_date_time) values(?,?,?)",
						new Object[] {
								seats.getHotel_id(),
								seats.getNo_of_seats(),
								seats.getBooking_date() + " "
										+ seats.getBooking_time() });

		return status;
	}

	@Override
	public void delete() {

		// delete not required records i.e previous records from seats table

		dbTemplate
				.update("delete from seats where booking_date_time<cast(sysdate as timestamp)");

	}

	@Override
	public void updateSeatsByTime(String hotel_id, String date, String time,
			String newseats) {
		// TODO Auto-generated method stub

		dbTemplate
				.update("update seats set no_of_seats=? where hotel_id=? and to_char(booking_date_time,'YYYY-MM-DD')=? and to_char(booking_date_time,'HH24:MI:SS')=? ",
						new Object[] { newseats, hotel_id, date, time });

	}

}
