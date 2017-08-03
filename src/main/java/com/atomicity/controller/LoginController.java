package com.atomicity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		// Instaniate the dao
		// To be autowried later
		UserDAO dao = new UserDAOImpl();
		try {
			// Check to see if the username exists
			User user = dao.getUserByName(username);
			if (user.getPassword().equals(password)) {

				// Password matches, so we are going to want to
				// save the username
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				// we go to the site

				if (user.getRole().equals(User.ADMIN_ROLE)) {
					return "admin-view-users.jsp";
				} else {
					return "account";
				}
			} else {
				// Password is incorrect so we go back with the message
				model.addAttribute("error", "Password is incorrect");
				return "login";
			}

		} catch (UserNameDoesNotExistsException e) {
			// username does not exists
			model.addAttribute("error", "Username does not exists");
			return "login";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "index";
	}

}
