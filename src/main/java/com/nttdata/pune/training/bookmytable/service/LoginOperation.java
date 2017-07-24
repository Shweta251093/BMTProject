package com.nttdata.pune.training.bookmytable.service;

import java.sql.SQLException;
import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.LoginBean;

public interface LoginOperation {

	
	/*-------------------Declaration of data access object for login functionality---------------*/	
	
	//For user
	public List<LoginBean> validate(String username, String password) throws SQLException;
	//For Admin
	public List<LoginBean> validateAdmin(String username, String password) throws SQLException;
	//For Temporary Admin
	public List<LoginBean> validateTemporaryAdmin(String username, String password) throws SQLException;
}
