package com.atomicity.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.atomicity.dao.UsersDAO;
import com.atomicity.domain.Users;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@PathVariable("user") String username, @PathVariable("password") String password, Model m) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("beans.xml");
		UsersDAO uDAO = (UsersDAO) appCon.getBean("usersDAO");
		Users user = uDAO.getUserByName(username);

		boolean validAuthentication = false;
		if (user != null) {
			// Check if password is correct
			if (user.getPassword().equals(password)) {
				validAuthentication = true;
			} else {
				// wrong password...
				validAuthentication = false;
			}
		} else {
			// user doesn't exist
			validAuthentication = false;
		}

		// if authentication is valid
		if (validAuthentication) {
			m.addAttribute("firstname", user.getFirstName());
			m.addAttribute("lastname", user.getLastName());
			m.addAttribute("email", user.getEmail());
			m.addAttribute("username", username);
			((AbstractApplicationContext) appCon).close();
			return "account";
		} else {
			// For now, a simple denied message (will change this later
			((AbstractApplicationContext) appCon).close();
			return "error";
		}
	}
}
