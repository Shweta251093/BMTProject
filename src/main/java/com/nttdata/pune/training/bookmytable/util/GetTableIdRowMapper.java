package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.CheckedIn;

public class GetTableIdRowMapper implements RowMapper<CheckedIn> {
	
	@Override
	public CheckedIn mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CheckedIn checkedIn=new CheckedIn();
		checkedIn.setTable_id(Integer.toString(rs.getInt("table_id")));
		checkedIn.setBooking_id(rs.getString("booking_id"));
		return checkedIn;
	     }


}
