package com.nttdata.pune.training.bookmytable.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nttdata.pune.training.bookmytable.model.beans.HotelAdmin;
import com.nttdata.pune.training.bookmytable.service.Operation;

@Controller
public class SuperAdminController {
	
	@Autowired
	Operation operationService;
	@RequestMapping(value = "/superAdmin", method = RequestMethod.GET)
	public String admin(Model model, HttpSession session) {
		String superAdminSession=(String)session.getAttribute("superAdmin");
		if(superAdminSession!=null){
	List<HotelAdmin> hotelsList=operationService.selectHotelAdmin();
	model.addAttribute("tempHotelList",hotelsList);
	
	return "general/superAdmin";
	}
		
		else{
			return "redirect:/user";
			}
	}
	
	
	//Request Mapping for Particular Hotel Details
	
	@RequestMapping(value = "/hotelDetails/{hotel_id}/{hotel_name}/{location}/{contact_no}/{password}/", method = RequestMethod.GET)
	public String hotelDetails(@PathVariable("hotel_id") String hotel_id,@PathVariable("hotel_name")String hotel_name,@PathVariable("location") String location,@PathVariable("contact_no") String contact_no,@PathVariable("password") String password, Model model,HttpSession session) {
		
		//set hotel details and send it to hotel details page
		
		String superAdminSession=(String)session.getAttribute("superAdmin");
		if(superAdminSession!=null){
		model.addAttribute("hotel",hotel_id);
		model.addAttribute("hotel_name",hotel_name);
		model.addAttribute("location",location);
		model.addAttribute("contact_no", contact_no);
		model.addAttribute("password", password);
		return "general/hotelDetails";}
		else{
			return "redirect:/user";
		}
	}
	
	
	//Request Mapping for Delete hotel operation
	
	@RequestMapping(value = "/cancel/{hotel_id}/", method = RequestMethod.GET)
	
	//getting selected hotel_id by user
	public String hotelDelete(@PathVariable("hotel_id") String hotel_id,  Model model,HttpSession session) {
		
	//Calling service method to perform delete query on particular hotel 
		String superAdminSession=(String)session.getAttribute("superAdmin");
		if(superAdminSession!=null){
	operationService.deleteHotelOperation(hotel_id);
		
	//after perform delete operation successfully, redirect to super admin page
	return "redirect:/superAdmin";
		}
		else{
			return "redirect:/user";
		}
		
		}
	
	
	//Request Mapping for Confirm hotel operation
	
	@RequestMapping(value = "/confirm/{hotel_id}/{hotel_name}/{location}/{contact_no}/{password}/", method = RequestMethod.GET)
	
	//getting hotel details to confirm hotel
	public String hotelConfirm(@PathVariable("hotel_id") String hotel_id,@PathVariable("hotel_name")String hotel_name,@PathVariable("location") String location,@PathVariable("contact_no") String contact_no,@PathVariable("password") String password,  Model model,HttpSession session) {
		List<HotelAdmin> record=operationService.selectHotel(hotel_id);
		if(record.size()==0){
		//calling service method to perform insert temporary hotel details into permanent hotel table
		String superAdminSession=(String)session.getAttribute("superAdmin");
		if(superAdminSession!=null){
	operationService.insertTempHotel(hotel_id, hotel_name, location, contact_no, password);
	
	//after perform insert operation successfully, redirect to super admin page
	return "redirect:/superAdmin";}
		else{
			return "redirect:/user";
		}
		}
		else{
			
			return "redirect:/cancel/"+hotel_id+"/";
		}
		
	}

	
	
}