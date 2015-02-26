package com.kzone.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kzone.entity.User;

@Controller

@Component
public class RootController {


	@RequestMapping(value = "/")
	public ModelAndView root(Model model) {
		ModelAndView modelV = new ModelAndView();
		modelV.setViewName("index.tile");
		return modelV;
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
