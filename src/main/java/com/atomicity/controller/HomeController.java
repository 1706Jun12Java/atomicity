package com.atomicity.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atomicity.domain.User;
import com.atomicity.util.Debug;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showPage(HttpSession session) {
		Debug.printMessage(this.getClass(), "showPage()", "Invoked");
		User user = (User) session.getAttribute("user");
		if (user != null) {
			if (user.getRole().equals(User.ADMIN_ROLE)) {
				return "account"; // returns to admin
			} else {
				return "account";
			}
		}
		return "index"; // returns to index if its not logged in
	}
}
