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
	private final String UPDATE_MSG = "(Updated)";
	private final String VIEW_NAME = "update-user-info"; // After clicking an update button
	private final String DONE_VIEW_NAME = "profile"; // After clicking the 'done' button

	@RequestMapping("/update")
	public String goToUpdatePage() {
		return this.VIEW_NAME;
	}

	@RequestMapping("/doneUpdate")
	public String returnToAccount() {
		return this.DONE_VIEW_NAME;
	}

	@RequestMapping("/updateFirstname")
	public String updateFirstname(HttpServletRequest req, Model model) {
		// Get current user
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user.getFirstName());

		String newFirstname = req.getParameter("firstname");

		if (isUserSignedIn(user)) {
			model.addAttribute("updateMsg1", UPDATE_MSG);
			new UserDAOImpl().updateFirstName(user, newFirstname);
			user.setFirstName(newFirstname);
		} else {
			// Redirect to login page, if user not logged in
			return "login";
		}
		return VIEW_NAME;
	}


	@RequestMapping("/updateLastname")
	public String updateLastname(HttpServletRequest req, Model model) {
		// Get current user
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		String newLastname = req.getParameter("lastname");

		if (isUserSignedIn(user)) {
			model.addAttribute("updateMsg2", UPDATE_MSG);
			new UserDAOImpl().updateLastName(user, newLastname);
			user.setLastName(newLastname);
		} else {
			// Redirect to login page, if user not logged in
			return "login";
		}
		return VIEW_NAME;
	}


	@RequestMapping("/updateEmail")
	public String updateEmail(HttpServletRequest req, Model model) {
		// Get current user
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		String newEmail = req.getParameter("email");

		if (isUserSignedIn(user)) {
			model.addAttribute("updateMsg3", UPDATE_MSG);
			new UserDAOImpl().updateEmail(user, newEmail);
			user.setEmail(newEmail);

		} else {
			// Redirect to login page, if user not logged in
			return "login";
		}
		return VIEW_NAME;
	}


	@RequestMapping("/updatePassword")
	public String updatePassword(HttpServletRequest req, Model model) {
		// Get current user
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		String newPassword = req.getParameter("password");

		if (isUserSignedIn(user)) {
			model.addAttribute("updateMsg4", UPDATE_MSG);
			new UserDAOImpl().updatePassword(user, newPassword);
			user.setPassword(newPassword);
		} else {
			// Redirect to login page, if user not logged in
			return "login";
		}
		return VIEW_NAME;
	}

	// HELPER METHOD
	public boolean isUserSignedIn(User user) {
		System.out.println("|@| isUserSignedIn() returns: " + (user != null));
		return (user != null);
	}
}
