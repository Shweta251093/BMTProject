package com.nttdata.pune.training.bookmytable.service;

import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.BookedSeats;
import com.nttdata.pune.training.bookmytable.model.beans.Bookings;
import com.nttdata.pune.training.bookmytable.model.beans.CheckedIn;
import com.nttdata.pune.training.bookmytable.model.beans.History;
import com.nttdata.pune.training.bookmytable.model.beans.HotelAdmin;
import com.nttdata.pune.training.bookmytable.model.beans.HotelAdminSeats;
import com.nttdata.pune.training.bookmytable.model.beans.HotelTable;
import com.nttdata.pune.training.bookmytable.model.beans.Menu;
import com.nttdata.pune.training.bookmytable.model.beans.Seats;
import com.nttdata.pune.training.bookmytable.model.beans.Users;

public interface Operation {

	/*
	 * int insertOperation(Employee employee, Company company); int
	 * updateOperation(Employee employee, Company company); int
	 * insertAndUpdateOperation(Employee employee, Company company) ;
	 * List<Employee> selectEmployee(); List<Company> selectCompany();
	 */

	// insert operation for inserting into users table
	int insertUsersOeration(Users user);

	// checking availability of particular user
	List<String> hasUser(String user_id);
	
	// insert operation for inserting into temp_hotels table
	int insertHotelOperation(HotelAdmin hotel);	

	// insert operation for inserting into seats table
	int registerSeatsOperation(Seats seats);

	// check if hotel already available in temp_hotel table
	List<String> hasRegistered(String hotel_id);	
	
	int insertBookedSeatsOperation(BookedSeats bookedSeats);

	int insertBookingsOperation(Bookings bookings);

	// Other original operations

	int insertOperation(Users users, HotelAdmin hotelAdmin,
			BookedSeats bookedSeats, Bookings bookings, CheckedIn checkedIn,
			History history, HotelTable hotelTable, Menu menu, Seats seats);


		List<Menu> displayMenu(String hotel_id);

		int updateNewMenu(String hotel_id, String menu_id, String rate);

		

	int updateOperation(Users toUpdate, HotelAdmin hotelAdmin,
			HotelTable hotelTable, Seats seats);

	int deleteOperation(BookedSeats bookedSeats, Bookings bookings,
			CheckedIn checkedIn, HotelTable hotelTable);

	// delete temporary hotel
	int deleteHotelOperation(String hotel_id);

	// confirm temporary hotel
	int insertTempHotel(String hotel_id, String hotel_name, String location,
			String contact_no, String password);

	List<HotelAdmin> selectHotelAdmin();

	// display all the history
	List<History> selectHistory();

	List<Menu> selectMenu(String hotel_id);

	List<Menu> selectMenu();

	List<CheckedIn> selectBookedtable(String hotel_id);

	List<HotelTable> displayOrderTable();

	List<HotelAdminSeats> findHotel(int no_of_seats, String booking_date,
			String booking_time);

	// Insert operation for inserting into new menu
	int insertMenuOperation(Menu menu, String hotelId);

	// Delete operation for deleting existing menu
	//int deleteMenuOperation(String hotelId, String menuId);

	int updateSeatCount(Seats seats);

	// Update Operation for updating rate
	int updateMenuOperation(Menu menu);

	// Select data from seats table
	List<Seats> selectSeats(String hotelId);

	// Insert customer ordered menu into HotelOrderOperation table
	int insertHotelOrderOperation(String table_id, String hotel_id,
			List<String> str, List<String> str1);


		//Method to select time slots 
		List<Seats> selectTimeSlots();

		

	//List<Seats> selectSeats(Seats seats);


	int updateSeatsOperation(Seats seats);

	List<HotelAdmin> selectHotel(String hotel_id);

	// display order of booked table
	List<HotelTable> showOrderTable(String table_id,String hotel_id);

	// To delete unrequired seats from seats table
	void deleteSeats();
	

	void updateSeats(String hotel_id, String date, String time, String newseats);




	List<Menu> getMenuId(String hotel_id,String menuId, String foodName);




}
