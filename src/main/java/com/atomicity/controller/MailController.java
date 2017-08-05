package com.atomicity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atomicity.dao.MailDAO;
import com.atomicity.dao.MailDAOImpl;
import com.atomicity.domain.Mail;
import com.atomicity.domain.User;

@Controller
public class MailController {

	@RequestMapping("/mailbox")
	public String goToMailBox(HttpServletRequest req, Model model) {
		HttpSession sess = req.getSession();
		MailDAO dao = new MailDAOImpl();
		User user = (User) sess.getAttribute("user");
		List<Mail> mail = dao.getMailByUsername(user.getUsername());
		System.out.println(mail);
		model.addAttribute("mail", mail);
		return "mailbox";
	}
}
