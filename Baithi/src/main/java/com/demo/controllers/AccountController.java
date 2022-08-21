package com.demo.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.Account;
import com.demo.models.Role;
import com.demo.services.AccountService;
import com.demo.services.RoleService;

@Controller
@RequestMapping({ "account" })
public class AccountController {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = { "","login"}, method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error , ModelMap modelMap) {
		if (error != null) {
			modelMap.put("msg", "invalid");
		}
		return "account/login";
	}
	
	@RequestMapping(value = { "","register"}, method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		//modelMap.put("roles", roleService.findAll());
		Account account = new Account();
		modelMap.put("account", account);
		return "account/register";
	}
//	/, @RequestParam("roles") int[] roles
	@RequestMapping(value = { "","register"}, method = RequestMethod.POST)
	public String login(@ModelAttribute("account") Account account) {
		String hash = encoder.encode(account.getPassword().trim());
		account.setPassword(hash);
		account.getRoles().clear();
		Role role = new Role();
		role.setId(2);
		role.setName("ROLE_USER");
		account.getRoles().add(role);
//		if(roles.length > 0) {
//			for (int role : roles) {
//				Role rol = new Role();
//				rol.setId(role);
//				account.getRoles().add(rol);
//			}
//		}
		accountService.save(account);
		return "redirect:/account/login";
	}
	
	
	@RequestMapping(value = {"edit"}, method = RequestMethod.GET)
	public String Edit(ModelMap modelMap) {
		return "account/edit";
	}
	
	@RequestMapping(value = {"edit"}, method = RequestMethod.POST)
	public String Edit(String password,Authentication authentication) {
		Account account = accountService.findByUsername(authentication.getName());
		String hash = encoder.encode(password.trim());
		account.setPassword(hash);
		accountService.save(account);
		return "redirect:/account/login";
	}
	
	
	@RequestMapping(value = {"home"}, method = RequestMethod.GET)
	public String welcome(Authentication authentication) {
		System.out.println("username: " + authentication.getName());
		return "home/index";
	}
	
	@RequestMapping(value = {"accessDenied"}, method = RequestMethod.GET)
	public String accessDenied() {
	
		return "account/accessDenied";
	}



}
