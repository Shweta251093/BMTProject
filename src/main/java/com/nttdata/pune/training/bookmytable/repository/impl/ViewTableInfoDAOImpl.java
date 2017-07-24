package com.nttdata.pune.training.bookmytable.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nttdata.pune.training.bookmytable.model.beans.TableInfo;
import com.nttdata.pune.training.bookmytable.repository.ViewTableInfoDAO;
import com.nttdata.pune.training.bookmytable.util.ViewTableInfoRowMapper;
@Repository
public class ViewTableInfoDAOImpl implements ViewTableInfoDAO {

	@Autowired
	private JdbcTemplate dbTemplate;
	
	@Override
	public TableInfo selectTableInfo(String table_id,String hotel_id) {
		
		List<TableInfo> viewTableInfo=dbTemplate.query("select distinct bookings.BOOKING_ID,bookings.USER_ID,users.FULL_NAME,users.CONTACT_NO,booked_seats.NO_OF_SEATS from checked_in,bookings,users,booked_seats where bookings.BOOKING_ID=checked_in.BOOKING_ID and users.USER_ID=bookings.USER_ID and booked_seats.BOOKING_ID=checked_in.BOOKING_ID and checked_in.TABLE_ID=? and booked_seats.HOTEL_ID=? ",new Object[]{table_id,hotel_id},new ViewTableInfoRowMapper());
		
		if(viewTableInfo.size()==0){
			return null;
		}
		return viewTableInfo.get(0);
	}

}
