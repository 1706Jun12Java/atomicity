package com.atomicity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atomicity.dao.UserDAOImpl;
import com.atomicity.domain.User;
import com.atomicity.util.Debug;

@Controller
public class AdminBlockUserController {
	private final String SAME_PAGE = "admin-view-users";
	private final String USER_NOT_FOUND_MSG = "*User not found";
	private final String USER_BLOCKED_MSG = "*User Blocked";
	private final String USER_UNBLOCKED_MSG = "*User UnBlocked";
	
	 
	@RequestMapping("block")
	public String blockUser(HttpServletRequest req, Model model) {
		Debug.printMessage(this.getClass(), "blockUser()", "Invoked");
		String userToBlock = req.getParameter("userToBlock");
		
		User user = new UserDAOImpl().getUserByNameForRegister(userToBlock);
		if(user!=null) {
			new UserDAOImpl().updateBlocked(user, true);
			model.addAttribute("blockMessage", USER_BLOCKED_MSG);
			Debug.printMessage(this.getClass(), "blockUser()", USER_BLOCKED_MSG);
		}
		else {
			model.addAttribute("blockMessage", USER_NOT_FOUND_MSG);
			
			Debug.printErrorMessage(this.getClass(), "blockUser()", USER_NOT_FOUND_MSG);
		}
		
		Debug.printMessage(this.getClass(), "blockUser()", "ENDED");
		model.addAttribute("allUsers", new UserDAOImpl().getAllUser());
		return SAME_PAGE;
	}
	
	@RequestMapping("unBlock")
	public String unBlockUser(HttpServletRequest req, Model model) {
		Debug.printMessage(this.getClass(), "unBlockUser()", "Invoked");
		String userToUnBlock = req.getParameter("userToUnBlock");
		
		User user = new UserDAOImpl().getUserByNameForRegister(userToUnBlock);
		if(user!=null) {
			new UserDAOImpl().updateBlocked(user, false);
			model.addAttribute("unBlockMessage", USER_UNBLOCKED_MSG);
			Debug.printMessage(this.getClass(), "blockUser()", USER_UNBLOCKED_MSG);
		}
		else {
			model.addAttribute("unBlockMessage", USER_NOT_FOUND_MSG);
			
			Debug.printErrorMessage(this.getClass(), "unBlockUser()", USER_NOT_FOUND_MSG);
		}
		
		Debug.printMessage(this.getClass(), "unBlockUser()", "ENDED");
		model.addAttribute("allUsers", new UserDAOImpl().getAllUser());
		return SAME_PAGE;
	}
}
