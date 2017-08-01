package com.atomicity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String checkLoginCredentials(HttpServletRequest req, Model model) {
		// Get credentials
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// Check credentials with database
		// database code here...
		// ....
		// ...
		
		
		
		
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		
		
		return "testing";
	}
}
