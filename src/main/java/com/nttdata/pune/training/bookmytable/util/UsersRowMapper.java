package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsersRowMapper implements RowMapper<String> {

	@Override
	public String mapRow(ResultSet rs, int arg1) throws SQLException {
		
		String full_name = rs.getString("full_name");
		
		return full_name;
		
	}

}
