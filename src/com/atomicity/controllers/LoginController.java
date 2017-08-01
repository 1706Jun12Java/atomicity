package com.atomicity.controllers;

import javax.validation.Valid;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.atomicity.components.LoginComponent;
import com.atomicity.dao.UsersDAO;
import com.atomicity.domain.Users;

@Controller
public class LoginController {

	@RequestMapping(value = "/loggingIn", method = RequestMethod.POST)
	public String login(@Valid LoginComponent login, BindingResult br, Model m) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("beans.xml");
		UsersDAO uDAO = (UsersDAO) appCon.getBean("usersDAO");
		Users user = uDAO.getUserByName(login.getUsername());

		if (user != null) {
			// Check if password is correct
			if (user.getPassword().equals(login.getPassword())) {
				m.addAttribute("firstname", user.getFirstName());
				m.addAttribute("lastname", user.getLastName());
				m.addAttribute("email", user.getEmail());
				m.addAttribute("username", login.getUsername());
				((AbstractApplicationContext) appCon).close();
				return "account";
			} else {
				// Wrong Password
			}
		} else {
			// User/Password does not exists
		}
		((AbstractApplicationContext) appCon).close();
		return null;
	}
}
