package com.atomicity.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginVerifyController {
	
	@RequestMapping("/loginVerify")
	public String loginVerify(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		HttpSession session = req.getSession();
		req.setAttribute("message", "Hello WOrld");
			
		return "login";
	}
}
