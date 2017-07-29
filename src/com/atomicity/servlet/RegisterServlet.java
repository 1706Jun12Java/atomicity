package com.atomicity.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atomicity.customExceptions.InvalidNameException;
import com.atomicity.customExceptions.UserNameTakenException;
import com.atomicity.dao.UsersDAO;
import com.atomicity.domain.Users;
import com.atomicity.util.Debug;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = -489562739985545057L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Debug.printMessage(this.getClass(), "doGet()", "Invoked");
		doService(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Debug.printMessage(this.getClass(), "doPost()", "Invoked");
		doService(req, resp);
	}

	private void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Debug.printMessage(this.getClass(), "doService()", "Invoked");
		// Get parameters
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String username = req.getParameter("user");
		String password = req.getParameter("password");
		String cpassword = req.getParameter("cpassword");
		Users newUser = new Users(username, email, password, firstname, lastname);
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		pw.write("<h1>helloWorld!");

		try {
			ApplicationContext appCon = new ClassPathXmlApplicationContext("beans.xml");
			UsersDAO udao = (UsersDAO) appCon.getBean("usersDAO");
			System.out.println(newUser);
			udao.push(newUser);
			((AbstractApplicationContext) appCon).close();

		} catch (UserNameTakenException | InvalidNameException e) {
			e.printStackTrace();
		}
	}
}
