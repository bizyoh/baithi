package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.Account;
import com.demo.models.Booking;
import com.demo.models.Restauranttable;
import com.demo.models.Role;
import com.demo.models.Tabletype;
import com.demo.services.AccountService;
import com.demo.services.BookingService;
import com.demo.services.TableService;
import com.demo.services.TableTypeService;

@Controller
@RequestMapping({ "home" })
public class HomeController {

	@Autowired
	private TableService tableService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private TableTypeService tableTypeService;
	@Autowired
	private BookingService bookingService;
	@RequestMapping(value = { "","index"}, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		Iterable<Tabletype> tableTypes = tableTypeService.GetAll();
		System.out.println("types : "+tableTypes);
		for(Tabletype type : tableTypes) {
			System.out.println("type : "+type.getName());
		}
		modelMap.put("tabletypes", tableTypes);
		Iterable<Restauranttable> tables = tableService.findAll();
		System.out.println("table : "+tables);
		for(Restauranttable table : tables) {
			System.out.println("table : "+table.getTabletype().getName());
			System.out.println("seat : "+table.getSeat());
		}
		
		modelMap.put("tables", tables);
		
		return "home/index";
	}

	
	@RequestMapping(value = { "create"}, method = RequestMethod.POST)
	public String Create(@ModelAttribute("restauranttable") Restauranttable table) {
		
		tableService.save(table);
		return "redirect:/home/index";
	}
	


	@RequestMapping(value = { "booking"}, method = RequestMethod.GET)
	public String booking(@RequestParam("table")int id, Authentication authentication) {
		Account account =  accountService.findByUsername(authentication.getName());
		Booking booking = new Booking();
		booking.setAccount(account);
		booking.setRestauranttable(tableService.find(id));
		bookingService.save(booking);
		return "redirect:/home/index";
	}
	
	@RequestMapping(value = { "bookinglist"}, method = RequestMethod.GET)
	public String BookingList(ModelMap modelMap,Authentication authentication) {
		Account account =  accountService.findByUsername(authentication.getName());
		modelMap.addAttribute("bookings",account.getBookings());
		return "home/booking";
	}
}