package com.kzone.controller;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kzone.entity.User;
import com.kzone.service.UserService;

@Controller
@RequestMapping("/home")
@Component
public class HomeController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	public HomeController() {

	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public User getUser() {
		User user = new User();
		user.setUserId(120l);
		user.setUserName("kasun");
		System.out.println("HomeController.getUser()");
		return user;
	}

	@RequestMapping(value = "/save",method = RequestMethod.POST,consumes="application/json",produces = "application/json")
	@ResponseBody
	public String getSave(@RequestBody User user) {
		System.out.println(user);
//		User user = new User();
		user.setUserId(120l);
		user.setUserName("kasun");
		System.out.println("HomeController.getSave()");
		return "";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(ModelMap model) {
		model.addAttribute("message", "Hello World Spring MVC Framework!");
		return "home/index";
	}

	// @RequestMapping(value="/{owner}", method = RequestMethod.GET)
	// public String getForDay(@PathVariable("owner") String owner , Model
	// model){
	// System.err.println(owner);
	// return "home/index";
	// }

	@RequestMapping(value = "/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET)
	public String getMatric(@PathVariable String ownerId,
			@PathVariable String petId) {
		System.out.println(ownerId);
		System.out.println(petId);
		return "home/index";
	}

	@RequestMapping(value = "/user/{userName}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public User getPet(@PathVariable String userName, Model model) {
		User user = new User();
		user.setUserName(userName);
		user.setUserId(System.currentTimeMillis());
		return user;
	}

	@RequestMapping(value = "/pets/{petId}", method = RequestMethod.GET, params = "myParam=myValue")
	public void findPet(@PathVariable String petId, Model model) {
		// System.out.println(ownerId);
		System.out.println(petId);
	}

	@RequestMapping(value = "/okpage", method = RequestMethod.GET,produces = "text/html")
	public String getOkPage(){
		System.out.println("HomeController.getOkPage()");
		return "home/ok";
	}
}
