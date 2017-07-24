package com.nttdata.pune.training.bookmytable.repository;

import java.sql.SQLException;
import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.LoginBean;

public interface LoginUserDao {

/*-------------------Declaration of data access object for login functionality---------------*/	
	
	//For user
	public List<LoginBean> isValidUser(String username, String password) throws SQLException; 
	//For Admin
	public List<LoginBean> isValidAdmin(String username, String password) throws SQLException;
	//For Temporary Admin
	public List<LoginBean> isValidTemporaryAdmin(String username, String password) throws SQLException;
}
