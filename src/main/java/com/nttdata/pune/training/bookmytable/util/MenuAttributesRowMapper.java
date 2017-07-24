package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.Menu;

public class MenuAttributesRowMapper  implements RowMapper<Menu>{

	@Override
	public Menu mapRow(ResultSet rs, int menuData) throws SQLException {
		Menu menu = new Menu();
		// TODO Auto-generated method stub
		menu.setMenu_id(rs.getString("menu_id"));
		
		menu.setFood_name(rs.getString("food_name"));
		return menu;
	}
	

}
