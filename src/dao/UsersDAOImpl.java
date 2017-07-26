package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import customExceptions.*;
import util.HibernateUtil;
import domain.Users;

public class UsersDAOImpl implements UsersDAO {

	public UsersDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Adds a new user to the database
	 */
	@Override
	public void push(Users newUser) throws UserNameTakenException, InvalidNameException {
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
			sess.save(newUser);
			trans.commit();
			sess.close();
		}

	}

	@Override
	public void updatePassword(Users user, String newVal) {
		Session sess = HibernateUtil.getSession();
		Transaction trans = sess.beginTransaction();
		user.setPassword(newVal);
		sess.update(user);
		trans.commit();
		sess.close();
	}

	@Override
	public void updateFirstName(Users user, String newVal) {
		Session sess = HibernateUtil.getSession();
		Transaction trans = sess.beginTransaction();
		user.setFirstName(newVal);
		sess.update(user);
		trans.commit();
		sess.close();
	}

	@Override
	public void updateLastName(Users user, String newVal) {
		Session sess = HibernateUtil.getSession();
		Transaction trans = sess.beginTransaction();
		user.setLastName(newVal);
		sess.update(user);
		trans.commit();
		sess.close();
	}

	/**
	 * Returns the user with the given username
	 */
	@Override
	public Users getUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns a list of all users from A_USERS
	 */
	@Override
	public List<Users> getAllUsers() {
		Session sess = HibernateUtil.getSession();
		Query query = sess.getNamedQuery("getAllUsers");
		List<Users> users = query.list();
		sess.close();
		return users;
	}

}
