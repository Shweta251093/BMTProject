package com.nttdata.pune.training.bookmytable.repository;

import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.CheckedIn;

public interface CheckedInDAO {
public void insert(CheckedIn checkedIn);
public void delete(CheckedIn checkedIn);
public List<CheckedIn> displayAllCheckedIn();
public List<CheckedIn>displayBookTable(String hotel_id);
public CheckedIn getBookingId(String table_id,String hotel_id);
}
