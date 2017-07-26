package dao;

import java.util.List;

import customExceptions.InvalidNameException;
import customExceptions.UserNameTakenException;
import domain.Users;

public interface UsersDAO {

	public void push(Users newUser) throws UserNameTakenException, InvalidNameException;
	
	public void updatePassword(Users user, String newVal);
	
	public void updateFirstName(Users user, String newVal);
	
	public void updateLastName(Users user, String newVal);

	public Users getUserByName(String username);
	
	public List<Users> getAllUsers(); 

}
