package com.nttdata.pune.training.bookmytable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.nttdata.pune.training.bookmytable.repository.BookedSeatsDAO;
import com.nttdata.pune.training.bookmytable.repository.BookingsDAO;
import com.nttdata.pune.training.bookmytable.repository.CheckedInDAO;
import com.nttdata.pune.training.bookmytable.repository.HistoryDAO;
import com.nttdata.pune.training.bookmytable.repository.HotelAdminDAO;
import com.nttdata.pune.training.bookmytable.repository.HotelTableDAO;
import com.nttdata.pune.training.bookmytable.repository.MenuDAO;
import com.nttdata.pune.training.bookmytable.repository.SeatsDAO;
import com.nttdata.pune.training.bookmytable.repository.UsersDAO;

enum WorkingSlot {
	END_TIME(22);

	int hour;

	private WorkingSlot(int hour) {
		this.hour = hour;
	}

	int getHour() {
		return hour;
	}
}

@Service
public class OperationService implements Operation {
	@Autowired
	private HistoryDAO historyDAO;
	@Autowired
	private MenuDAO menuDao;
	@Autowired
	private HotelAdminDAO hotelAdminDao;
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private SeatsDAO seatsDAO;
	@Autowired
	private HotelTableDAO hotelTableDAO;
	@Autowired
	private BookedSeatsDAO bookedSeatsDAO;
	@Autowired
	private BookingsDAO bookingsDAO;
	@Autowired
	private CheckedInDAO checkedinDAO;

	public OperationService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public int insertUsersOeration(Users user) {

		int status = usersDAO.insert(user);

		return status;
	}

	@Override
	public List<String> hasUser(String user_id) {
		List<String> record = null;

		record = usersDAO.hasUser(user_id);
		return record;
	}

	@Override
	@Transactional
	public int insertHotelOperation(HotelAdmin hotel) {

		int status = hotelAdminDao.insert(hotel);

		return status;
	}

	@Override
	@Transactional
	public int registerSeatsOperation(Seats seats) {

		int status = 0;

		String time = seats.getBooking_time();
		//System.out.println("Time entered: " + time);

		String startTime = time.substring(0, 2);// Get Hour from time

		//System.out.println("StartTime: " + startTime);

		int hour = Integer.parseInt(startTime);

		//System.out.println("Hour: " + hour);

		for (int registerHour = hour; registerHour <= WorkingSlot.END_TIME.getHour(); registerHour++) {

			StringBuilder sb = new StringBuilder();
			sb.append(registerHour);
			sb.append(":00");
			sb.append(":00");

			seats.setBooking_time(sb.toString());

			status = seatsDAO.registerSeats(seats);		

		}

		return status;
		// return 0;
	}

	@Override
	public List<String> hasRegistered(String hotel_id) {
		// TODO Auto-generated method stub
		List<String> record = hotelAdminDao.hasRegistered(hotel_id);

		return record;
	}

	@Override
	@Transactional
	public int insertMenuOperation(Menu menu, String hotelId) {

		int status = menuDao.insert(menu, hotelId);

		return status;
	}

	@Override
	public int insertBookedSeatsOperation(BookedSeats bookedSeats) {

		int bookedSeatsResult = bookedSeatsDAO.insert(bookedSeats);
		return bookedSeatsResult;

	}

	// calling historyDAO to insert all the operations
	@Override
	public int insertOperation(Users users, HotelAdmin hotelAdmin,
			BookedSeats bookedSeats, Bookings bookings, CheckedIn checkedIn,
			History history, HotelTable hotelTable, Menu menu, Seats seats) {
		// int ins = menuDao.insert(menu);
		int res = historyDAO.insert(history);

		return res;
	}

	@Override
	public int updateOperation(Users toUpdate, HotelAdmin hotelAdmin,
			HotelTable hotelTable, Seats seats) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMenuOperation(Menu menu) {
		menuDao.updateMenu(menu);
		return 0;

	}

	@Override
	public int deleteOperation(BookedSeats bookedSeats, Bookings bookings,
			CheckedIn checkedIn, HotelTable hotelTable) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	// Method for deleting Temporary Hotel
	public int deleteHotelOperation(String hotel_id) {
		int res = hotelAdminDao.delete(hotel_id);
		return res;

	}

	/*
	 * @Override public int deleteMenuOperation(String hotelId, String menuId) {
	 * int menu = menuDao.deleteMenu(hotelId, menuId); return menu;
	 * 
	 * }
	 */

	// calling hotelTableDAO to insert customer ordered menu
	@Override
	public int insertHotelOrderOperation(String table_id, String hotel_id,
			List<String> orderedMenu, List<String> menuQuantity) {
		// TODO Auto-generated method stub
		int status = hotelTableDAO.insert(table_id, hotel_id, orderedMenu,
				menuQuantity);
		return status;

	}

	@Override
	public List<HotelAdmin> selectHotelAdmin() {
		List<HotelAdmin> listOfTempHotels = hotelAdminDao
				.displayAllTempHotels();
		return listOfTempHotels;

	}

	@Override
	public List<History> selectHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> selectMenu() {
		// TODO Auto-generated method stub
		List<Menu> listofMenu = menuDao.displayAllMenu();
		return listofMenu;

	}

	@Override
	public List<Seats> selectSeats(String hotelId) {
		// TODO Auto-generated method stub
		List<Seats> listofSeats = seatsDAO.displayAllSeats(hotelId);
		return listofSeats;

	}

	/*
	 * @Override public List<Seats> selectSeats(Seats seats) { // TODO
	 * Auto-generated method stub List<Seats> listofSeats =
	 * seatsDAO.displayAllSeats(seats); return listofSeats;
	 * 
	 * }
	 */

	@Override
	public List<Menu> selectMenu(String hotel_id) {
		// TODO Auto-generated method stub
		List<Menu> listofMenu = menuDao.displayAllMenu(hotel_id);
		return listofMenu;

	}

	// select table which is booked

	@Override
	public List<CheckedIn> selectBookedtable(String hotel_id) {
		List<CheckedIn> listoftable = checkedinDAO.displayBookTable(hotel_id);
		return listoftable;

	}

	@Override
	public List<HotelAdminSeats> findHotel(int no_of_seats,
			String booking_date, String booking_time) {
		// TODO Auto-generated method stub

		List<HotelAdminSeats> findHotel = hotelAdminDao.findHotel(no_of_seats,
				booking_date, booking_time);

		return findHotel;
	}

	@Override
	@Transactional
	// Method for Inserting temporary Hotel into Permanent Table
	public int insertTempHotel(String hotel_id, String hotel_name,
			String location, String contact_no, String password) {
		int res = hotelAdminDao.confirm(hotel_id, hotel_name, location,
				contact_no, password);
		return res;

	}

	@Override
	public int insertBookingsOperation(Bookings bookings) {
		// TODO Auto-generated method stub
		int BookingsResult = bookingsDAO.insert(bookings);

		return BookingsResult;
	}

	@Override
	public int updateSeatCount(Seats seats) {
		// TODO Auto-generated method stub
		int updatedseatsResult = seatsDAO.update(seats);

		return updatedseatsResult;
	}

	@Override
	public int updateSeatsOperation(Seats seats) {
		// TODO Auto-generated method stub
		int updateHotelSeats = seatsDAO.updateHotelSeats(seats);
		return updateHotelSeats;
	}

	@Override
	public List<HotelAdmin> selectHotel(String hotel_id) {
		// TODO Auto-generated method stub

		List<HotelAdmin> listOfPermHotels = hotelAdminDao
				.displayPermHotels(hotel_id);
		return listOfPermHotels;
	}

	@Override
	public List<HotelTable> showOrderTable(String table_id, String hotel_id) {
		// TODO Auto-generated method stub
		List<HotelTable> listOfOrder = hotelTableDAO.showOrderTable(table_id,
				hotel_id);
		return listOfOrder;
	}

	@Override
	@Transactional
	public void deleteSeats() {
		seatsDAO.delete();
	}

	@Override
	public List<HotelTable> displayOrderTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seats> selectTimeSlots() {

		List<Seats> timeSlot = seatsDAO.displayTimeSlots();
		return timeSlot;
	}

	@Override
	public void updateSeats(String hotel_id, String date, String time,
			String newseats) {
		// TODO Auto-generated method stub
		seatsDAO.updateSeatsByTime(hotel_id, date, time, newseats);

	}

	@Override
	public List<Menu> displayMenu(String hotel_id) {
		List<Menu> menu = menuDao.displayAllMenu(hotel_id);
		return menu;
	}

	@Override
	public int updateNewMenu(String hotel_id, String menu_id, String rate) {
		// TODO Auto-generated method stub
		menuDao.updateNewMenu(hotel_id, menu_id, rate);
		return 0;
	}

	/*
	 * @Override public List<Menu> getMenuId(Menu menu, String menuId, String
	 * foodName) { // TODO Auto-generated method stub List<Menu>
	 * menuData=menuDao.getMenuData(menu); return menuData; }
	 */

	@Override
	public List<Menu> getMenuId(String hotel_id, String menuId, String foodName) {
		// TODO Auto-generated method stub
		List<Menu> menuData = menuDao.getMenuData(hotel_id, menuId, foodName);
		return menuData;
	}

	/*
	 * @Override public List<Seats> selectSeats(Seats seats) { // TODO
	 * Auto-generated method stub return null; }
	 */

}
