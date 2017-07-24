package com.nttdata.pune.training.bookmytable.model.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class HotelAdmin {

	@NotEmpty
	@Email
	@Size(max=50,min=1)
	private String hotel_id;
	@NotEmpty
	@Size(max=50,min=2)
	private String hotel_name;
	@NotEmpty
	@Size(max=50,min=2)
	private String location;
	@NotEmpty
	@Size(max=10,min=10)
	@Pattern(regexp="[1-9][0-9]+")
	private String contact_no;
	@NotEmpty
	@Size(max=50,min=2)
	private String password;
	

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
	 * @return the hotel_name
	 */
	public String getHotel_name() {
		return hotel_name;
	}

	/**
	 * @param hotel_name
	 *            the hotel_name to set
	 */
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the contact_no
	 */
	public String getContact_no() {
		return contact_no;
	}

	/**
	 * @param contact_no
	 *            the contact_no to set
	 */
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {

		return hotel_id + " " + hotel_name + " " + location + " " + contact_no+ " " + password;
	}

}
