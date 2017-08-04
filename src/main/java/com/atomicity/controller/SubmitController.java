package com.atomicity.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.atomicity.dao.PostDAO;
import com.atomicity.dao.PostDAOImpl;
import com.atomicity.dao.TopicDAO;
import com.atomicity.dao.TopicDAOImpl;
import com.atomicity.domain.Post;
import com.atomicity.domain.Topic;
import com.atomicity.domain.User;

@Controller
public class SubmitController {

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
		dao.push(new Topic(user.getUsername(), category, Calendar.getInstance().getTime(), title, text));
		return "testing";
	}

	@RequestMapping(value = "/submitPost", method = RequestMethod.POST)
	public ModelAndView addPost(HttpServletRequest req) {
		HttpSession sess = req.getSession();
		String text = req.getParameter("text");
		User user = (User) sess.getAttribute("user");
		int id = Integer.parseInt(req.getParameter("topicID"));
		PostDAO dao = new PostDAOImpl();
		dao.push(new Post(id, text, user.getUsername(), Calendar.getInstance().getTime()));
		return new ModelAndView("redirect:/Topic/" + id + "/" + (String) req.getParameter("title"));
	}
}
