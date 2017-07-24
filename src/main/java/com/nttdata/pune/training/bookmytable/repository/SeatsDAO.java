package com.nttdata.pune.training.bookmytable.repository;

import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.Seats;

public interface SeatsDAO {
	public void insert(Seats seats);
	public int registerSeats(Seats seats);
	public int update(Seats seats);
	public void delete();
	public List<Seats> displayAllSeats(String hotelId);
	//public List<Seats> displayAllSeats(Seats seats);
	public int updateHotelSeats(Seats seats);
	public List<Seats> displayTimeSlots();
	public void updateSeatsByTime(String hotel_id, String date, String time, String newseats);
}
