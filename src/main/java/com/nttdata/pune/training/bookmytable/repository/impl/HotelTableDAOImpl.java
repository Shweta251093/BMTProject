package com.nttdata.pune.training.bookmytable.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nttdata.pune.training.bookmytable.model.beans.HotelTable;
import com.nttdata.pune.training.bookmytable.repository.HotelTableDAO;
import com.nttdata.pune.training.bookmytable.util.HotelTableRowMapper;
import com.nttdata.pune.training.bookmytable.util.OrderShowRowMapper;

@Repository
public class HotelTableDAOImpl implements HotelTableDAO {

	@Autowired
	private JdbcTemplate dbTemplate;

	/*
	 * @Override public int insert(HotelTable hotelTable) { // TODO
	 * Auto-generated method stub
	 * 
	 * dbTemplate.update(
	 * "insert into hotel_table(table_id,hotel_id,menu_id,quantity,status) values(?,?,?,?,?)"
	 * ,new Object[]{hotelTable.getTable_id(),hotelTable
	 * .getHotel_id(),hotelTable
	 * .getMenu_id(),hotelTable.getQuantity(),hotelTable.getStatus()}); return
	 * 0; }
	 */

	@Override
	public void update(HotelTable hotelTable) {
		// TODO Auto-generated method stub
		dbTemplate
				.update("update hotel_table set menu_id=?,quantity=?,status=? where table_id=? and hotel_id=?",
						new Object[] { hotelTable.getMenu_id(),
								hotelTable.getQuantity(),
								hotelTable.getStatus(),
								hotelTable.getTable_id(),
								hotelTable.getHotel_id() });
	}

	@Override
	public void delete(HotelTable hotelTable) {
		// TODO Auto-generated method stub
		dbTemplate.update("delete from hotel_table where table_id=? and hotel_id=?",new Object[] { hotelTable.getTable_id(),hotelTable.getHotel_id() });
	}

	@Override
	public List<HotelTable> displayAllTables() {
		// TODO Auto-generated method stub
		List<HotelTable> listOfTables = dbTemplate
				.query("select table_id,hotel_id,menu_id,quantity,status from hotel_table",
						new HotelTableRowMapper());
		return listOfTables;
	}

	@Override
	public int insert(String table_id, String hotel_id, List<String> orderedMenu,
			List<String> menuQuantity) {
		// TODO Auto-generated method stub
       //inserting customer order into hotel_table 
		
		System.out.println(table_id + hotel_id + orderedMenu.get(0) + menuQuantity.get(0) +orderedMenu.size() );
		//insert customer order into hotel table
		for (int i = 0; i < orderedMenu.size(); i++) {
			dbTemplate.update("insert into hotel_table(table_id,hotel_id,menu_id,quantity,status) values(?,?,?,?,?)",new Object[] {table_id, hotel_id, orderedMenu.get(i),menuQuantity.get(i), "served" });
		}

		return 0;

	}

	@Override
	public List<HotelTable> displayOrderTable(String table_id) {
		// TODO Auto-generated method stub
	
		List<HotelTable> listOfOrder = dbTemplate
				.query("select hotel_id,menu_id,quantity,status from hotel_table where table_id=?",
						new HotelTableRowMapper());
		return listOfOrder;
	}

	@Override
	public List<HotelTable> showOrderTable(String table_id,String hotel_id) {
		// TODO Auto-generated method stub
		//display hotel_id,menu_id,quantity,status of booked_table
	
		List<HotelTable> listOfOrder = dbTemplate
				.query("select menu_id,quantity,status from hotel_table where table_id=? and hotel_id=?",
						new Object[]{table_id,hotel_id}, new OrderShowRowMapper());
		return listOfOrder;
	}

	

}
