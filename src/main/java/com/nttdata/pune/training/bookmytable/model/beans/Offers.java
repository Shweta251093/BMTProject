package com.nttdata.pune.training.bookmytable.model.beans;

import org.hibernate.validator.constraints.NotEmpty;

public class Offers {

	private String hotel_id,offer_id,menu_id,discount,hotel_name,food_name;
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getOffer_id() {
		return offer_id;
	}
	@Override
	public String toString() {
		return "Offers [hotel_id=" + hotel_id + ", offer_id=" + offer_id
				+ ", menu_id=" + menu_id + ", discount=" + discount
				+ ", hotel_name=" + hotel_name + ", food_name=" + food_name
				+ "]";
	}
	public void setOffer_id(String offer_id) {
		this.offer_id = offer_id;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getDiscount() {
		return discount;
	}
	@NotEmpty
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
}
