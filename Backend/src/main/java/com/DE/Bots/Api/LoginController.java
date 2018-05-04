package com.DE.Bots.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DE.Bots.Repository.UserRepo;
import com.DE.Bots.core.Model.LoginDetails;
import com.DE.Bots.core.Model.User;

@RestController
public class LoginController {

	@Autowired
	UserRepo userRepo;

	@RequestMapping(value = "/login", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public LoginDetails login(@RequestBody User user) {
		User list = userRepo.findByContact(user.getContact());
		LoginDetails det = new LoginDetails();
		if (!(list == null) && list.getPassword().equals(user.getPassword())) {
			det.setRole(list.getRole());
			det.setStatus("User valid");
			det.setUserName(list.getName());
			return det;
		} else {
			det.setStatus("User invalid");
			return det;
		}
	}
}
