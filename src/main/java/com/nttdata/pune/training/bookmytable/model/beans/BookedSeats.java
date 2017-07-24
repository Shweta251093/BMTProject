package com.nttdata.pune.training.bookmytable.model.beans;

import org.springframework.stereotype.Component;

@Component
public class BookedSeats {
private String booking_id,hotel_id,booking_date,booking_time;
private int no_of_seats;

/**
 * @return the booking_id
 */
public String getBooking_id() {
	return booking_id;
}

/**
 * @param booking_id the booking_id to set
 */
public void setBooking_id(String booking_id) {
	this.booking_id = booking_id;
}

/**
 * @return the hotel_id
 */
public String getHotel_id() {
	return hotel_id;
}

/**
 * @param hotel_id the hotel_id to set
 */
public void setHotel_id(String hotel_id) {
	this.hotel_id = hotel_id;
}

/**
 * @return the no_of_seats
 */

/**
 * @param no_of_seats2 the no_of_seats to set
 */

/**
 * @return the booking_date
 */
public String getBooking_date() {
	return booking_date;
}

public int getNo_of_seats() {
	return no_of_seats;
}

public void setNo_of_seats(int no_of_seats) {
	this.no_of_seats = no_of_seats;
}

/**
 * @param booking_date the booking_date to set
 */
public void setBooking_date(String booking_date) {
	this.booking_date = booking_date;
}

/**
 * @return the booking_time
 */
public String getBooking_time() {
	return booking_time;
}

/**
 * @param booking_time the booking_time to set
 */
public void setBooking_time(String booking_time) {
	this.booking_time = booking_time;
}
}
