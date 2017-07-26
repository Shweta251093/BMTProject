package com.nttdata.pune.training.bookmytable.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nttdata.pune.training.bookmytable.model.beans.AdminSearchResults;
import com.nttdata.pune.training.bookmytable.model.beans.BillGenerator;
import com.nttdata.pune.training.bookmytable.model.beans.CheckedIn;
import com.nttdata.pune.training.bookmytable.model.beans.HotelTable;
import com.nttdata.pune.training.bookmytable.model.beans.Menu;
import com.nttdata.pune.training.bookmytable.model.beans.Offers;
import com.nttdata.pune.training.bookmytable.model.beans.Seats;
import com.nttdata.pune.training.bookmytable.model.beans.TableInfo;
import com.nttdata.pune.training.bookmytable.service.AdminOperation;
import com.nttdata.pune.training.bookmytable.service.Operation;

@Controller

@SessionAttributes({ "data", "adminSearchResults", "takeOrder1_table_id","orderList","orderData" ,"searchKeys"})


public class AdminController {

	//private static final int List = 0;

	@Autowired
	AdminOperation AdminOperationService;

	@Autowired
	Seats seats;

	@Autowired
	Operation operationService;

	// RequestMapping for Admin Home Page
	@RequestMapping(value = "/homeAdminView", method = RequestMethod.GET)
	public String homeAdminView(Model model, HttpServletRequest request) {

		// Refresh the seats table i.e. delete the seats table data of previous
		// dates
		
		operationService.deleteSeats();

		// //////////////////////////////////////////////////////////////////////////
		String hotel_id = (String) request.getSession().getAttribute("adminvalue");
		
		
		//Delete All previous Bookings details from bookings table 
		//AdminOperationService.deleteAllPreviousBookingDetails(hotel_id);
		// //////////////////////////////////////////////////////////////////////////
		
		if (hotel_id != null) {
			// add date-list for DropDown list in model
			model.addAttribute("dateList", AdminOperationService.getDateList());
			// set containts page name for Show in Admin Home Page
			model.addAttribute("containtPage", "admins/adminWelcomeImg.jsp");
			model.addAttribute("sidebarPage", "admins/hotelTablesView.jsp");
			// forword to "admins/homeAdminView.jsp" page

			/* End */
			return "admins/homeAdminView";
		}

		else {
			return "redirect:/user";
		}

	}

	// RequestMapping for searchOperation
		@RequestMapping(value = "/searchOperation", method = RequestMethod.POST)
		public String searchOperation(
				@ModelAttribute("searchSelect") String searchSelect,
				@ModelAttribute("key") String key,
				@ModelAttribute("date") String date, Model model,
				HttpServletRequest request) {
			
			
			// add date-list for DropDown list in model
			model.addAttribute("dateList", AdminOperationService.getDateList());
			String hotel_id=(String)request.getSession().getAttribute("adminvalue");
			
			if (searchSelect.equals("selectOption") ) {
				model.addAttribute("searchError",
						"Error..!!! Please Select Search By Option or Enter Search Key");
			}else{
			
				//adding all search keys for pop ups values
				List<String> searchKeys=new ArrayList<String>();
				searchKeys.add(searchSelect);
				searchKeys.add(key);
				searchKeys.add(date);
				model.addAttribute("searchKeys",searchKeys);
				
			List<AdminSearchResults> adminSearchResults =AdminOperationService.searchOperationBookingDetails(searchSelect,key,date,hotel_id);
			model.addAttribute("adminSearchResults", adminSearchResults);
			}
			
			
			// set containts page name for Show in Admin Home Page
			model.addAttribute("containtPage", "admins/searchResultTables.jsp");
			// set sidebarPage page name for Show in Admin Home Page
			model.addAttribute("sidebarPage", "admins/hotelTablesView.jsp");
			// forword to "admins/homeAdminView.jsp" page
			return "admins/homeAdminView";
		}
		
		// RequestMapping for checkInOperation 
			@RequestMapping(value = "/checkIn/{booking_Id}", method = RequestMethod.GET)
			public String checkInOperation(Model model,HttpServletRequest request,@PathVariable("booking_Id") String booking_Id){
				//getting Session Attribute for pop up Values
				@SuppressWarnings("unchecked")
				List<AdminSearchResults> adminSearchResultsList=(List<AdminSearchResults>)request.getSession().getAttribute("adminSearchResults");
				
				//calling getBookingDetailsFromList() method for find the data from list
				AdminSearchResults adminSearchResults=AdminOperationService.getBookingDetailsFromList(booking_Id, adminSearchResultsList);
				
				if(adminSearchResults==null){
					System.out.println("Sorry Null value of adminSearchResults");
				}
				else{
					model.addAttribute("checkInData", adminSearchResults);
					//get hotel id from session
					String hotel_id=(String)request.getSession().getAttribute("adminvalue");
					//to get table id from checked in table
					List<CheckedIn> tableIdListFromDB=AdminOperationService.getTableIdList(hotel_id);
					//method to get unreserved table id
					List<String> finalTableIdList= AdminOperationService.regeneratTableIdList(tableIdListFromDB);
					// add TableID List for DropDown list in model
					model.addAttribute("tableIdList", finalTableIdList);
				}
				
				
				// add date-list for DropDown list in model
				model.addAttribute("dateList", AdminOperationService.getDateList());
				// set containts page name for Show in Admin Home Page
				model.addAttribute("containtPage", "admins/searchResultTables.jsp");
				// set sidebarPage page name for Show in Admin Home Page
				model.addAttribute("sidebarPage", "admins/checkInView.jsp");
				// forword to "admins/homeAdminView.jsp" page
				return "admins/homeAdminView";

		}
			
			// RequestMapping for checkInProcess POST Method
			@RequestMapping(value ="/checkInProcess/{booking_Id}", method = RequestMethod.POST)
			public String checkInOperationProcess(@PathVariable("booking_Id") String booking_Id,@ModelAttribute("table_id") String table_id,
					@ModelAttribute("checkInAct") String checkInAct,
					Model model,HttpServletRequest request){
				
				
				if(checkInAct.equals("Confirm")){
					
					//get hotel id from session
					String hotel_id=(String)request.getSession().getAttribute("adminvalue");
					@SuppressWarnings("unchecked")
					List<String> searchKeys=(List<String>)request.getSession().getAttribute("searchKeys");
					System.out.println("searchKeys :"+searchKeys.get(2));
					
					//Checked_method for insert into Checked in table
					AdminOperationService.checkedInConform(booking_Id,table_id);
					
					//searchKeys list with values [searchSelect,key,date,hotel_id]
					List<AdminSearchResults> adminSearchResults =AdminOperationService.searchOperationBookingDetails(searchKeys.get(0),searchKeys.get(1),searchKeys.get(2),hotel_id);
					model.addAttribute("adminSearchResults", adminSearchResults);
					
					//calling getBookingDetailsFromList() method for find the data from list
					AdminSearchResults finaladminSearchResults=AdminOperationService.getBookingDetailsFromList(booking_Id, adminSearchResults);
					
					
					model.addAttribute("table_id", table_id);
					model.addAttribute("checkInData", finaladminSearchResults);
					// add date-list for DropDown list in model
					model.addAttribute("dateList", AdminOperationService.getDateList());
					// set containts page name for Show in Admin Home Page
					model.addAttribute("containtPage", "admins/searchResultTables.jsp");
					// set sidebarPage page name for Show in Admin Home Page
					model.addAttribute("sidebarPage", "admins/checkInStatusView.jsp");
					// forword to "admins/homeAdminView.jsp" page
					
					
				}else if(checkInAct.equals("Cancel")){
					// add date-list for DropDown list in model
					model.addAttribute("dateList", AdminOperationService.getDateList());
					// set sidebarPage page name for Show in Admin Home Page
					model.addAttribute("sidebarPage", "admins/hotelTablesView.jsp");
					// set containts page name for Show in Admin Home Page
					model.addAttribute("containtPage", "admins/searchResultTables.jsp");
					return "admins/homeAdminView";
				}
				
				return "admins/homeAdminView";
			}
	

	@RequestMapping(value = "/checkInProcessOk", method = RequestMethod.GET)
	public String checkInProcessOk(Model model) {
		// add date-list for DropDown list in model
		model.addAttribute("dateList", AdminOperationService.getDateList());
		// set sidebarPage page name for Show in Admin Home Page
		model.addAttribute("sidebarPage", "admins/hotelTablesView.jsp");
		// set containts page name for Show in Admin Home Page
		model.addAttribute("containtPage", "admins/searchResultTables.jsp");

		return "admins/homeAdminView";
	}

	@RequestMapping(value = "/viewTableinfo/{table_id}", method = RequestMethod.GET)
	public String viewTableinfo(@PathVariable("table_id") String table_id,
			Model model, HttpServletRequest request) {
		String hotel_Id = (String) request.getSession().getAttribute(
				"usernamevalue");
		TableInfo tableInfo = AdminOperationService.getTableInfo(table_id,
				hotel_Id);
		model.addAttribute("tableInfo", tableInfo);
		model.addAttribute("table_id", table_id);
		// add date-list for DropDown list in model
		model.addAttribute("dateList", AdminOperationService.getDateList());
		// set containts page name for Show in Admin Home Page
		model.addAttribute("containtPage", "admins/adminWelcomeImg.jsp");
		// set sidebarPage page name for Show in Admin Home Page
		model.addAttribute("sidebarPage", "admins/displayTableInfo.jsp");
		return "admins/homeAdminView";
	}

	@RequestMapping(value = "/diplayTableInfoOk", method = RequestMethod.GET)
	public String diplayTableInfoOk(Model model) {
		// add date-list for DropDown list in model
		model.addAttribute("dateList", AdminOperationService.getDateList());
		// set sidebarPage page name for Show in Admin Home Page
		model.addAttribute("sidebarPage", "admins/hotelTablesView.jsp");
		// set containts page name for Show in Admin Home Page
		model.addAttribute("containtPage", "admins/adminWelcomeImg.jsp");

		return "admins/homeAdminView";
	}
	
	@RequestMapping(value = "/advanceOperation", method = RequestMethod.GET)
	public String advanceOperation(Model model,HttpServletRequest request) {
		String hotel_id = (String) request.getSession().getAttribute("adminvalue");
		if(hotel_id!=null){
		// add date-list for DropDown list in model
				model.addAttribute("dateList", AdminOperationService.getDateList());
				// set sidebarPage page name for Show in Admin Home Page
				model.addAttribute("sidebarPage", "admins/advanceOperation.jsp");
				// set containts page name for Show in Admin Home Page
				model.addAttribute("containtPage", "admins/adminWelcomeImg.jsp");
				return "admins/homeAdminView";
		}
		else{
			return "redirect:/user";
		}
	}
	
		
	@RequestMapping(value = "/deleteAllPreviousBookings", method = RequestMethod.GET)
			public String deleteAllPreviousBookings(Model model,HttpServletRequest request ) {
		String hotel_id = (String) request.getSession().getAttribute("adminvalue");
		if(hotel_id!=null){
			
		//Delete All previous Bookings details from bookings table 
		AdminOperationService.deleteAllPreviousBookingDetails(hotel_id);
		model.addAttribute("message", "Delete Successfull...!!!");
		// add date-list for DropDown list in model
		model.addAttribute("dateList", AdminOperationService.getDateList());
		// set sidebarPage page name for Show in Admin Home Page
		model.addAttribute("sidebarPage", "admins/advanceOperation.jsp");
		// set containts page name for Show in Admin Home Page
		model.addAttribute("containtPage", "admins/adminWelcomeImg.jsp");
		return "admins/homeAdminView";
		}else{
			return "redirect:/user";
		}

	}
	

	@RequestMapping(value = "/menuDisplay", method = { RequestMethod.GET })
	public String dispalyMenu(Model model, HttpServletRequest request) {
		// getting hotel_id from session attribute (usernamevalue)
		String hotel_id = (String) request.getSession().getAttribute(
				"adminvalue");
		
		// calling operation service to get booked table information
		List<CheckedIn> listOfTableBook = operationService.selectBookedtable(hotel_id);
		for (CheckedIn check : listOfTableBook) {

			System.out.println(check.getTable_id());

		}
		
		// getting menu list of selected hotel_id
		List<Menu> listOfMenu = operationService.selectMenu(hotel_id);
		for (Menu menu : listOfMenu) {
			System.out.println(menu.getMenu_id());
		}
		// adding list of booked table into model
		model.addAttribute("listOfTableBook", listOfTableBook);
		// adding menu list of selected hotel_id into model
		model.addAttribute("data", listOfMenu);

		return "admins/menuDisplay";

	}

	@RequestMapping(value = "/seatsDisplay", method = { RequestMethod.GET })
	public String dispalySeats(Model model, HttpServletRequest request) {
		// List<Menu> listOfMenu = menuDAO.displayAllMenu();
		String hotel_id = (String) request.getSession().getAttribute(
				"adminvalue");
		List<Seats> listOfSeats = operationService.selectSeats(hotel_id);

		
		model.addAttribute("data", listOfSeats);

		return "admins/seatsDisplay";

	}

	@RequestMapping(value = "/takeOrder", method = { RequestMethod.GET })
	public String takeOrder(Model model, HttpServletRequest request,
			@RequestParam("table_id") String table_id) {
		
		String hotel_id = (String) request.getSession().getAttribute(
				"adminvalue");
		
		// getting menu list of selected hotel_id
		List<Menu> listOfMenu = operationService.selectMenu(hotel_id);
		model.addAttribute("data", listOfMenu);
		
		model.addAttribute("takeOrder1_table_id", table_id);

		return "admins/takeOrder";

	}

	@RequestMapping(value = "/takeOrder1", method = { RequestMethod.GET })
	public String sendData(@Valid @RequestParam("select") String menu,
			@RequestParam("quantity") String quantity, Model model,
			HttpServletRequest request) {

		// getting table id from session attribute(takeOrder1_table_id)
		String table_id = (String) request.getSession().getAttribute(
				"takeOrder1_table_id");
		System.out.println("=======>>>Hotel ID" + table_id);
		
		List<String> menuQuantity = new ArrayList<String>();

		//spliting logic for quantity

	//	spliting logic for quantity

		String[] array = quantity.split(",");
		
		for (int i = 0; i < array.length; i++) {
			if (!array[i].matches("null")) {

				String temp = array[i];
				menuQuantity.add(temp);

			} else {
				String temp1 = array[i];
				System.out.println(temp1);
			}
		}
		//spliting logic for menu_list
		List<String> orderedMenu = Arrays.asList(menu.split(","));

		
		model.addAttribute(orderedMenu);
		String hotel_id = (String) request.getSession().getAttribute(
				"adminvalue");
		// calling operation service to add customer order into hotel table

		operationService.insertHotelOrderOperation(table_id, hotel_id,
				orderedMenu, menuQuantity);

		return "admins/takeOrder";

	}

	@RequestMapping(value = "/showOrderTable")
	public String showOrder(Model model, HttpServletRequest request) {
		String table_id = (String) request.getSession().getAttribute(
				"takeOrder1_table_id");
		String hotel_id = (String) request.getSession().getAttribute(
				"adminvalue");
		// calling operation service to show order of selected table
		List<HotelTable> listOfOrder = operationService
				.showOrderTable(table_id,hotel_id);
		model.addAttribute("orderList", listOfOrder);
		return "admins/showOrderTable";

	}

	@RequestMapping(value = "/homeview")
	public String goToHome() {
		return "redirect:homeAdminView";


	}

	@RequestMapping(value = "/takeMenuData", method = { RequestMethod.GET })
	public String menuData(Model model,HttpServletRequest request) {
		String hotel_id = (String) request.getSession().getAttribute(
				"adminvalue");
		//List<Menu> menuList = operationService.selectMenu();
		List<Menu> menuList=operationService.displayMenu(hotel_id);

		model.addAttribute("menu", menuList);
		return "admins/takeMenuData";
	}


	@RequestMapping(value = "/updateSeatsFormDisplay", method = { RequestMethod.GET })
	public String timeData(Model model) {
		
		List<Seats> timeSlotData = operationService.selectTimeSlots();

		String dateTime = timeSlotData.get(0).getBooking_date();
		String date;
		// Take only date from date and time together
		date = dateTime.substring(0, 10);
		//Seats seat = new Seats();
		model.addAttribute("date", date);

		
		
		return "admins/updateSeatsForm";

	}

	/*@RequestMapping(value = "/insertNewMenu", method = RequestMethod.GET)
	public String insertNewMenu(Model model) {
		model.addAttribute("menu", new Menu());

	}*/
	@RequestMapping(value = "/insertNewMenu", method = RequestMethod.GET)
	public String insertNewMenu(Model model, HttpServletRequest request) {
		model.addAttribute("menu", new Menu());
		String hotelId= (String)request.getSession().getAttribute("adminvalue");
		System.out.println(hotelId);
		
		return "admins/insertNewMenu";
	}

	@RequestMapping(value = "/success", method = RequestMethod.POST)
	public String insertNewMenu(@ModelAttribute("menu") @Valid Menu menu,
			BindingResult result, Model model, HttpServletRequest request) {
		String hotelId= (String)request.getSession().getAttribute("adminvalue");
		
		// If error exists re-populate same form

		
	
		if (result.hasErrors()) {
			return "admins/insertNewMenu";
		} else {
			
			List<Menu> record=operationService.getMenuId(hotelId,menu.getMenu_id(), menu.getFood_name());
			
			if(record.size() == 0){
				
				//int status = operationService.insertMenuOperation(menu,hotelId);
				
				return "redirect:/homeAdminView";
			}
			else{
				
				model.addAttribute("message", "Record Already Exists");
				return "admins/insertNewMenu";
			}
					
		}

	}
		
	

	@RequestMapping(value = "/updateMenu2", method = RequestMethod.GET)
	public String updateForm(Model model) {

		Menu menu = new Menu();
		menu.setCategory("abc");
		menu.setFood_name("abc");
		model.addAttribute("menu", menu);

		return "admins/updateMenuForm";
	}

	
	@RequestMapping(value="updateMenuForm",method = RequestMethod.POST)
	public String updateMenuForm(/*@ModelAttribute("menu") @Valid Menu menu, BindingResult result,*/ 
			@RequestParam("menu_id") String menu_id,@RequestParam("rate") String rate,Model model,HttpServletRequest request){
		String hotel_id = (String) request.getSession().getAttribute(
				"adminvalue");
		System.out.println("*****************");
		System.out.println(menu_id);
		System.out.println(rate);
	

			//operationService.updateMenuOperation(menu);
		operationService.updateNewMenu(hotel_id,menu_id,rate);
			return "redirect:/homeAdminView";

		}


	@RequestMapping(value = "/updateSeatsForm123", method = RequestMethod.GET)
	public String updateSeatsForm(@ModelAttribute("seats") @Valid Seats seats,
			BindingResult result, Model model, HttpServletRequest request, @RequestParam("date") String date, @RequestParam("time") String time, @RequestParam("newseats") String newseats) {
		String hotel_id = (String) request.getSession().getAttribute(
				"adminvalue");
		

		operationService.updateSeats(hotel_id,date,time,newseats);
			//operationService.updateSeatsOperation(seats);
			return "redirect:/homeAdminView";

		}


	
	/*Controller to display existing offers to the hotel Admin*/
	@RequestMapping(value = "/myOffers", method = RequestMethod.POST)
	public String addOffers(Model model, @ModelAttribute("offers") Offers offers) {
		List<Offers> listOfOffers = AdminOperationService.getAllOffers();
		model.addAttribute("listOfOffers", listOfOffers);
		AdminOperationService.insert(offers);
		System.out.println(offers.toString());
		return "redirect:/myOffers";
	}
	
	
	/*Controller method Used to Add new Offers */
	@RequestMapping(value = "/myOffers", method = RequestMethod.GET)
	public String viewOffers(Model model) {
		List<Offers> listOfOffers = AdminOperationService.getAllOffers();
		System.out.println("we are checking offer_id");
		System.out.println(listOfOffers);
		List<Menu> listOfMenu = operationService.selectMenu();
		System.out.println(listOfMenu);
		model.addAttribute("listOfOffers", listOfOffers);
		model.addAttribute("listOfMenu", listOfMenu);
		model.addAttribute("offers", new Offers());
		return "admins/addOffer";

	}

	/*Controller Method to delete existing Offers*/
	@RequestMapping(value = "/myOffers/{hotel_id}/{offer_id}/{menu_id}")
	public String doDeleteOffer(Offers offers, Model model) {
		System.out.println("we are in delete");
		AdminOperationService.delete(offers);
		return "redirect:/myOffers";
	}
	
	

	//generating bill for particular table_id
	@RequestMapping(value = "/customerBill", method = RequestMethod.GET)
	public String BillGenerator(@ModelAttribute("table_id") String table_id,
			Model model, HttpServletRequest request) {
		int totalDiscount = 0;
		//getting session value as hotel_id
		String hotel_id = (String) request.getSession().getAttribute(
				"adminvalue");
		model.addAttribute("hotel_name", hotel_id);
		System.out.println(hotel_id);
		
		//getting table_id list for particular hotel
		List<CheckedIn> listOfTableBook = operationService.selectBookedtable(hotel_id);
		model.addAttribute("listOfTableBook", listOfTableBook);
		
		
		//get table_id,food_name,quantity,rate,subtotal from database
		List<BillGenerator> orderData = AdminOperationService.selectOrderData(
				hotel_id, table_id);
		model.addAttribute("orderData", orderData);
		
		//get discount amount from database
		List<BillGenerator> discountData = AdminOperationService
				.selectDiscountData(hotel_id, table_id);
		model.addAttribute("discountData", discountData);
		
		//getting discount amount from list and calculating its sum
		for (BillGenerator billGenerator : discountData) {
			System.out.println(billGenerator.getDiscountAmount());
			totalDiscount = Integer.parseInt(billGenerator.getDiscountAmount())
					+ totalDiscount;
		}
		
		System.out.println(totalDiscount);
		model.addAttribute("totalDiscount", totalDiscount);
		
		return "admins/customerBill";
	}

	//checkout operations performed 
	@RequestMapping(value = "/checkOut/{table_id}", method = RequestMethod.GET)
	public String CheckOut(@PathVariable("table_id") String table_id,
			Model model, HttpServletRequest request) {
		String hotel_id = (String) request.getSession().getAttribute("adminvalue");
		
		//orderData list is used to get foodname and quantity
		@SuppressWarnings("unchecked")
		List<BillGenerator> orderData = (List<BillGenerator>) request.getSession().getAttribute("orderData");
		
		for (BillGenerator billGenerator : orderData) {
			billGenerator.getFood_name();
			billGenerator.getQuantity();
		}
		
		//getting booking id from database
		CheckedIn booking_id = AdminOperationService.getBookingId(table_id,hotel_id);
		 List<BillGenerator> historyUserData = AdminOperationService.historyUserData(hotel_id,table_id,booking_id.getBooking_id());
		 
		 model.addAttribute("historyUserData",historyUserData);
		for (BillGenerator billGenerator : historyUserData) {
			System.out.println(billGenerator.getBooking_id());
			System.out.println(billGenerator.getUser_id());
		}
		
		System.out.println("Table IN CHECK OUT" + table_id);
		
		//inserting data into history table 
		int result = AdminOperationService.insertIntoHistory(historyUserData,orderData);
		System.out.println(result);
		
		model.addAttribute("historyUserData", historyUserData);
		
		//deleting data from database
		AdminOperationService.deleteOperationAfterCheckOut(historyUserData,hotel_id,table_id);
	
		return "redirect:/homeAdminView";
	}

}
