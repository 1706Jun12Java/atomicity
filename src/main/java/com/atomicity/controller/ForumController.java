package com.atomicity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ForumController {

	@RequestMapping(value = "/{category}/topics", method = RequestMethod.GET)
	public String getTopics(HttpServletRequest req, @PathVariable String category, Model model) {
		HttpSession sess = req.getSession();
		sess.setAttribute("category", category);
		return "testing";

	}

}
