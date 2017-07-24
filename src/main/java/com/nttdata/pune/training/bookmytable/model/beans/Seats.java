package com.nttdata.pune.training.bookmytable.model.beans;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class Seats {

	private String hotel_id;
	
	private String booking_date; 
	@NotEmpty
	@Min(10)
	@Max(22)
	private String booking_time;
	@Min(100)
	private int no_of_seats;

	/**
	 * @return the hotel_id
	 */
	public String getHotel_id() {
		return hotel_id;
	}

	/**
	 * @param hotel_id
	 *            the hotel_id to set
	 */
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}

	/**
	 * @return the no_of_seats
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
	 * @param booking_date
	 *            the booking_date to set
	 * @throws ParseException 
	 */
	public void setBooking_date(String booking_date)  {
		
	
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(today);

		// Print what date is today!
		System.out.println("Report Date: " + reportDate);
		
		this.booking_date = booking_date;
	}

	/**
	 * @return the booking_time
	 */
	public String getBooking_time() {
		return booking_time;
	}

	/**
	 * @param booking_time
	 *            the booking_time to set
	 */
	public void setBooking_time(String booking_time) {
		this.booking_time = booking_time;
	}


	
	
	
	
}
