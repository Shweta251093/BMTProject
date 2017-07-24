package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.BillGenerator;

public class HistoryUserRowMapper implements RowMapper<BillGenerator> {

	@Override
	public BillGenerator mapRow(ResultSet rs, int arg1) throws SQLException {
		BillGenerator historyuserdata =new BillGenerator();

		historyuserdata.setUser_id(rs.getString("user_id"));
		historyuserdata.setBooking_id(rs.getString("booking_id"));
		historyuserdata.setHotel_id(rs.getString("hotel_id"));
		
				return (historyuserdata);
			}
	}


