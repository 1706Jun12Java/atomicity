package com.atomicity.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atomicity.dao.UsersDAOImpl;
import com.atomicity.domain.Users;

@Controller
public class UpdateInfoController {

	// ======== UPDATE FIRSTNAME ============//
	@RequestMapping("/updateFirstName")
	public String updateFirstName(HttpServletRequest req) {
		// Get new firstname
		String newFirstname = req.getParameter("firstname");

		// Get user currently logged in
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("user");

		// Update user's new first name
		new UsersDAOImpl().updateFirstName(user, newFirstname);

		return "";
	}

	// ======== UPDATE LASTNAME ===========//
	@RequestMapping("/updateLastName")
	public String updateLastName(HttpServletRequest req) {
		// Get new lastname
		String newLastname = req.getParameter("lastname");

		// Get user currently logged in
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("user");

		// Update user's new last name
		new UsersDAOImpl().updateLastName(user, newLastname);

		return "";
	}

	// ======== UPDATE EMAIL ===========//
	@RequestMapping("/updateEmail")
	public String updateEmail(HttpServletRequest req) {
		// Get new email
		String newEmail = req.getParameter("email");

		// Get user currently logged in
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("user");

		// TODO create DAO for updating email...
		// TODO call the DAO method for updateEmail

		return "";
	}

	//============= UPDATE PASSWORD ==============//
	@RequestMapping("/updatePassword")
	public String updatePassword(HttpServletRequest req) {
		// Get new password
		String newPassword = req.getParameter("password");

		// Get user currently logged in
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("user");

		// Update user's new password
		new UsersDAOImpl().updatePassword(user, newPassword);

		return "";
	}
}
