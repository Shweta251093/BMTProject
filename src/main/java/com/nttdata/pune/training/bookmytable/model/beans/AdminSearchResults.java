package com.nttdata.pune.training.bookmytable.model.beans;

public class AdminSearchResults {
	private String user_id,booking_id,full_name,booking_date,booking_time,no_of_seats,contact_no,status;

	public String getUser_id() {
		return user_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}

	public String getBooking_time() {
		return booking_time;
	}

	public void setBooking_time(String booking_time) {
		this.booking_time = booking_time;
	}

	public String getNo_of_seats() {
		return no_of_seats;
	}

	public void setNo_of_seats(String no_of_seats) {
		this.no_of_seats = no_of_seats;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	
	
}
