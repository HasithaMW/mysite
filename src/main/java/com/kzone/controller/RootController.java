package com.kzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kzone.entity.User;
import com.kzone.service.UserService;

@Controller

@Component
public class RootController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping(value = "/")
	public String root(Model model) {
		model.addAttribute("user", new User());
//		User user = new User();
//		user.setUserName("kasuna");
//		user.setLastName("Sameera");
//		user.setPassword("123");
//		
//		userService.addUser(user);
		
//		User userByUserName = userService.getUserByUserName("kasuna");
//		
//		boolean matches = new BCryptPasswordEncoder().matches("123", userByUserName.getPassword());
//		System.err.println("matches "+matches);
		
		return "index.tile";
	}

	@RequestMapping(value = "/add")
	public String add(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/login")
	public String login(Model model) {
		return "login.tile";
	}
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login.tile");

		return model;

	}
	
}
