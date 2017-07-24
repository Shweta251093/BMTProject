package com.nttdata.pune.training.bookmytable.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nttdata.pune.training.bookmytable.model.beans.LoginBean;
import com.nttdata.pune.training.bookmytable.repository.LoginUserDao;
import com.nttdata.pune.training.bookmytable.util.AdminRowMapper;
import com.nttdata.pune.training.bookmytable.util.TemporaryAdminRowMapper;
import com.nttdata.pune.training.bookmytable.util.LoginUserRowMapper;



@Repository
public class LoginUserDaoImpl implements LoginUserDao {
	
	   /*------------------------------------------------------Fatching data from database---------------------------------------*/
	    
	    @Autowired
	    private JdbcTemplate dbTemplate;
	    
	
	    /*------------------------------------------------------Fatching data from User Table---------------------------------------*/
	    
	
	    @Override
		public List<LoginBean> isValidUser(String username, String password)
	    {
	    List<LoginBean> listUser = dbTemplate.query("Select User_id,FULL_NAME,Contact_no,Password from users where User_id =? and password =?", new Object[]{username,password},new LoginUserRowMapper());
         return listUser;
	     }
	    
	    /*------------------------------------------------------Fatching data from Permanent hotel Table---------------------------------------*/
	    
	     @Override
		public List<LoginBean> isValidAdmin(String username, String password) 
	     {
		 List<LoginBean> listAdmin = dbTemplate.query("Select hotel_id,hotel_name,location,Contact_no,Password from perm_hotel_admin where hotel_id =? and password =?", new Object[]{username,password},new AdminRowMapper());
		 return listAdmin;
	     }
	      
	     /*------------------------------------------------------Fatching data from Temporary hotel Table---------------------------------------*/
	      
	     
	     @Override
		public List<LoginBean> isValidTemporaryAdmin(String username, String password) 
	     {
		 List<LoginBean> listTempAdmin = dbTemplate.query("Select hotel_id,hotel_name,location,Contact_no,Password from temp_hotel_admin where hotel_id =? and password =?", new Object[]{username,password},new TemporaryAdminRowMapper());
		 return listTempAdmin;
	     }
         }
