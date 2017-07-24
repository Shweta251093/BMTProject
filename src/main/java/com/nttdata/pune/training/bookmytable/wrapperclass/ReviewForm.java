package com.nttdata.pune.training.bookmytable.wrapperclass;

import com.nttdata.pune.training.bookmytable.model.beans.Ratings;
import com.nttdata.pune.training.bookmytable.model.beans.Reviews;

public class ReviewForm {
private Reviews reviews;
private Ratings ratings;
public Reviews getReviews() {
	return reviews;
}
public void setReviews(Reviews reviews) {
	this.reviews = reviews;
}
public Ratings getRatings() {
	return ratings;
}
public void setRatings(Ratings ratings) {
	this.ratings = ratings;
}

}
