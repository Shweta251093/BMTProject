package com.nttdata.pune.training.bookmytable.welcome;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nttdata.pune.training.bookmytable.repository.MenuDAO;
import com.nttdata.pune.training.bookmytable.service.DBConnectionCheckService;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	@Autowired
	MenuDAO menuDAO;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	DBConnectionCheckService dbConnectionCheckService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
    
		return "welcome/home";
		// return "user/userLogin";
	}

	// Method to check if the db connection can be opened
	@RequestMapping(value = "/dbConnectCheck", method = { RequestMethod.GET })
	public String checkDBConnection(Model model ) {
		dbConnectionCheckService.canConnectToDB();
		
		
		return "redirect:?dbconnectSuccess";
	
	}

	
}
