package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.LoginBean;



public class AdminRowMapper implements RowMapper<LoginBean> {

	
	@Override
	public LoginBean mapRow(ResultSet rs, int rowNum) throws SQLException {
	
	//checking
		/*----------------------------------  Sets the designated parameter to the given Java String value---------*/
		LoginBean adminlist = new LoginBean();
		adminlist.setUsername(rs.getString("hotel_id"));//Retrieves the value of the designated column in the current row
		adminlist.setPassword(rs.getString("password"));
		
		return adminlist;
	     }

}
