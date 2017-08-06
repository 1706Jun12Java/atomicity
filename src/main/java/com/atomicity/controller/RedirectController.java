package com.atomicity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	@RequestMapping("/registerLink")
	public String showRegisterPage() {
		return "register";
	}
	
	@RequestMapping("/composeMail")
	public String goToSendMail() {
		return "sendMail";
	}
	
	@RequestMapping("/addTopicPage")
	public String toAddTopic() {
		return "addTopic";
	}
	
	@RequestMapping("/account")
	public String toAccount() {
		return "account";
	}
	
	@RequestMapping("/profile")
	public String toProfile() {
		return "profile";
	}
}
