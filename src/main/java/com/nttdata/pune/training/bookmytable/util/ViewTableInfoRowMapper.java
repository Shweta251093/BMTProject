package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.TableInfo;

public class ViewTableInfoRowMapper implements RowMapper<TableInfo> {
	
@Override
public TableInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	TableInfo tableInfo = new TableInfo();
	tableInfo.setBooking_id(rs.getString("BOOKING_ID"));
	tableInfo.setUser_id(rs.getString("USER_ID"));
	tableInfo.setFull_name(rs.getString("FULL_NAME"));
	tableInfo.setContact(rs.getString("CONTACT_NO"));
	tableInfo.setNo_of_seat(rs.getString("NO_OF_SEATS"));
		return tableInfo;
	     }

}
