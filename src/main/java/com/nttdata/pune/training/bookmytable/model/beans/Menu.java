package com.nttdata.pune.training.bookmytable.model.beans;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Menu {
private String hotel_id;
@NotEmpty
@Size(max=5, min=3)
private String menu_id;
@NotEmpty
@Size(max=20, min=2)
private String food_name;
@NotEmpty
@Size(max=10, min=2)
private String category;
private int rate;
public int getRate() {
	return rate;
}
public void setRate(int rate) {
	this.rate = rate;
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
 * @return the menu_id
 */
public String getMenu_id() {
	return menu_id;
}
/**
 * @param menu_id the menu_id to set
 */
public void setMenu_id(String menu_id) {
	this.menu_id = menu_id;
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
 * @return the rate
 */

/**
 * @return the category
 */
public String getCategory() {
	return category;
}
/**
 * @param category the category to set
 */
public void setCategory(String category) {
	this.category = category;
}
/**
 * @return the veg
 */
String veg;
/**
 * @return the veg
 */
public String getVeg() {
	return veg;
}
/**
 * @param veg the veg to set
 */
public void setVeg(String veg) {
	this.veg = veg;
}

/*@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
	return(menu_id + " "+hotel_id);
	}*/
}
