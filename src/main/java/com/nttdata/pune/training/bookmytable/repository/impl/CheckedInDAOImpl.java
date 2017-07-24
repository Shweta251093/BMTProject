package com.nttdata.pune.training.bookmytable.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nttdata.pune.training.bookmytable.model.beans.CheckedIn;
import com.nttdata.pune.training.bookmytable.repository.CheckedInDAO;
import com.nttdata.pune.training.bookmytable.util.CheckedInRowMapper;
import com.nttdata.pune.training.bookmytable.util.GetBookingIdRowMapper;
import com.nttdata.pune.training.bookmytable.util.OrderRowMapper;
@Repository
public class CheckedInDAOImpl implements CheckedInDAO {

	@Autowired
	private JdbcTemplate dbTemplate;
	
	@Override
	public void insert(CheckedIn checkedIn) {
		// TODO Auto-generated method stub
		dbTemplate.update("insert into checked_in (booking_id,table_id) values(?,?)", new Object[]{checkedIn.getBooking_id(),checkedIn.getTable_id()});
	}

	@Override
	public void delete(CheckedIn checkedIn) {
		// TODO Auto-generated method stub
		
		dbTemplate.update("delete from checked_in where booking_id=? and table_id=?",new Object[]{checkedIn.getBooking_id(),checkedIn.getTable_id()});
		
	}

	@Override
	public List<CheckedIn> displayAllCheckedIn() {
		// TODO Auto-generated method stub
		List<CheckedIn> listOfCheckedIn=dbTemplate.query("select booking_id,table_id from checked_in", new CheckedInRowMapper()); 
		return listOfCheckedIn; 
	}

	@Override
	public List<CheckedIn> displayBookTable(String hotel_id) {
		// TODO Auto-generated method stub
		
		// getting list of table booked of that hotel_id
		List<CheckedIn> listOfBookTable=dbTemplate.query("select table_id from checked_in,booked_seats where checked_in.booking_id=booked_seats.booking_id and booked_seats.hotel_id=?", new Object[]{hotel_id}, new OrderRowMapper());
		System.out.println(listOfBookTable);
		
		return listOfBookTable;
	}

	@Override
	public CheckedIn getBookingId(String table_id,String hotel_id) {
		// TODO Auto-generated method stub
		System.out.println("in DAO table :"+table_id);
		System.out.println("in DAO hotel :"+hotel_id);
		List<CheckedIn> getBookingId= dbTemplate.query("select checked_in.booking_id from checked_in,booked_seats where table_id=? and checked_in.BOOKING_ID=booked_seats.BOOKING_ID and booked_seats.HOTEL_ID=?",new Object[]{table_id,hotel_id}, new GetBookingIdRowMapper());
		System.out.println("in DAO:"+getBookingId.get(0).getBooking_id());
		
		return getBookingId.get(0) ;
	}

}
