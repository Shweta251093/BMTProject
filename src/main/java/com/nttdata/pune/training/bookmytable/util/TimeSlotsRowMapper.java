package com.nttdata.pune.training.bookmytable.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.nttdata.pune.training.bookmytable.model.beans.Seats;

public class TimeSlotsRowMapper implements RowMapper<Seats>{

	@Override
	public Seats mapRow(ResultSet rs, int list) throws SQLException {
		Seats time=new Seats();
		time.setBooking_date(rs.getString("sysdate"));
		/*String newDate=time.getBooking_date();
		
		
		//
		Date myDate = new Date();
		System.out.println(myDate);
	String finalDate=new SimpleDateFormat("MM-dd-yyyy").format(newDate);
		time.setBooking_date(finalDate);
		//
		// TODO Auto-generated method stub
*/		return time;
	}

}
