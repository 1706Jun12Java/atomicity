package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * This is the login servlet
 */
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		doService(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		doService(req, resp);
	}
	
	private void doService(HttpServletRequest req, HttpServletResponse resp) {
		// Check if there is any user already logged in
		HttpSession session = req.getSession();
		if(session.getAttribute("password") != null) {
			// TODO forward to profile page...
		}
		else {
			
		}
		
		
	}
	
}
