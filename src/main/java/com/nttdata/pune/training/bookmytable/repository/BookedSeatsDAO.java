package com.nttdata.pune.training.bookmytable.repository;

import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.BookedSeats;

public interface BookedSeatsDAO {

	public int insert(BookedSeats bookedSeats);
	public void delete(BookedSeats bookedSeats);
	public List<BookedSeats> displayAllBookedSeats();
}
