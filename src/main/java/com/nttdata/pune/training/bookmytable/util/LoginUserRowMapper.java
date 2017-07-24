package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.LoginBean;



public class LoginUserRowMapper implements RowMapper<LoginBean> {

	@Override
	public LoginBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		/*----------------------------------  Sets the designated parameter to the given Java String value---------*/
		LoginBean userlist = new LoginBean();
		userlist.setUsername(rs.getString("User_id"));//Retrieves the value of the designated column in the current row
		userlist.setPassword(rs.getString("password"));
		
		return userlist;
	    }

}
