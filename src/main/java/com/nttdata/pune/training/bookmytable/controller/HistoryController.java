package com.nttdata.pune.training.bookmytable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nttdata.pune.training.bookmytable.model.beans.History;
import com.nttdata.pune.training.bookmytable.repository.HistoryDAO;

@Controller
/*
 * @Controller – annotate classes at presentation layers level, mainly used in
 * Spring MVC.
 */
@Scope("session")
@SessionAttributes("usernamevalue")
public class HistoryController {
	private static final History History = null;
	@Autowired
	HistoryDAO historyDAO;

	
	  @RequestMapping(value = "/history1", method = RequestMethod.GET) public
	  String addUser(Model model) {
	  
	  
	 
	  return "history/viewhistory"; }
	 
	// RequestMapping for View History Page
	@RequestMapping(value = "/history", method = { RequestMethod.GET })
	public String dispalyHistory(Model model) {
		// add all history table data in list
		List<History> listOfHistory = historyDAO.displayAllHistory(History);

		for (History history : listOfHistory) {
			System.out.println(history.getUser_id());
			System.out.println(history.getBooking_id());
			System.out.println(history.getHotel_id());
			System.out.println(history.getFood_name());
			System.out.println(history.getQuantity());
			System.out.println(history.getRating());
			System.out.println(history.getReview());

		}
		// sets the content of history in list
		model.addAttribute("data", listOfHistory);
		// forword to "history/viewhistory.jsp" page
		return "history/viewhistory";

	}

}