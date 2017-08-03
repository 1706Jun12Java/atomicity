package com.atomicity.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atomicity.dao.TopicDAO;
import com.atomicity.dao.TopicDAOImpl;
import com.atomicity.domain.Topic;
import com.atomicity.domain.User;

@Controller
public class TopicSubmitController {

	@RequestMapping("/addTopicPage")
	public String toAddTopic() {
		return "addTopic";
	}

	@RequestMapping(value = "/submitTopic", method = RequestMethod.POST)
	public String addTopic(HttpServletRequest req) {
		HttpSession sess = req.getSession();
		String title = req.getParameter("title");
		String category = req.getParameter("category");
		String text = req.getParameter("text");
		TopicDAO dao = new TopicDAOImpl();
		User user = (User) sess.getAttribute("user");
		dao.push(new Topic(user.getUsername(), category, Calendar.getInstance().getTime(), title,
				text));
		return "testing";
	}
}
