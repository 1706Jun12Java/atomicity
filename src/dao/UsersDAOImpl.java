package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import customExceptions.*;
import util.Debug;
import util.HibernateUtil;
import domain.Users;

public class UsersDAOImpl implements UsersDAO {

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
		Debug.printMessage(this.getClass(), "push()", "invoked");
		
		// Check if there are any empty Strings
		if (newUser.getUsername().isEmpty() || newUser.getPassword().isEmpty() || newUser.getFirstName().isEmpty()
				|| newUser.getLastName().isEmpty()) {
			throw new InvalidNameException("There is an empty String");
		}
		// Get the session
		Session sess = HibernateUtil.getSession();
		// Check to see if the username is taken
		Query query = sess.getNamedQuery("getUsersByUsername");
		query.setString("var", newUser.getUsername());
		List<Users> users = query.list();
		// If the list is not empty, a user with the name was found
		if (!users.isEmpty()) {
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
		// For debugging purposes:
		Debug.printMessage(this.getClass(), "updatePassword()", "invoked");
		
		Session sess = HibernateUtil.getSession();
		Transaction trans = sess.beginTransaction();
		user.setPassword(newVal);
		sess.update(user);
		trans.commit();
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
	public void updateFirstName(Users user, String newVal) {
		// For debugging purposes:
		Debug.printMessage(this.getClass(), "updateFirstName()", "invoked");
		
		Session sess = HibernateUtil.getSession();
		Transaction trans = sess.beginTransaction();
		user.setFirstName(newVal);
		sess.update(user);
		trans.commit();
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
	public void updateLastName(Users user, String newVal) {
		// For debugging purposes:
		Debug.printMessage(this.getClass(), "updateLastName()", "invoked");
		
		Session sess = HibernateUtil.getSession();
		Transaction trans = sess.beginTransaction();
		user.setLastName(newVal);
		sess.update(user);
		trans.commit();
		sess.close();
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
