package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.nttdata.pune.training.bookmytable.model.beans.History;


public class ReviewRowMapper  implements RowMapper<History> {
	

	@Override
	public History mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		History history=new History();
			
		history.setReviewText(rs.getString("review"));
		history.setRatingText(rs.getString("rating"));
		
		return history;
		
	}
}
