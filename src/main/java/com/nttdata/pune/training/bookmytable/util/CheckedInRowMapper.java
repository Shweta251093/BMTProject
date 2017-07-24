package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.CheckedIn;

public class CheckedInRowMapper implements RowMapper<CheckedIn> {

	@Override
	public CheckedIn mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		CheckedIn checkedIn=new CheckedIn();
		checkedIn.setBooking_id(arg0.getString("booking_id"));
		checkedIn.setTable_id(arg0.getString("table_id"));
		return checkedIn;
	}

}
