package com.nttdata.pune.training.bookmytable.model.beans;

public class HotelTable {
private String table_id,hotel_id,menu_id,quantity,status;

/**
 * @return the table_id
 */
public String getTable_id() {
	return table_id;
}

/**
 * @param table_id the table_id to set
 */
public void setTable_id(String table_id) {
	this.table_id = table_id;
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
 * @return the status
 */
public String getStatus() {
	return status;
}

/**
 * @param status the status to set
 */
public void setStatus(String status) {
	this.status = status;
}
}
