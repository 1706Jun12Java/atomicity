package com.atomicity.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.atomicity.customExceptions.UserNameDoesNotExistsException;
import com.atomicity.dao.MailDAO;
import com.atomicity.dao.MailDAOImpl;
import com.atomicity.dao.PostDAO;
import com.atomicity.dao.PostDAOImpl;
import com.atomicity.dao.TopicDAO;
import com.atomicity.dao.TopicDAOImpl;
import com.atomicity.dao.UserDAO;
import com.atomicity.dao.UserDAOImpl;
import com.atomicity.domain.Mail;
import com.atomicity.domain.Post;
import com.atomicity.domain.Topic;
import com.atomicity.domain.User;

@Controller
public class SubmitController {

	@RequestMapping(value = "/submitTopic", method = RequestMethod.POST)
	public ModelAndView addTopic(HttpServletRequest req) {
		HttpSession sess = req.getSession();
		String title = req.getParameter("title");
		String category = req.getParameter("category");
		String text = req.getParameter("text");
		TopicDAO dao = new TopicDAOImpl();
		User user = (User) sess.getAttribute("user");
		dao.push(new Topic(user.getUsername(), category, Calendar.getInstance().getTime(), title, text));
		return new ModelAndView("redirect:/" + category + "/topics");
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

	@RequestMapping("/submitMail")
	public ModelAndView goToSendMail(HttpServletRequest req, Model model) {
		HttpSession sess = req.getSession();
		User user = (User) sess.getAttribute("user");
		UserDAO udao = new UserDAOImpl();
		String receiver = (String) req.getParameter("receiver");
		String text = (String) req.getParameter("text");
		String title = (String) req.getParameter("title");
		if (user.getUsername().equals(receiver)) {
			model.addAttribute("error", "You can't send yourself mail");
			return new ModelAndView("sendMail");
		}
		if (text.isEmpty()) {
			model.addAttribute("error", "There is no text");
			return new ModelAndView("sendMail");
		}
		try {
			udao.getUserByName(receiver);
		} catch (UserNameDoesNotExistsException e) {
			model.addAttribute("error", "There is no such user");
			return new ModelAndView("sendMail");
		}
		MailDAO mdao = new MailDAOImpl();
		if (title == null)
			mdao.push(new Mail(receiver, user.getUsername(), title, text, Calendar.getInstance().getTime()));
		else
			mdao.push(new Mail(receiver, user.getUsername(), "No Subject", text, Calendar.getInstance().getTime()));
		return new ModelAndView("redirect:/mailbox");
	}
}
