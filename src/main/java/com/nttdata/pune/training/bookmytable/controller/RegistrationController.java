package com.nttdata.pune.training.bookmytable.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nttdata.pune.training.bookmytable.model.beans.HotelAdmin;
import com.nttdata.pune.training.bookmytable.model.beans.Users;
import com.nttdata.pune.training.bookmytable.service.Operation;

@Controller
public class RegistrationController {

	@Autowired
	Operation operationService;

	@RequestMapping(value = "/customerRegistration", method = RequestMethod.GET)
	public String addUser(Model model) {

		model.addAttribute("users", new Users());

		return "general/customerRegistration";
	}

	@RequestMapping(value = "/customerRegistration", method = RequestMethod.POST)
	public String insertUser(@ModelAttribute @Valid Users users,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			// If has errors then go again to registration page
			return "general/customerRegistration";

		} else {

			List<String> record = operationService.hasUser(users.getUser_id());

			if (record.size() == 0) {

				// If record not exists already

				// Write code for writing data to the database

				int status = operationService.insertUsersOeration(users);

				System.out.println("Insert_User_Operation_Status: " + status);

				model.addAttribute("message","Successfully Registered");
				return "general/welcome";

			} else {
				model.addAttribute("message", "Record Already Exists");
				return "general/welcome";
			}

		}
	}

	@RequestMapping(value = "/hotelRegistration", method = RequestMethod.GET)
	public String addHotel(Model model) {

		model.addAttribute("hotel", new HotelAdmin());

		return "general/hotelRegistration";
	}

	@RequestMapping(value = "/hotelRegistration", method = RequestMethod.POST)
	public String insertHotel(@ModelAttribute("hotel") @Valid HotelAdmin hotel,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			// If has errors then go again to registration page
			return "general/hotelRegistration";

		} else {

			String hotel_id = hotel.getHotel_id();

			// get list if available in temp_hotel_admin table

			List<String> registerList = operationService
					.hasRegistered(hotel_id);

			// get list if available in perm_hotel_admin table
			List<HotelAdmin> record = operationService.selectHotel(hotel_id);

			if (registerList.size() != 0) {

				// If available in temp_admin_table

				model.addAttribute("message", "Record Already Exists");
				return "general/welcome";
			} else {
				
				if (record.size() == 0) {

					// If record not exists already

					// Write code for writing data to the database

					int status = operationService.insertHotelOperation(hotel);

					System.out.println("Insert_Hotel_Operation_Status: "
							+ status);

					return "admins/temporaryAdmin";
				} else {									
					
					model.addAttribute("message", "Record Already Exists");
					return "general/welcome";
				}
			}

		}
	}

}
