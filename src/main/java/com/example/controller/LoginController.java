/**
 * 
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.service.UserService;

/**
 * @author WM87
 *
 */

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcomePage");
		System.out.println("Welcome Page::::::");
		return model;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		System.out.println("Index Page::::::");
		return model;
	}

	@RequestMapping(value = { "/homePage" }, method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("homePage");
		System.out.println("Home Page:::::");
		return model;
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		System.out.println("Here in Login Page::");
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out from JournalDEV successfully.");
		}

		model.setViewName("loginPage");
		return model;
	}

	@RequestMapping(value = "/newuser", method = RequestMethod.GET)
	@ResponseBody
	public String newUser() {

		User user = new User();
		user.setUsername("pavan");
		// user.setPassword("pavan");
		user.setPassword(passwordEncoder.encode("pavan"));

		userService.createUser(user);

		return "Sucess: User created Successfully";
	}

	@RequestMapping(value = "/forgotPassword/{username}", method = RequestMethod.GET)
	@ResponseBody
	public String forgotPassword(@PathVariable String username) {

		// Create a Token
		User user = userService.findByUsername("pavan");
		if (user != null) {

		}

		return null;

		/*
		 * User user = new User(); user.setUsername("pavan"); //
		 * user.setPassword("pavan");
		 * user.setPassword(passwordEncoder.encode("pavan"));
		 * 
		 * userService.createUser(user);
		 * 
		 * return "Sucess: User created Successfully";
		 */
	}

}
