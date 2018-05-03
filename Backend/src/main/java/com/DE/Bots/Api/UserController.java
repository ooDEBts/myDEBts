package com.DE.Bots.Api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DE.Bots.Repository.UserRepo;
import com.DE.Bots.core.Model.User;

@RestController
public class UserController {
	@Autowired
	UserRepo userRepo;
	@RequestMapping(value = "/saveUser", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public String saveBook(@RequestBody User user) {
		User list = userRepo.findByContact(user.getContact());
		if (list == null) {
			User toSet = new User();
			toSet.setEmail(user.getEmail());
			toSet.setContact(user.getContact());
			toSet.setCreatedDate(new Date().getTime());
			toSet.setLastLogged(0L);
			toSet.setName(user.getName());
			toSet.setPassword(user.getPassword());
			toSet.setRobot(false);
			toSet.setRole(user.getRole());
			userRepo.save(toSet);
			return "User is Created";
		} else {
			return "Error";
		}
	}

	/*
	 * @RequestMapping(value = "/getUser", produces = "application/json", method
	 * = RequestMethod.GET) public List<User> getAll() {
	 * 
	 * return userRepo.findAll(); }
	 * 
	 * @RequestMapping(value = "/findUser", produces = "application/json",
	 * method = RequestMethod.GET) public List<User>
	 * getUser(@RequestParam("name") String name) {
	 * 
	 * return userRepo.findByName(name); }
	 */
}
