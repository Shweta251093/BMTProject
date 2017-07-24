package com.nttdata.pune.training.bookmytable.util;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.Menu;
public class MenuDisplayRowMapper implements RowMapper<Menu> {

	@Override
	public Menu mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Menu menu = new Menu();

		menu.setMenu_id(rs.getString("menu_id"));
		//menu.setHotel_id(rs.getString("hotel_id"));
		menu.setFood_name(rs.getString("food_name"));
		menu.setRate(rs.getInt("rate"));
		menu.setVeg(rs.getString("veg"));
		menu.setCategory(rs.getString("category"));

		return menu;
	}

}







