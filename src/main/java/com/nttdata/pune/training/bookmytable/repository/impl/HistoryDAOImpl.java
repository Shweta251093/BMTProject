package com.nttdata.pune.training.bookmytable.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nttdata.pune.training.bookmytable.model.beans.History;
import com.nttdata.pune.training.bookmytable.repository.HistoryDAO;
import com.nttdata.pune.training.bookmytable.util.HistoryRowMapper;

/*pooja d --1:setting jdbctemplate  for releasing the database connections
 *2: insert method for insert query
 *3: getting all objects in the list and displaying it*/

@Repository
/*
 * @Repository – annotate HistoryDAOImpl at persistence layer, which will act as
 * database repository.
 */
public class HistoryDAOImpl implements HistoryDAO {
	@Autowired
	private JdbcTemplate dbTemplate;

	public void setJdbcTemplate(JdbcTemplate dbTemplate) {
		this.dbTemplate = dbTemplate;
	}

	// inserting history data in history table
	@Override
	public int insert(History history) {

		System.out.println("Hotel Id: " + history.getHotel_id());
		System.out.println("User Id: " + history.getUser_id());

		String insertQuery = "INSERT INTO history (user_id,booking_id,hotel_id,food_name,quantity,rating,review) VALUES ("
				+ history.getUser_id()
				+ ",'"
				+ history.getBooking_id()
				+ "',"
				+ history.getHotel_id()
				+ ",'"
				+ history.getFood_name()
				+ ",'"
				+ history.getQuantity()
				+ ",'"
				+ history.getRating()
				+ ",'"
				+ history.getReview() + "')";

		int i = dbTemplate.update(insertQuery);
		return i;

	}

	// displaying all history
	@Override
	public List<History> displayAllHistory(History history) {

		List<History> listHistory = dbTemplate
				.query("SELECT user_id,booking_id,hotel_id,food_name,quantity,rating,review FROM history where user_id=?",
						new Object[] { history.getUser_id() },
						new HistoryRowMapper());
		//this is used for selecting the view
		return listHistory;
	}

}
