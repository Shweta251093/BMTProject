package com.nttdata.pune.training.bookmytable.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.pune.training.bookmytable.model.beans.LoginBean;
import com.nttdata.pune.training.bookmytable.repository.LoginUserDao;



@Service
public class LoginOperationService implements LoginOperation{

/*----------------------------------Service Layer used for Business & DAO  DataBase Logic-----------------------------*/	
	@Autowired
	LoginUserDao userDao;
	
	
	@Override
	//For user
	public List<LoginBean> validate(String username,String password) throws SQLException {
		
	return (userDao.isValidUser(username, password));
			
	}
	//For Admin
	@Override
	public List<LoginBean> validateAdmin(String username,String password)throws SQLException {
		
	return (userDao.isValidAdmin(username, password));
	
	}
	//For Temporary Admin
	@Override
	public List<LoginBean> validateTemporaryAdmin(String username, String password) throws SQLException
	{
		return (userDao.isValidTemporaryAdmin(username, password));
	
	}

    }
