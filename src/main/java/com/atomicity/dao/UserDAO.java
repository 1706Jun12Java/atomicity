package com.atomicity.dao;

import java.util.List;

import com.atomicity.customExceptions.InvalidNameException;
import com.atomicity.customExceptions.UserNameTakenException;
import com.atomicity.domain.User;

public interface UserDAO {

	public void push(User newUser) throws UserNameTakenException, InvalidNameException;

	public void updatePassword(User user, String newVal);

	public void updateFirstName(User user, String newVal);

	public void updateLastName(User user, String newVal);

	public void updateEmail(User user, String newVal);

	void updateBlocked(User user, boolean blocked);

	public User getUserByName(String username);

	public List<User> getAllUser();

}