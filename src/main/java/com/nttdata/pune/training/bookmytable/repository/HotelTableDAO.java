package com.nttdata.pune.training.bookmytable.repository;

import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.HotelTable;

public interface HotelTableDAO {

	// public int insert(HotelTable hotelTable);
	public void update(HotelTable hotelTable);

	public void delete(HotelTable hotelTable);

	public List<HotelTable> displayAllTables();

	public int insert(String table_id, String hotel_id, List<String> orderedMenu,
			List<String> menuQuantity);

	public List<HotelTable> displayOrderTable(String table_id);

	public List<HotelTable> showOrderTable(String table_id,String hotel_id);
	
	

}
