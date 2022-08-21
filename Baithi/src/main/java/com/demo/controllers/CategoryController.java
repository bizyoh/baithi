package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "category" })
public class CategoryController {

	@RequestMapping(value = { "","index"}, method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		
		return "category/index";
	}


}
