package com.atomicity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atomicity.dao.TopicDAO;
import com.atomicity.dao.TopicDAOImpl;
import com.atomicity.domain.Topic;

@Controller
public class ForumController {

	@RequestMapping(value = "/{category}/topics", method = RequestMethod.GET)
	public String getTopics(HttpServletRequest req, @PathVariable("category") String category, Model model) {
		HttpSession sess = req.getSession();
		sess.setAttribute("category", category);
		model.addAttribute("category", "MISC");
		TopicDAO dao = new TopicDAOImpl();
		List<Topic> topics = dao.getTopicsByCategory(category);
		for (Topic t : topics) {
			t.generateURL();
		}
		System.out.println(topics);
		model.addAttribute("topics", topics);
		return "topics";

	}

	@RequestMapping(value = "/Topic/{id}/{title}", method = RequestMethod.GET)
	public String getPosts(@PathVariable("id") int id, @PathVariable("title") String title, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("id", id);
		return "posts";
	}

}
