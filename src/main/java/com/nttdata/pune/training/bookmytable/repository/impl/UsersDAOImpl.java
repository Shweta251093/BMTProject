package com.nttdata.pune.training.bookmytable.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nttdata.pune.training.bookmytable.model.beans.Users;
import com.nttdata.pune.training.bookmytable.repository.UsersDAO;
import com.nttdata.pune.training.bookmytable.util.UsersRowMapper;

@Repository
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	private JdbcTemplate dbTemplate;

	public UsersDAOImpl() {

	}

	@Override
	public int insert(Users toInsert) {

		int status = 0;

		// insert new record

		status = dbTemplate
				.update("insert into users(user_id,full_name,contact_no,password) values(?,?,?,?)",
						new Object[] { toInsert.getUser_id(),
								toInsert.getFull_name(),
								toInsert.getContact_no(),
								toInsert.getPassword() });

		return status;
	}

	@Override
	public void update(Users toUpdate) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Users> displayAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> hasUser(String user_id) {

		// Check whether user with particular user_id is available or not

		List<String> records = dbTemplate
				.query("select full_name from users where user_id=?",
						new Object[] { user_id },
						new UsersRowMapper());

		return records;
	}

}
