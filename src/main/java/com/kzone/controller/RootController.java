package com.kzone.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.kzone.entity.User;

@Controller
@Component
public class RootController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "index";
	}

	@RequestMapping(value = "/")
	public String root(Model model) {
		User user = new User();
		user.setUserName("kasun");
		model.addAttribute("user", user);
		return "index";
	}

}
