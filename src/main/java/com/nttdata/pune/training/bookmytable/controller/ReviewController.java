package com.nttdata.pune.training.bookmytable.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nttdata.pune.training.bookmytable.model.beans.History;
import com.nttdata.pune.training.bookmytable.repository.HistoryDAO;
import com.nttdata.pune.training.bookmytable.service.ReviewOperation;
import com.nttdata.pune.training.bookmytable.wrapperclass.ReviewForm;

@Controller
@Scope("session")
@SessionAttributes("usernamevalue")
public class ReviewController {
	
	protected static Logger logger = Logger.getLogger("ReviewController");

	
	@Autowired
	HistoryDAO historyDAO;
	
	@Autowired
	private ReviewOperation	ReviewOperationService;
	// RequestMapping for adding reviews in addreview page
	
	@RequestMapping(value = "/addreview.html", method = RequestMethod.GET)
	public String showAddReviewPage(
			@ModelAttribute("reviewform") ReviewForm reviewForm, Model model1,HttpSession session) {
		
		History history = new History();
		
		//System.out.println("User in Session-------------------->"+(String)session.getAttribute("usernamevalue"));
		// getting Session Attribute for pop up Values
		history.setUser_id((String)session.getAttribute("usernamevalue"));
		//set the content of history
		model1.addAttribute("history", history);


		
		
		return "reviewView/addreview";
	}


	@RequestMapping(value = "/reviews", method = RequestMethod.GET)
	public String addGreetingAndShowAll(
			@ModelAttribute("history") History history,
			 Model model2,HttpSession session) {

		// getting Session Attribute for pop up Values
		
		history.setUser_id((String)session.getAttribute("usernamevalue"));
		
		ReviewOperationService.update(history);
		//storing current review and rating text
		model2.addAttribute("history", history);
		System.out.println("suceesfull");

		List<History> listOfHistory = historyDAO.displayAllHistory(history );
		
		for (History history1 : listOfHistory) {
			System.out.println(history1.getUser_id());
			System.out.println(history1.getBooking_id());
			System.out.println(history1.getHotel_id());
			System.out.println(history1.getFood_name());
			System.out.println(history1.getQuantity());
			System.out.println(history1.getRating());
			System.out.println(history1.getReview());

		}
		model2.addAttribute("data", listOfHistory);
		return "history/viewhistory";	
		//return "review/reviews";
	}
}
