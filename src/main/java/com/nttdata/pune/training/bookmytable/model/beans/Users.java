package com.nttdata.pune.training.bookmytable.model.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class Users {
	
	@NotEmpty
	@Email
	@Size(max=50,min=1)
	private String user_id;
	@NotEmpty
	@Size(max=50,min=2)
	private String full_name;
	@NotEmpty
	@Size(max=10,min=10)
	@Pattern(regexp="[1-9][0-9]+")
	private String contact_no;
	@NotEmpty
	@Size(max=50,min=2)
	private String password;

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
 * @return the full_name
 */
public String getFull_name() {
	return full_name;
}

/**
 * @param full_name the full_name to set
 */
public void setFull_name(String full_name) {
	this.full_name = full_name;
}

/**
 * @return the contact_no
 */
public String getContact_no() {
	return contact_no;
}

/**
 * @param contact_no the contact_no to set
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
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}
}
