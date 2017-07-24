package com.nttdata.pune.training.bookmytable.repository;

import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.AdminSearchResults;
import com.nttdata.pune.training.bookmytable.model.beans.BillGenerator;
import com.nttdata.pune.training.bookmytable.model.beans.CheckedIn;
import com.nttdata.pune.training.bookmytable.model.beans.HotelAdmin;
import com.nttdata.pune.training.bookmytable.model.beans.HotelAdminSeats;

public interface HotelAdminDAO {

	public int insert(HotelAdmin hotelAdmin);
	public void update(HotelAdmin hotelAdmin);
	public int delete(String hotel_id);
	public int confirm(String hotel_id,String hotel_name,String location,String contact_no,String password);
	public List<HotelAdmin> displayAllTempHotels();
	public List<HotelAdmin> displayAllPermHotels();
	public List<HotelAdminSeats> findHotel(int no_of_seats,String booking_date,String booking_time);
	public List<AdminSearchResults> selectAllBookingDetails(String key,String searchBy,String hotel_id);
	public List<CheckedIn> selectCheckedInTableIdAndBookingIdList(String hotel_id);
	public int deleteAllPreviosBookingsRecords(String hotel_id);
	public List<BillGenerator> selectOrder(String Hotel_id,String table_id);
	public List<BillGenerator> selectDiscountData(String Hotel_id,String table_id);
	public List<HotelAdmin> displayPermHotels(String hotel_id);
	public List<BillGenerator> historyUserData(String hotel_id, String table_id,String booking_id);
	public int insertIntoHistory(List<BillGenerator> historyUserData,List<BillGenerator> orderData);
	public List<String> hasRegistered(String hotel_id);
	
}
