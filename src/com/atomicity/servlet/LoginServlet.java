package com.atomicity.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.atomicity.dao.UsersDAO;
import com.atomicity.domain.Users;

/**
 * 
 * This is the login servlet
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -3084861696333587532L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}

	private void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Check if there is any user already logged in
		// Get session in order to store credentials
		HttpSession session = req.getSession();

		// Get user input (credentials)
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		// boolean for checking whether authentication is valid
		boolean validAuthentication = false;

		// Prepare to access the database
		// The Application Context is needed to instaniate the sessionFactory
		ApplicationContext appCon = new ClassPathXmlApplicationContext("beans.xml");
		UsersDAO uDAO = (UsersDAO) appCon.getBean("usersDAO");
		Users user = uDAO.getUserByName(username);
		System.out.println(user);
		System.out.println(username + " " + password);
		// if user exist:
		if (user != null) {
			// Check if password is correct
			if (user.getPassword().equals(password)) {
				validAuthentication = true;
			} else {
				// wrong password...
				validAuthentication = false;
			}
		} else {
			// user doesn't exist
			validAuthentication = false;
		}

		// if authentication is valid
		if (validAuthentication) {
			// Save user credentials
			session.setAttribute("user", user);

			// foward towards user account
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/account.jsp");
			rd.include(req, resp);
		} else {
			// For now, a simple denied message (will change this later)
			PrintWriter writer = resp.getWriter();
			resp.setContentType("text/html");
			writer.println("<h1>ACCESS DENIED</h1>");
		}
		((AbstractApplicationContext) appCon).close();
	}

}
