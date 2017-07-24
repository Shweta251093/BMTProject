package com.nttdata.pune.training.bookmytable.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nttdata.pune.training.bookmytable.model.beans.BookedSeats;
import com.nttdata.pune.training.bookmytable.model.beans.Bookings;
import com.nttdata.pune.training.bookmytable.model.beans.HotelAdminSeats;
import com.nttdata.pune.training.bookmytable.model.beans.Offers;
import com.nttdata.pune.training.bookmytable.model.beans.Seats;
import com.nttdata.pune.training.bookmytable.service.AdminOperation;
import com.nttdata.pune.training.bookmytable.service.Operation;

@Controller
public class ClientController {


	@Autowired
	Seats seats;
	
	@Autowired
	Bookings bookings;
	
	@Autowired
	BookedSeats bookedSeats;
	
	@Autowired
	Operation operationService;

	@Autowired
	AdminOperation AdminOperationService;

	int no_of_seats;
	String booking_date, booking_time;

	//finding hotels according to date and time and seats available
	@RequestMapping(value = "/userHome", method = { RequestMethod.POST })
	public String findHotel(Model model,@ModelAttribute("hotelList") HotelAdminSeats hotelAdminSeats,HttpSession session) {

		if(session.getAttribute("usernamevalue")!=null){
		//Getting no_of_seats,booking_date,booking_time form jsp view 
		no_of_seats = hotelAdminSeats.getNo_of_seats();
		booking_date = hotelAdminSeats.getBooking_date();
		booking_time = hotelAdminSeats.getBooking_time();
		
		//calling displayHotel to return search data for available seats in that hotel for that time
		List<HotelAdminSeats> listOfHotels = operationService.findHotel(
				no_of_seats, booking_date, booking_time);
		
		model.addAttribute("listHotel", listOfHotels);
		return "users/userHome";
		}		else{
			return "redirect:/user";
		}
	}

	@RequestMapping(value = "/userHome", method = { RequestMethod.GET })
	public String searchHotel(Model model,HttpSession session) {
		
		if(session.getAttribute("usernamevalue")!=null){
			// Refresh the seats table i.e. delete the seats table data of previous
			// dates
			operationService.deleteSeats();
			return "users/userHome";
		}else{
			return "redirect:/user";
		}
		
	
	}

	@RequestMapping(value = "/userHome/{hotel_id}/{old_seats}/", method = RequestMethod.GET)
	public String doBooking(@PathVariable("hotel_id") String hotel_id,
			@PathVariable("old_seats") int oldHotelSeats,
			HttpSession session) {

		
		if(session.getAttribute("usernamevalue")!=null){
			// Generating BookingId using random function
			String randomBookId = Integer.toString(new Random().nextInt(10000));

			// Concatenating commonBookingId with randomBookId
			String commonBookingID = "bkID";
			commonBookingID = commonBookingID.concat(randomBookId);
			bookedSeats.setBooking_id(commonBookingID);

			// Retrieving user_id of the user using session
			String user = (String) session.getAttribute("usernamevalue");

			// setting values in Bookings class object
			
			bookings.setUser_id(user);
			bookings.setBooking_id(commonBookingID);

			// calling insertBookingsOpeartion to insert user_id and booking_id in
			// 'Bookings' table
			operationService.insertBookingsOperation(bookings);

			// setting the values in BookedSeats object
			bookedSeats.setBooking_id(commonBookingID);
			bookedSeats.setHotel_id(hotel_id);
		    bookedSeats.setNo_of_seats(no_of_seats);
			bookedSeats.setBooking_date(booking_date);
			bookedSeats.setBooking_time(booking_time);

			// calculating the updated seats left in the corresponding hotel
			int updatedHotelSeats = oldHotelSeats - no_of_seats;
			System.out.println(updatedHotelSeats);

			// calling the insertBookedSeatsOpeartion to insert the entries in
			// 'BookedSeats' table
			operationService.insertBookedSeatsOperation(bookedSeats);
			
			seats.setNo_of_seats(updatedHotelSeats);
			seats.setHotel_id(hotel_id);
			seats.setBooking_date(booking_date);
			seats.setBooking_time(booking_time);

			// calling the updateSeatCount method to update the 'Seats' table with
			// the updated seat values for the corresponding date and time.
			operationService.updateSeatCount(seats);

			return "redirect:/userHome";
		}else{
			return "redirect:/user";
		}
		
	}

	/*Controller method used to display offers On client side*/
	@RequestMapping(value = "/viewOffers")
	public String viewOffers(Model model) {
		List<Offers> listOfOffers = AdminOperationService.getAllOffers();
		// System.out.println(listOfOffers);
		model.addAttribute("listOfOffers", listOfOffers);
		return "users/offers";
	}
	
	@RequestMapping(value="/aboutUs")
	public String viewAboutUs()
	{
		return "general/aboutUs";
	}

	
}
