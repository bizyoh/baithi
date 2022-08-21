package com.demo.controllers;

import java.util.Optional;

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
import com.demo.models.Tabletype;
import com.demo.services.AccountService;
import com.demo.services.BookingService;
import com.demo.services.TableService;
import com.demo.services.TableTypeService;

@Controller
@RequestMapping({ "homeadmin" })
public class HomeAdminController {
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
		modelMap.addAttribute("accounts", accountService.GetAll());
		return "homeadmin/index";
	}
	
	@RequestMapping(value = { "booking"}, method = RequestMethod.GET)
	public String ListBooking(ModelMap modelMap,@RequestParam("accountid")int accountid) {
		modelMap.addAttribute("bookings", accountService.findById(accountid).getBookings());
		return "homeadmin/bookinglist";
	}
	
	@RequestMapping(value = { "bookingdetaillist"}, method = RequestMethod.GET)
	public String ListBooking(ModelMap modelMap) {
		modelMap.addAttribute("bookings", bookingService.GetAll());
		return "homeadmin/bookingdetaillist";
	}
	

	@RequestMapping(value = { "table"}, method = RequestMethod.GET)
	public String ListTable(ModelMap modelMap) {
		modelMap.addAttribute("tables", tableService.findAll());
		return "homeadmin/table";
	}
	
	@RequestMapping(value = { "table/create"}, method = RequestMethod.GET)
	public String AddTableView(ModelMap modelMap) {
		modelMap.addAttribute("tabletypes",tableTypeService.GetAll());
		return "homeadmin/createtable";
	}
	
	
	@RequestMapping(value = { "table/create"}, method = RequestMethod.POST)
	public String AddTable(@RequestParam("seat")int seat,@RequestParam("tabletypeid") int id ) {
		Tabletype tabletype = tableTypeService.GetTableTypeById(id);
		Restauranttable table = new Restauranttable();
		table.setTabletype(tabletype);
		table.setSeat(seat);
		tableService.save(table);
		return "redirect:";
	}
	

	@RequestMapping(value = { "table/delete"}, method = RequestMethod.GET)
	public String DeleteTable(@RequestParam("table")int table) {
		tableService.delete(table);
		return "redirect:";
	}
	
	@RequestMapping(value = { "table/edit"}, method = RequestMethod.GET)
	public String EditTable(ModelMap modelMap,@RequestParam("table")int table) {
		modelMap.addAttribute("restauranttable",tableService.find(table));
		modelMap.addAttribute("tabletypes",tableTypeService.GetAll());
		return "homeadmin/tableedit";
	}
	
	
	@RequestMapping(value = { "table/edit"}, method = RequestMethod.POST)
	public String EditTable(@ModelAttribute("restauranttable") Restauranttable table,@RequestParam("tabletypeid")int id ) {
		table.setTabletype(tableTypeService.GetTableTypeById(id));
		tableService.save(table);
		return "redirect:";
	}

	
	
	@RequestMapping(value = { "tabletype"}, method = RequestMethod.POST)
	public String Create(@ModelAttribute("restauranttable") Restauranttable table) {
		
		tableService.save(table);
		return "redirect:/home/index";
	}
	


	@RequestMapping(value = { "tabletype"}, method = RequestMethod.GET)
	public String booking(ModelMap modelMap) {
		modelMap.addAttribute("tabletypes", tableTypeService.GetAll());
		return "homeadmin/tabletype";
	}
	
	@RequestMapping(value = { "tabletype/create"}, method = RequestMethod.GET)
	public String AddTableTypeView() {
		return "homeadmin/createtabletype";
	}
	
	
	@RequestMapping(value = { "tabletype/create"}, method = RequestMethod.POST)
	public String AddTableType( String name) {
		Tabletype tabletype = new Tabletype();
		tabletype.setName(name);
		tableTypeService.Save(tabletype);
		return "redirect:";
	}
	

	@RequestMapping(value = { "tabletype/delete"}, method = RequestMethod.GET)
	public String AddTableTypeView(@RequestParam("type")int type) {
		tableTypeService.Delete(type);
		return "redirect:";
	}
	
	@RequestMapping(value = { "tabletype/edit"}, method = RequestMethod.GET)
	public String DeleteTableType(ModelMap modelMap,@RequestParam("type")int type) {
		modelMap.addAttribute("tabletype",tableTypeService.GetById(type));
		return "homeadmin/tabletypeedit";
	}
	
	
	@RequestMapping(value = { "tabletype/edit"}, method = RequestMethod.POST)
	public String EditTableType(@ModelAttribute("tabletype") Tabletype tabletype) {
		tableTypeService.Save(tabletype);
		return "redirect:";
	}

}
