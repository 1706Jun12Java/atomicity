package com.atomicity.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.atomicity.customExceptions.*;
import com.atomicity.domain.User;
import com.atomicity.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	/**
	 * Adds a new user to the database
	 * 
	 * @param newUser
	 *            The user to be added
	 * @throws UserNameTakenException
	 *             In the case a username is taken
	 * @throws InvalidNameException
	 *             If a field is left blank, but front end should prevent that
	 */
	@Override
	public void push(User newUser) throws UserNameTakenException, InvalidNameException {
		// Check if there are any empty Strings
		if (newUser.getUsername().isEmpty() || newUser.getPassword().isEmpty() || newUser.getFirstName().isEmpty()
				|| newUser.getLastName().isEmpty()) {
			throw new InvalidNameException("There is an empty String");
		}
		// Get the session
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		// Check to see if the username is taken
		User user = (User) sess.get(User.class, newUser.getUsername());
		// If the list is not empty, a user with the name was found
		if (user != null) {
			sess.close();
			throw new UserNameTakenException("The username was found in the database");
		} else {
			// Otherwise, add the new user
			sess.save(newUser);
			tx.commit();
			sess.close();
		}
	}

	/**
	 * Updates the User's password in the database
	 * 
	 * @param user
	 *            The user to change
	 * @param newVal
	 *            The new password
	 */
	@Override
	public void updatePassword(User user, String newVal) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		user.setPassword(newVal);
		sess.update(user);
		tx.commit();
		sess.close();
	}

	/**
	 * Updates the User's first name in the database
	 * 
	 * @param user
	 *            The user to change
	 * @param newVal
	 *            The new first name
	 */
	@Override
	public void updateFirstName(User user, String newVal) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		user.setFirstName(newVal);
		sess.update(user);
		tx.commit();
		sess.close();
	}

	/**
	 * Updates the User's last name in the database
	 * 
	 * @param user
	 *            The user to change
	 * @param newVal
	 *            The new last name
	 */
	@Override
	public void updateLastName(User user, String newVal) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		user.setLastName(newVal);
		sess.update(user);
		tx.commit();
		sess.close();
	}

	@Override
	public void updateBlocked(User user, boolean newVal) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		user.setBlocked(newVal);
		if(newVal) {
			user.setBlockedStr("blocked");
		}
		else {
			user.setBlockedStr("not blocked");
		}
		sess.update(user);
		tx.commit();
		sess.close();
	}

	@Override
	public void updateEmail(User user, String newVal) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		user.setEmail(newVal);
		sess.update(user);
		tx.commit();
		sess.close();
	}

	/**
	 * Returns the user with the given username
	 * 
	 * @param username
	 *            The username to find
	 * @throws UserNameDoesNotExistsException 
	 */
	@Override
	public User getUserByName(String username) throws UserNameDoesNotExistsException {
		Session sess = HibernateUtil.getSession();
		User user = (User) sess.get(User.class, username);
		sess.close();
		if (user == null) {
			throw new UserNameDoesNotExistsException();
		} else {
			return user;
		}
	}

	/**
	 * Returns a list of all users from A_USERS
	 */
	@Override
	public List<User> getAllUser() {
		// For debugging purposes:
		Session sess = HibernateUtil.getSession();
		Query query = sess.getNamedQuery("getAllUsers");
		List<User> users = query.list();
		sess.close();
		return users;
	}
	
	// Needed for null value return
	public User getUserByNameForRegister(String username) {
		Session sess = HibernateUtil.getSession();
		User user = (User) sess.get(User.class, username);
		sess.close();
		if (user == null) {
			return null;
		} else {
			return user;
		}
	}

}
