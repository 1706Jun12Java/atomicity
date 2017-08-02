package com.atomicity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atomicity.dao.UserDAOImpl;
import com.atomicity.domain.User;

@Controller
public class UpdateUserInfo {
	private final String VIEW_NAME = ""; // After clicking an update button
	private final String DONE_VIEW_NAME = ""; // After clicking the 'done' button
	
	@RequestMapping("/updateFirstname")
	public String updateFirstname(HttpServletRequest req, Model model) {
		// Get current user
		HttpSession session = req.getSession();
		User user = (User) req.getAttribute("user");
		
		String newFirstname = req.getParameter("firstname");
		
		if(isUserSignedIn(user)) {
			new UserDAOImpl().updateFirstName(user, newFirstname);
		}
		else {
			// Redirect to login page, if user not logged in 
			return "login";			
		}
		return VIEW_NAME;
	}
	
	@RequestMapping("/updateLastname")
	public String updateLastname(HttpServletRequest req, Model model) {
		// Get current user
		HttpSession session = req.getSession();
		User user = (User) req.getAttribute("user");
		
		String newFirstname = req.getParameter("firstname");
		
		if(isUserSignedIn(user)) {
			new UserDAOImpl().updateFirstName(user, newFirstname);
		}
		else {
			// Redirect to login page, if user not logged in 
			return "login";			
		}
		return VIEW_NAME;
	}
	
	@RequestMapping("/updateEmail")
	public String updateEmail(HttpServletRequest req, Model model) {
		// Get current user
		HttpSession session = req.getSession();
		User user = (User) req.getAttribute("user");
		
		String newFirstname = req.getParameter("firstname");
		
		if(isUserSignedIn(user)) {
			new UserDAOImpl().updateFirstName(user, newFirstname);
		}
		else {
			// Redirect to login page, if user not logged in 
			return "login";			
		}
		return VIEW_NAME;
	}
	
	@RequestMapping("/updatePassword")
	public String updatePassword(HttpServletRequest req, Model model) {
		// Get current user
		HttpSession session = req.getSession();
		User user = (User) req.getAttribute("user");
		
		String newFirstname = req.getParameter("firstname");
		
		if(isUserSignedIn(user)) {
			new UserDAOImpl().updateFirstName(user, newFirstname);
		}
		else {
			// Redirect to login page, if user not logged in 
			return "login";			
		}
		return VIEW_NAME;
	}
	
	
	// HELPER METHOD
	public boolean isUserSignedIn(User user) {
		return (user != null);
	}
}
