package com.atomicity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginVerifyController {
	
	@RequestMapping("/loginVerify")
	public String verifyLogin(Model model) {
		model.addAttribute("message", "Hello World");
		return "login";
	}
}
