package com.atomicity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atomicity.customExceptions.UserNameDoesNotExistsException;
import com.atomicity.dao.UserDAO;
import com.atomicity.dao.UserDAOImpl;
import com.atomicity.domain.User;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String checkLoginCredentials(HttpServletRequest req, Model model) {
		// Get credentials
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		UserDAO dao = new UserDAOImpl();
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		try {
			User user = dao.getUserByName(username);
			if (user.getPassword() == password) {
				return "account";
			} else {
				model.addAttribute("error", "Password is incorrect");
				return "login";
			}

		} catch (UserNameDoesNotExistsException e) {
			model.addAttribute("error", "Username does not exists");
			return "login";
		}

	}
}
