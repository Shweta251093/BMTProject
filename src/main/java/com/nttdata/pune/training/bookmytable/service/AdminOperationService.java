package com.nttdata.pune.training.bookmytable.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.pune.training.bookmytable.model.beans.AdminSearchResults;
import com.nttdata.pune.training.bookmytable.model.beans.BillGenerator;
import com.nttdata.pune.training.bookmytable.model.beans.Bookings;
import com.nttdata.pune.training.bookmytable.model.beans.CheckedIn;
import com.nttdata.pune.training.bookmytable.model.beans.HotelTable;
import com.nttdata.pune.training.bookmytable.model.beans.Offers;
import com.nttdata.pune.training.bookmytable.model.beans.TableInfo;
import com.nttdata.pune.training.bookmytable.repository.BookedSeatsDAO;
import com.nttdata.pune.training.bookmytable.repository.BookingsDAO;
import com.nttdata.pune.training.bookmytable.repository.CheckedInDAO;
import com.nttdata.pune.training.bookmytable.repository.HotelAdminDAO;
import com.nttdata.pune.training.bookmytable.repository.HotelTableDAO;
import com.nttdata.pune.training.bookmytable.repository.OffersDAO;
import com.nttdata.pune.training.bookmytable.repository.ViewTableInfoDAO;


@Service
public class AdminOperationService implements AdminOperation {
	@Autowired
	HotelAdminDAO hotelAdminDao;	
	
	@Autowired
	CheckedInDAO checkedInDAO; 
	
	@Autowired
	ViewTableInfoDAO viewTableInfoDAO;
	
	@Autowired
	BookingsDAO bookingsDAO ;
	@Autowired
	BookedSeatsDAO bookedSeatsDAO;
	@Autowired
	HotelTableDAO hotelTableDAO;
	
	public AdminOperationService() {
		// TODO Auto-generated constructor stub
	}
	
	// Method for getting Date list
		@Override
		public List<String> getDateList() {

			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			List<String> dateList = new ArrayList<String>();
			LocalDateTime now = LocalDateTime.now();
			/*
			 * for (int i = 0; i < 2; i++) { dateList.add(now.minusDays(2 -
			 * i).format(format)); }
			 */
			for (int i = 0; i < 5; i++) {
				dateList.add(now.plusDays(i).format(format));

			}
			return dateList;

			/*
			 * for (String e : dateList) { System.out.println("Then=" + e); }
			 */

		}
		
		
			// Method for getting TableID regeneratTableIdList 
				@Override
				public List<String> regeneratTableIdList(List<CheckedIn> tableIdListFromDB) {
					
					List<String> finalTableIdList=new ArrayList<String>();
					
					for(int tableId=1;tableId<=15;tableId++){
						int flag=0;
						for (CheckedIn tableIdlist : tableIdListFromDB) {
							if((Integer.toString(tableId)).equals(tableIdlist.getTable_id())){
								flag=1;
								break;
								}
						}
						if(flag==0){
							finalTableIdList.add(Integer.toString(tableId));
						}
						
					}

					return finalTableIdList;
				}

		
				
				// Method for Searching Operation... 
				@Override
				public List<AdminSearchResults> searchOperationBookingDetails(String searchSelect,String key,String date,String hotel_id){
				
					List<AdminSearchResults> adminSearchResults=new ArrayList<AdminSearchResults> ();
					if (searchSelect.equals("date")) {
						//search operation by date
						 adminSearchResults = getBookingDetails(date, "date",hotel_id);
						

					} else if (searchSelect.equals("bookingID")) {
							//search operation by bookingID
							 adminSearchResults = getBookingDetails(key, "bookingID",hotel_id);
							

					} else if (searchSelect.equals("userID")) {
						//search operation by userID
						 adminSearchResults = getBookingDetails(key, "userID",hotel_id);
					
					}
					return adminSearchResults;
				}
				

		@Override
		public TableInfo getTableInfo(String table_id,String hotel_id){
			
			TableInfo tableInfo = viewTableInfoDAO.selectTableInfo(table_id,hotel_id);
			return tableInfo;
		}

		
		@Override
		public List<AdminSearchResults> getBookingDetails(String key,String searchBy,String hotel_id){
			List<AdminSearchResults> adminSearchResults=hotelAdminDao.selectAllBookingDetails(key, searchBy,hotel_id);
			
			List<CheckedIn> bookingIdListFromDB = hotelAdminDao.selectCheckedInTableIdAndBookingIdList(hotel_id);
			
			for (AdminSearchResults adminSearchResultsObj : adminSearchResults) {
				int flag=0;
				for (CheckedIn checkedInBookingIdObj : bookingIdListFromDB) {
					if((adminSearchResultsObj.getBooking_id()).equals(checkedInBookingIdObj.getBooking_id())){
						flag=1;
						break;
						}
				}
				
				if(flag==0){
					adminSearchResultsObj.setStatus("Booked");
				}else{
					adminSearchResultsObj.setStatus("CheckedIn");
				}
			}
			
			
			return adminSearchResults;
		}
		
		@Override
		public AdminSearchResults getBookingDetailsFromList(String booking_Id,List<AdminSearchResults> AdminSearchResultsList){
			
			for (AdminSearchResults adminSearchResults : AdminSearchResultsList) {
				if(booking_Id.equals(adminSearchResults.getBooking_id())){
					return adminSearchResults;
				}
			}
			return null;
		}
		
		@Override
		public List<CheckedIn> getTableIdList(String hotel_id){
			List<CheckedIn> tableIdListFromDB = hotelAdminDao.selectCheckedInTableIdAndBookingIdList(hotel_id);
			return tableIdListFromDB;
		}
		
		@Override
		public int deleteAllPreviousBookingDetails(String hotel_id){
			
			int result=hotelAdminDao.deleteAllPreviosBookingsRecords(hotel_id);
			return result;
		}

		
		@Transactional
		@Override
		public void checkedInConform(String booking_Id,String table_id){
			CheckedIn checkedIn=new CheckedIn();
			checkedIn.setBooking_id(booking_Id);
			checkedIn.setTable_id(table_id);
			checkedInDAO.insert(checkedIn);
		}
		
		@Autowired
		OffersDAO offersDAO;
		
		@Override
		public List<Offers> getAllOffers() {
			// TODO Auto-generated method stub
			return offersDAO.getAllOffers();
			
		}
		
		
		@Override
		public void insert(Offers offers) {
			// TODO Auto-generated method stub
			offersDAO.insert(offers);
			
		}
		
		@Override
		public void delete(Offers offers){
			
			offersDAO.delete(offers);
		}

		@Override
		public List<BillGenerator> selectOrderData(String hotel_id,String table_id) {
			List<BillGenerator> selectOrderData = hotelAdminDao.selectOrder(hotel_id,table_id);
			return selectOrderData;
			
		}

		@Override
		public List<BillGenerator> selectDiscountData(String hotel_id,String table_id) {
			List<BillGenerator> selectDiscountData = hotelAdminDao.selectDiscountData(hotel_id, table_id);
			return selectDiscountData;
		}

		@Override
		public List<BillGenerator> historyUserData(String hotel_id,
				String table_id,String booking_id) {
			List<BillGenerator> historyUserData = hotelAdminDao.historyUserData(hotel_id, table_id,booking_id);
			return historyUserData;
		}
		
		
		@Transactional
		@Override
		public int insertIntoHistory(List<BillGenerator> historyUserData,List<BillGenerator> orderData){
			
			int insertIntoHistory = hotelAdminDao.insertIntoHistory(historyUserData,orderData);
			return insertIntoHistory;
			
		}
		
		
		@Transactional
		@Override
		public void deleteOperationAfterCheckOut(
				List<BillGenerator> historyUserData,
				 String hotel_id,String table_id) {
			BillGenerator billGeneratorObj= historyUserData.get(0);
			System.out.println(billGeneratorObj.getBooking_id());
			System.out.println(billGeneratorObj.getUser_id());
		
			//Delete from Hotel_table Table
			HotelTable hotelTableObj=new HotelTable();
			hotelTableObj.setTable_id(table_id);
			hotelTableObj.setHotel_id(hotel_id);
			hotelTableDAO.delete(hotelTableObj);
			
			System.out.println("delete from Hotel_table Table");
			
			//Delete from BOOKINGS Table
			Bookings bookings=new Bookings();
			bookings.setBooking_id(billGeneratorObj.getBooking_id());
			bookings.setUser_id(billGeneratorObj.getUser_id());
			bookingsDAO.delete(bookings);
			System.out.println("Delete from BOOKINGS Table");
		}

		@Override
		public CheckedIn getBookingId(String table_id,String hotel_id) {
			
			CheckedIn booking_id = checkedInDAO.getBookingId(table_id,hotel_id);
					return booking_id;
		}

		
}
