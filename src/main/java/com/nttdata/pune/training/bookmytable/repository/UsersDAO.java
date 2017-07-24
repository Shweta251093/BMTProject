package com.nttdata.pune.training.bookmytable.repository;

import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.Users;

public interface UsersDAO {

	public int insert(Users users);
	public void update(Users users);
	public List<Users> displayAllUsers();	
	public List<String> hasUser(String user_id);
	
}
