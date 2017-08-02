package com.atomicity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atomicity.customExceptions.InvalidNameException;
import com.atomicity.customExceptions.UserNameTakenException;
import com.atomicity.dao.UserDAOImpl;
import com.atomicity.domain.User;

@Controller
public class RegisterController {
	private final String SAME_PAGE = "register";
	private final String NEXT_PAGE = "testing-page";
	private final String FIRSTNAME_BLANK_MSG = "Firstname cannot be blank";
	private final String LASTNAME_BLANK_MSG = "Lastname cannot be blank";
	private final String EMAIL_BLANK_MSG = "Email cannot be blank";
	private final String EMAIL_INVALID_MSG = "Email is invalid";
	private final String USERNAME_BLANK_MSG = "Username cannot be blank";
	private final String USERNAME_INVALID_MSG = "Username already exist";
	private final String PASSWORD_BLANK_MSG = "Password cannot be blank";
	private final String CPASSWORD_BLANK_MSG = "Confirmation Password cannot be blank";
	private final String CPASSWORD_MISMATCH_MSG = "Confirmation Password doesn't match password";
	
	
	
	
	
	@RequestMapping("/register")
	public String getRegisterForm(HttpServletRequest req, Model model) {
		
		// Get 
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String username= req.getParameter("username");
		String password= req.getParameter("password");
		String cpassword=req.getParameter("cpassword");
		
		boolean allowToRegister = true;
		
		if(isEmptyOrNull(firstname)) {
			allowToRegister = false;
			model.addAttribute("firstnameMSG", FIRSTNAME_BLANK_MSG);
		}
		
		if(isEmptyOrNull(lastname)) {
			allowToRegister = false;
			model.addAttribute("lastnameMSG", LASTNAME_BLANK_MSG);
		}
		
		if(isEmptyOrNull(email)) {
			allowToRegister = false;
			model.addAttribute("emailMSG", EMAIL_BLANK_MSG);
		}
		else if(!email.contains("@")) {
			allowToRegister = false;
			model.addAttribute("emailMSG", EMAIL_INVALID_MSG);
		}
		
		if(isEmptyOrNull(username)) {
			allowToRegister = false;
			model.addAttribute("usernameMSG", USERNAME_BLANK_MSG);
		}
		else if(doesUsernameExist(username)) {
			allowToRegister = false;
			model.addAttribute("usernameMSG", USERNAME_INVALID_MSG);
		}
		
		if(isEmptyOrNull(password)) {
			allowToRegister = false;
			model.addAttribute("passwordMSG", PASSWORD_BLANK_MSG);
		}
		
		if(isEmptyOrNull(cpassword)) {
			allowToRegister = false;
			model.addAttribute("cpasswordMSG", CPASSWORD_BLANK_MSG);
		}
		
		if(!(cpassword.equals(password))) {
			allowToRegister = false;
			model.addAttribute("cpasswordMMSG", CPASSWORD_MISMATCH_MSG);
		}
		
		
		if(allowToRegister) {
			
			User user = new User(username, email, password, firstname, lastname);
			try {
				new UserDAOImpl().push(user);
			} catch (UserNameTakenException e) {
				e.printStackTrace();
			} catch (InvalidNameException e) {
				e.printStackTrace();
			}
			
			
			return NEXT_PAGE;
		}
		else {
			return SAME_PAGE;
		}
	}
	
	@RequestMapping("/loginAfterRegister")
	public String goToLoginPage() {
		return "login";
	}
	
	
	// HELPER METHODS
	private boolean isEmptyOrNull(String str) {
		if(str == null || str.isEmpty()) {
			return true;
		}		
		return false;
	}
	
	private boolean doesUsernameExist(String username){
		User user;
		try {
			user = new UserDAOImpl().getUserByName(username);
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
		
		
		return false;
	}
	
	
}
