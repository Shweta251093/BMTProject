package com.nttdata.pune.training.bookmytable.repository.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.pune.training.bookmytable.model.beans.AdminSearchResults;
import com.nttdata.pune.training.bookmytable.model.beans.BillGenerator;
import com.nttdata.pune.training.bookmytable.model.beans.CheckedIn;
import com.nttdata.pune.training.bookmytable.model.beans.HotelAdmin;
import com.nttdata.pune.training.bookmytable.model.beans.HotelAdminSeats;
import com.nttdata.pune.training.bookmytable.repository.HotelAdminDAO;
import com.nttdata.pune.training.bookmytable.util.BillingRowMapper;
import com.nttdata.pune.training.bookmytable.util.DiscountRowMapper;
import com.nttdata.pune.training.bookmytable.util.FindHotelRowMapper;
import com.nttdata.pune.training.bookmytable.util.GetBookingDetailsRowMapper;
import com.nttdata.pune.training.bookmytable.util.GetTableIdRowMapper;
import com.nttdata.pune.training.bookmytable.util.HistoryUserRowMapper;
import com.nttdata.pune.training.bookmytable.util.HotelAdminRowMapper;
import com.nttdata.pune.training.bookmytable.util.HotelRowMapper;

@Repository
public class HotelAdminDAOImpl implements HotelAdminDAO {

	@Autowired
	private JdbcTemplate dbTemplate;

	@Override
	public List<String> hasRegistered(String hotel_id) {
		// TODO Auto-generated method stub

		List<String> hotelList = dbTemplate.query(
				"select hotel_name from temp_hotel_admin where hotel_id=?",
				new Object[] { hotel_id }, new HotelRowMapper());

		return hotelList;
	}

	@Override
	public int insert(HotelAdmin hotelAdmin) {
		// TODO Auto-generated method stub
		int status = dbTemplate
				.update("insert into temp_hotel_admin( hotel_id ,hotel_name ,location ,contact_no,password ) values(?,?,?,?,?)",
						new Object[] { hotelAdmin.getHotel_id(),
								hotelAdmin.getHotel_name(),
								hotelAdmin.getLocation(),
								hotelAdmin.getContact_no(),
								hotelAdmin.getPassword() });

		return status;

	}

	@Override
	public void update(HotelAdmin hotelAdmin) {
		// TODO Auto-generated method stub
		dbTemplate
				.update("update perm_hotel_admin set hotel_name=?,location=?,contact_no=?,password=? where hotel_id=?",
						new Object[] { hotelAdmin.getHotel_name(),
								hotelAdmin.getLocation(),
								hotelAdmin.getContact_no(),
								hotelAdmin.getPassword(),
								hotelAdmin.getHotel_id() });

	}

	@Override
	public int delete(String hotelId) {
		System.out.println("deleted hotel id" + hotelId);
		int del = dbTemplate.update(
				"delete from temp_hotel_admin where hotel_id=?",
				new Object[] { hotelId });
		return del;

	}

	@Override
	public int confirm(String hotel_id, String hotel_name, String location,
			String contact_no, String password) {
		// perform insert query for inserting tempora
		int conf = dbTemplate
				.update("insert into perm_hotel_admin( hotel_id ,hotel_name ,location ,contact_no,password ) values(?,?,?,?,?)",
						new Object[] { hotel_id, hotel_name, location,
								contact_no, password });
		dbTemplate.update("delete from temp_hotel_admin where hotel_id=?",
				new Object[] { hotel_id });
		return conf;
	}

	@Override
	public List<HotelAdmin> displayAllTempHotels() {
		// TODO Auto-generated method stub
		System.out.println(dbTemplate);
		List<HotelAdmin> listOfHotels = dbTemplate
				.query("select hotel_id ,hotel_name ,location ,contact_no,password from temp_hotel_admin",
						new HotelAdminRowMapper());

		return listOfHotels;
	}

	@Override
	public List<HotelAdmin> displayAllPermHotels() {
		// TODO Auto-generated method stub
		List<HotelAdmin> listOfHotels = dbTemplate
				.query("select hotel_id ,hotel_name ,location ,contact_no,password from perm_hotel_admin",
						new HotelAdminRowMapper());

		return listOfHotels;
	}

	@Override
	public List<HotelAdmin> displayPermHotels(String hotel_id) {
		// TODO Auto-generated method stub
		List<HotelAdmin> listOfHotels = dbTemplate
				.query("select hotel_id,hotel_name,location ,contact_no,password from perm_hotel_admin where hotel_id=?",
						new Object[] { hotel_id }, new HotelAdminRowMapper());

		return listOfHotels;
	}

	@Override
	public List<HotelAdminSeats> findHotel(int no_of_seats,
			String booking_date, String booking_time) {
		// TODO Auto-generated method stub

		/*
		 * final String query =
		 * "select hotel_name,location,contact_no,no_of_seats,EXTRACT(Month FROM booking_date_time)||'/'||EXTRACT(DAY FROM booking_date_time)||'/' ||extract(YEAR from booking_date_time) as booking_date,extract(HOUR from booking_date_time)||':'||EXTRACT(MINUTE FROM booking_date_time)||':'||EXTRACT(SECOND FROM booking_date_time) as booking_time from Seats,PERM_HOTEL_ADMIN where ((extract(HOUR from booking_date_time)||':'||EXTRACT(MINUTE FROM booking_date_time)||':'||EXTRACT(SECOND FROM booking_date_time) >= '15:00:00') OR (extract(HOUR from booking_date_time)||':'||EXTRACT(MINUTE FROM booking_date_time)||':'||EXTRACT(SECOND FROM booking_date_time) <= '15:00:00') AND (EXTRACT(Month FROM booking_date_time)||'/'|| EXTRACT(DAY FROM booking_date_time)||'/' ||extract(YEAR from booking_date_time)='01/02/91'))"
		 * ; List<HotelAdminSeats> findHotel = (List<HotelAdminSeats>)
		 * dbTemplate .query(query, new FindHotelRowMapper());
		 */

		// final String query
		// ="select PERM_HOTEL_ADMIN.hotel_id,hotel_name,location,contact_no,no_of_seats,extract(YEAR from booking_date_time)||'-'||EXTRACT(Month FROM booking_date_time)||'-'||EXTRACT(DAY FROM booking_date_time) as booking_date, extract(HOUR from booking_date_time)||':'||EXTRACT(MINUTE FROM booking_date_time)||':'||EXTRACT(SECOND FROM booking_date_time) as booking_time from Seats,PERM_HOTEL_ADMIN where extract(YEAR from booking_date_time)||'-'||EXTRACT(Month FROM booking_date_time)||'-'||EXTRACT(DAY FROM booking_date_time)=? AND (extract(HOUR from booking_date_time)||':'||EXTRACT(MINUTE FROM booking_date_time)||':'||EXTRACT(SECOND FROM booking_date_time) >= ? OR extract(HOUR from booking_date_time)||':'||EXTRACT(MINUTE FROM booking_date_time)||':'||EXTRACT(SECOND FROM booking_date_time) <= ?) AND no_of_seats>?";
		final String query = "select PERM_HOTEL_ADMIN.hotel_id,hotel_name,location,contact_no,no_of_seats,to_char(booking_date_time,'YYYY-MM-DD') as booking_date, to_char(booking_date_time,'HH24:MI') as booking_time from Seats,PERM_HOTEL_ADMIN where to_char(booking_date_time,'YYYY-MM-DD')=? AND (to_char(booking_date_time,'HH24:MI') = ? ) AND no_of_seats>=? AND PERM_HOTEL_ADMIN.HOTEL_ID=Seats.HOTEL_ID";
		List<HotelAdminSeats> findHotel = dbTemplate.query(query, new Object[] {
				booking_date, booking_time, no_of_seats },
				new FindHotelRowMapper());

		return findHotel;
	}

	@Override
	public List<AdminSearchResults> selectAllBookingDetails(String key,
			String searchBy, String hotel_id) {

		List<AdminSearchResults> bookingDetails;
		if (searchBy.equals("date")) {
			final String query = "select bk.user_id,bk.booking_id,u.full_name, to_char(booking_date_time,'YYYY-MM-DD') as booking_date,to_char(booking_date_time,'HH12:MI:SS AM') as booking_time,no_of_seats,u.contact_no from bookings bk,users u,booked_seats bs where (bk.user_id=u.user_id and bk.booking_id=bs.booking_id and to_char(booking_date_time,'YYYY-MM-DD') = ? and bs.hotel_id=?)";
			bookingDetails = dbTemplate.query(query, new Object[] { key,
					hotel_id }, new GetBookingDetailsRowMapper());
		} else if (searchBy.equals("userID")) {
			final String query = "select bk.user_id,bk.booking_id,u.full_name,to_char(booking_date_time,'YYYY-MM-DD') as booking_date,to_char(booking_date_time,'HH12:MI:SS AM') as booking_time,no_of_seats,u.contact_no from bookings bk,users u,booked_seats bs where (bk.user_id=u.user_id and bk.booking_id=bs.booking_id and bk.user_id=? and bs.hotel_id=?)";
			bookingDetails = dbTemplate.query(query, new Object[] { key,
					hotel_id }, new GetBookingDetailsRowMapper());

		} else {
			final String query = "select bk.user_id,bk.booking_id,u.full_name,to_char(booking_date_time,'YYYY-MM-DD') as booking_date,to_char(booking_date_time,'HH12:MI:SS AM') as booking_time,no_of_seats,u.contact_no from bookings bk,users u,booked_seats bs where (bk.user_id=u.user_id and bk.booking_id=bs.booking_id and bk.booking_id=? and bs.hotel_id=?)";
			bookingDetails = dbTemplate.query(query, new Object[] { key,
					hotel_id }, new GetBookingDetailsRowMapper());

		}

		return bookingDetails;
	}

	@Override
	public List<CheckedIn> selectCheckedInTableIdAndBookingIdList(
			String hotel_id) {
		List<CheckedIn> tableIdlist;

		final String tableIdquery = "select distinct checked_in.TABLE_ID,checked_in.BOOKING_ID from checked_in,booked_seats where checked_in.BOOKING_ID=booked_seats.BOOKING_ID and booked_seats.HOTEL_ID= ? ";
		tableIdlist = dbTemplate.query(tableIdquery, new Object[] { hotel_id },
				new GetTableIdRowMapper());

		return tableIdlist;
	}

	@Override
	public List<BillGenerator> selectOrder(String hotel_id, String table_id) {
		// TODO Auto-generated method stub
		List<BillGenerator> selectOrderlist;
		// final String query =
		// "select DISTINCT HOTEL_TABLE.table_id,MENU.FOOD_NAME,MENU.RATE,HOTEL_TABLE.quantity,(Menu.rate*hotel_table.quantity)as subTotal from HOTEL_TABLE,MENU where HOTEL_TABLE.HOTEL_ID=? and HOTEL_TABLE.MENU_ID=MENU.MENU_ID and HOTEL_TABLE.TABLE_ID=?";
		final String query = "SELECT HOTEL_TABLE.TABLE_ID,menu.FOOD_NAME,menu.RATE,HOTEL_TABLE.QUANTITY,(menu.RATE*HOTEL_TABLE.QUANTITY) as subtotal FROM HOTEL_TABLE,menu where TABLE_ID=? and menu.MENU_ID=HOTEL_TABLE.MENU_ID and  HOTEL_TABLE.HOTEL_ID=?";
		selectOrderlist = dbTemplate.query(query, new Object[] { table_id,
				hotel_id }, new BillingRowMapper());
		return selectOrderlist;
	}

	@Override
	public List<BillGenerator> selectDiscountData(String hotel_id,
			String table_id) {
		List<BillGenerator> selectDiscountData;
		// final String query =
		// "select HOTEL_TABLE.table_id,MENU.MENU_ID,MENU.FOOD_NAME,MENU.RATE,offers.DISCOUNT,((MENU.RATE*(offers.DISCOUNT/100)))as discountAmount from HOTEL_TABLE,MENU,offers where HOTEL_TABLE.HOTEL_ID=? and HOTEL_TABLE.MENU_ID=MENU.MENU_ID and offers.HOTEL_ID=HOTEL_TABLE.HOTEL_ID and offers.MENU_ID=MENU.MENU_ID";
		// final String
		// query="select HOTEL_TABLE.table_id,MENU.MENU_ID,MENU.FOOD_NAME,MENU.RATE,HOTEL_TABLE.quantity,offers.DISCOUNT,(((Menu.rate*hotel_table.quantity)*(offers.DISCOUNT/100)))as discountAmount from HOTEL_TABLE,MENU,offers where HOTEL_TABLE.HOTEL_ID=? and HOTEL_TABLE.MENU_ID=MENU.MENU_ID and offers.HOTEL_ID=HOTEL_TABLE.HOTEL_ID and offers.MENU_ID=MENU.MENU_ID";
		final String query = "select Distinct OFFERS.OFFER_ID,hotel_table.table_id,menu.FOOD_NAME,menu.RATE,hotel_table.QUANTITY,OFFERS.DISCOUNT,(((Menu.rate*hotel_table.quantity)*(offers.DISCOUNT/100)))as discountAmount from hotel_table,menu,OFFERS where hotel_table.TABLE_ID=? and menu.MENU_ID=HOTEL_TABLE.MENU_ID and  HOTEL_TABLE.HOTEL_ID=? and menu.MENU_ID=OFFERS.MENU_ID";
		selectDiscountData = dbTemplate.query(query, new Object[] { table_id,
				hotel_id }, new DiscountRowMapper());
		return selectDiscountData;
	}

	@Override
	public List<BillGenerator> historyUserData(String hotel_id,
			String table_id, String booking_id) {
		List<BillGenerator> historyUserData;
		final String query = "select Distinct bookings.user_id,bookings.BOOKING_ID,hotel_table.hotel_id from bookings,checked_in,hotel_table where bookings.booking_id=checked_in.booking_id and hotel_table.TABLE_ID = checked_in.TABLE_ID and hotel_table.TABLE_ID=? and hotel_table.HOTEL_ID=? and checked_in.BOOKING_ID=?";
		historyUserData = dbTemplate.query(query, new Object[] { table_id,
				hotel_id, booking_id }, new HistoryUserRowMapper());
		return historyUserData;
	}

	@Override
	public int insertIntoHistory(List<BillGenerator> historyUserData,
			List<BillGenerator> orderData) {
		int insertIntoHistory = 0;
		BillGenerator historyUserDataObj = historyUserData.get(0);
		for (BillGenerator billGenerator : orderData) {
			final String query = "INSERT INTO history (user_id,booking_id,hotel_id,food_name,quantity) VALUES (?,?,?,?,?)";
			insertIntoHistory = dbTemplate.update(
					query,
					new Object[] { historyUserDataObj.getUser_id(),
							historyUserDataObj.getBooking_id(),
							historyUserDataObj.getHotel_id(),
							billGenerator.getFood_name(),
							billGenerator.getQuantity() });
		}
		return insertIntoHistory;
	}

	// Delete previous date records from Bookings
	@Transactional
	@Override
	public int deleteAllPreviosBookingsRecords(String hotel_id) {

		DateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		String dateToCompare = myDateFormat.format(dateobj);
		System.out.println(hotel_id);
		System.out.println("My Date to compare:" + dateToCompare);
		int deleteResult = dbTemplate
				.update("delete from bookings where BOOKING_ID in (select BOOKING_ID from booked_seats where to_char(booking_date_time,'YYYY-MM-DD')<? and hotel_id=?)",
						new Object[] { dateToCompare, hotel_id });
		return deleteResult;
	}

}