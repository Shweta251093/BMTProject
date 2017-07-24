package com.nttdata.pune.training.bookmytable.service;

import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.AdminSearchResults;
import com.nttdata.pune.training.bookmytable.model.beans.BillGenerator;
import com.nttdata.pune.training.bookmytable.model.beans.CheckedIn;
import com.nttdata.pune.training.bookmytable.model.beans.Offers;
import com.nttdata.pune.training.bookmytable.model.beans.TableInfo;


public interface AdminOperation {
	// Method for getting Date list
	public List<String> getDateList();

	public List<Offers> getAllOffers();
	
	public TableInfo getTableInfo(String table_id,String hotel_id);
	public List<AdminSearchResults> getBookingDetails(String key,String searchBy,String hotel_id);
	public AdminSearchResults getBookingDetailsFromList(String booking_Id,List<AdminSearchResults> AdminSearchResultsList);
	public void checkedInConform(String booking_Id,String table_id);
	public List<CheckedIn> getTableIdList(String hotel_id);
	public List<String> regeneratTableIdList(List<CheckedIn> tableIdListFromDB);
	public void insert(Offers offers);
	public void delete(Offers offers);
	public List<AdminSearchResults> searchOperationBookingDetails(String searchSelect,String key,String date,String hotel_id);
	public List<BillGenerator> selectOrderData(String hotel_id,String table_id);

	public List<BillGenerator> selectDiscountData(String hotel_id,String table_id);

	public List<BillGenerator> historyUserData(String hotel_id,String table_id,String booking_id);

	public int insertIntoHistory(List<BillGenerator> historyUserData,List<BillGenerator> orderData);
	
	public void deleteOperationAfterCheckOut(List<BillGenerator> historyUserData,String hotel_id,String table_id);

	public CheckedIn getBookingId(String table_id,String hotel_id);
	
	public int deleteAllPreviousBookingDetails(String hotel_id);


}
