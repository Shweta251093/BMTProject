package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.Offers;

public class OffersRowMapper implements RowMapper<Offers> {

	@Override
	public Offers mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Offers offers=new Offers();
		offers.setHotel_id(arg0.getString("hotel_id"));
		offers.setMenu_id(arg0.getString("menu_id"));
		offers.setOffer_id(arg0.getString("offer_id"));
		offers.setDiscount(arg0.getString("discount"));
		offers.setHotel_name(arg0.getString("hotel_name"));
		offers.setFood_name(arg0.getString("food_name"));
		return offers;
	}

}
