package com.atomicity.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginVerifyServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		doService(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		doService(req, resp);
	}
	
	private void doService(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		// Check if there is any user already logged in
		
		HttpSession session = req.getSession();
		if(session.getAttribute("user") != null) {
			RequestDispatcher rd = req.getRequestDispatcher("account.jsp");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("message", "my fav color is green");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
	}
}
