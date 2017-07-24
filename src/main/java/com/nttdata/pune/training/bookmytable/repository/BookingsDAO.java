package com.nttdata.pune.training.bookmytable.repository;

import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.Bookings;

public interface BookingsDAO {

	public int insert(Bookings bookings);
	public void delete(Bookings bookings);
	public List<Bookings> displayBookings();
}
