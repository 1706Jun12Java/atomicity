package dao;

import static org.junit.Assert.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import customExceptions.*;
import util.Debug;
import util.HibernateUtil;
import domain.Users;

public class UsersDAOImpl implements UsersDAO {

	@Test
	public void testPush() {
		try {
			push(new Users("username1", "email@gmail.com", "password", "firstName", "lastName", false));
		} catch (UserNameTakenException e) {
			e.printStackTrace();
			fail();
		} catch (InvalidNameException e) {
			e.printStackTrace();
			fail();
		}
	}

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
	public void push(Users newUser) throws UserNameTakenException, InvalidNameException {
		// For debugging purposes:
		Debug.printMessage(this.getClass(), "push()", "Invoked");
		// Check if there are any empty Strings
		if (newUser.getUsername().isEmpty() || newUser.getPassword().isEmpty() || newUser.getFirstName().isEmpty()
				|| newUser.getLastName().isEmpty()) {
			throw new InvalidNameException("There is an empty String");
		}
		// Get the session
		Session sess = HibernateUtil.getSession();
		// Check to see if the username is taken
		Users userObj = getUserByName(newUser.getUsername());
		// If the list is not empty, a user with the name was found
		if (userObj != null) {
			sess.close();
			throw new UserNameTakenException("The username was found in the database");
		} else {
			// Otherwise, add the new user
			Transaction trans = sess.beginTransaction();
			// Debug
			Debug.printMessage(this.getClass(), "push()", "username available.");
			Debug.printErrorMessage(this.getClass(), "push()", "saving " + newUser.getUsername());
			sess.save(newUser);
			trans.commit();
			sess.close();
		}
		
		Debug.printMessage(this.getClass(), "push()", "Ended");

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
	public void updatePassword(Users user, String newVal) {
		Debug.printMessage(this.getClass(), "updatePassword()", "Invoked");
		Session sess = HibernateUtil.getSession();
		Transaction trans = sess.beginTransaction();
		user.setPassword(newVal);
		sess.update(user);
		trans.commit();
		sess.close();
		Debug.printMessage(this.getClass(), "updatePassword()", "Ended");
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
	public void updateFirstName(Users user, String newVal) {
		// For debugging purposes:
		Debug.printMessage(this.getClass(), "updateFirstName()", "Invoked");
		Session sess = HibernateUtil.getSession();
		Transaction trans = sess.beginTransaction();
		user.setFirstName(newVal);
		sess.update(user);
		trans.commit();
		sess.close();
		Debug.printMessage(this.getClass(), "updateFirstName()", "Ended");
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
	public void updateLastName(Users user, String newVal) {
		// For debugging purposes:
		Debug.printMessage(this.getClass(), "updateLastName()", "Invoked");
		Session sess = HibernateUtil.getSession();
		Transaction trans = sess.beginTransaction();
		user.setLastName(newVal);
		sess.update(user);
		trans.commit();
		sess.close();
		Debug.printMessage(this.getClass(), "updateLastName()", "Ended");
	}

	/**
	 * Returns the user with the given username
	 * 
	 * @param username
	 *            The username to find
	 */
	@Override
	public Users getUserByName(String username) {
		// For debugging purposes:
		Debug.printMessage(this.getClass(), "getUserByName()", "invoked");
		Session sess = HibernateUtil.getSession();
		Users user = (Users) sess.get(Users.class, username);
		sess.close();
		// For debugging purposes:
		
		Debug.printMessage(this.getClass(), "getUserByName()", "Ended returning: " + ((user==null) ? user:user.getUsername()));
		return user;
	}

	/**
	 * Returns a list of all users from A_USERS
	 */
	@Override
	public List<Users> getAllUsers() {
		// For debugging purposes:
		Debug.printMessage(this.getClass(), "getAllUsers()", "invoked");
		Session sess = HibernateUtil.getSession();
		Query query = sess.getNamedQuery("getAllUsers");
		List<Users> users = query.list();
		sess.close();
		return users;
	}

}
