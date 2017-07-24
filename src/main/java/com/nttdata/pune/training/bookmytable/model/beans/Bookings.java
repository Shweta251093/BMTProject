package com.nttdata.pune.training.bookmytable.model.beans;

import org.springframework.stereotype.Component;

@Component
public class Bookings {
private String user_id,booking_id;

/**
 * @return the user_id
 */
public String getUser_id() {
	return user_id;
}

/**
 * @param user_id the user_id to set
 */
public void setUser_id(String user_id) {
	this.user_id = user_id;
}

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
}
