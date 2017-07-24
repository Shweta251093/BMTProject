package com.nttdata.pune.training.bookmytable.model.beans;



import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
@Component
public class History {
	@NotEmpty
private String user_id,booking_id,hotel_id,food_name,quantity,rating,review;

/**
 * @return the user_id
 */
	private String reviewText;
@Size(max=5,min=1)
	private String ratingText;
public String getRatingText() {
		return ratingText;
	}

	public void setRatingText(String ratingText) {
		this.ratingText = ratingText;
	}

public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

public String getReviewText() {
	return reviewText;
}

public void setReviewText(String reviewText) {
	this.reviewText = reviewText;
}

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
 * @return the food_name
 */
public String getFood_name() {
	return food_name;
}

/**
 * @param food_name the food_name to set
 */
public void setFood_name(String food_name) {
	this.food_name = food_name;
}

/**
 * @return the quantity
 */
public String getQuantity() {
	return quantity;
}

/**
 * @param quantity the quantity to set
 */
public void setQuantity(String quantity) {
	this.quantity = quantity;
}



/**
 * @return the review
 */
public String getReview() {
	return review;
}

/**
 * @param review the review to set
 */
public void setReview(String review) {
	this.review = review;
}
}
