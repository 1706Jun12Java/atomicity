package com.atomicity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atomicity.dao.UserDAOImpl;

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
	
	@RequestMapping("/admin-view-users")
	public String toAdminViewUsers(Model model) {
		model.addAttribute("allUsers", new UserDAOImpl().getAllUser());
		return "admin-view-users";
	}
}
