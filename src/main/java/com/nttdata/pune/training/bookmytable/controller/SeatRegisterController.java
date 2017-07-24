package com.nttdata.pune.training.bookmytable.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.nttdata.pune.training.bookmytable.model.beans.Seats;
import com.nttdata.pune.training.bookmytable.service.AdminOperation;
import com.nttdata.pune.training.bookmytable.service.Operation;

@Controller
public class SeatRegisterController {

	@Autowired
	Operation operationService;

	@Autowired
	AdminOperation adminOperation;

	@RequestMapping(value = "/enterseats", method = RequestMethod.GET)
	public String addSeats(Model model, HttpSession session) {

		String hotel_id = (String) session.getAttribute("adminvalue");

		// Check if session has the hotel_id

		if (hotel_id != null) {
			model.addAttribute("seats", new Seats());
			model.addAttribute("dateList", adminOperation.getDateList());
			return "general/enterSeats";
		} else {
			return "redirect:/user";
		}

	}

	@RequestMapping(value = "/enterseats", method = RequestMethod.POST)
	public String insertUser(@ModelAttribute("seats") @Valid Seats seats,
			BindingResult result, Model model, HttpSession session) {

		model.addAttribute("dateList", adminOperation.getDateList());

		if (result.hasErrors()) {
			// If has errors then go again to registration page

			return "general/enterSeats";

		} else {

			// Write code for writing data to the database

			// insert the seats in seats table for first time
		
			String hotel_id = (String) session.getAttribute("adminvalue");
			seats.setHotel_id(hotel_id);
			operationService.registerSeatsOperation(seats);

		}

		return "redirect:homeAdminView";

	}

}
