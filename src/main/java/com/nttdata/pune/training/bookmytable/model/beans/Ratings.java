package com.nttdata.pune.training.bookmytable.model.beans;

public class Ratings {
	private String RatingNumber;
	private String colorCode;
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	public Ratings(){}
	public Ratings(String RatingNumber,String colorCode) {
		this.RatingNumber = RatingNumber;
		this.colorCode =colorCode;
		
	}
	public String getRatingNumber() {
		return RatingNumber;
	}

	public void setRatingNumber(String ratingNumber) {
		this.RatingNumber = ratingNumber;
	}
}
