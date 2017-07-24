package com.nttdata.pune.training.bookmytable.repository;

import com.nttdata.pune.training.bookmytable.model.beans.TableInfo;

public interface ViewTableInfoDAO {
	public TableInfo selectTableInfo(String table_id,String hotel_id);
}
