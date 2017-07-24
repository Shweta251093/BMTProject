package com.nttdata.pune.training.bookmytable.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nttdata.pune.training.bookmytable.model.beans.History;
import com.nttdata.pune.training.bookmytable.repository.ReviewDAO;
import com.nttdata.pune.training.bookmytable.util.ReviewRowMapper;
@Repository /*@Repository – annotate classes at persistence layer, which will act as database repository.*/
public class ReviewDAOImpl implements ReviewDAO {
	@Autowired
	 private JdbcTemplate dbTemplate;
	
	@Override
	public void update(History history) {
		// TODO Auto-generated method stub
		
		
		System.out.println("*****************************************");
		
		System.out.println("User Id: "+history.getUser_id());
		System.out.println("Booking ID: "+history.getBooking_id());
		System.out.println("ReviewText : "+history.getReviewText());
		System.out.println("RatingText: "+history.getRatingText());
		
		
		System.out.println("*****************************************");
		System.out.println(history.getReviewText());
		dbTemplate.update("update history set review=?,rating=? where user_id=? and booking_id=?",new Object[]{history.getReviewText(),history.getRatingText(),history.getUser_id(),history.getBooking_id()});
		
	}

	@Override
	public List<History> displayAllReviews(History history) {
		// TODO Auto-generated method stub
		
/*		List<Menu> listOfMenu=dbTemplate.query("select menu_id,food_name,rate,veg,category from menu",new MenuRowMapper());
*/		
		
		List<History> listOfReviews=dbTemplate.query("select review,rating from history",new ReviewRowMapper());

		System.out.println("hieeee");
	
		return listOfReviews;
		
	}

	


}

