package com.atomicity.domain;

import javax.persistence.*;

@NamedQueries({ @NamedQuery(name = "getAllUsers", query = "FROM User"),
		@NamedQuery(name = "getUserByUsername", query = "FROM User user WHERE user.username = :var") })

@Entity
@Table(name = "A_USERS")
public class User {
	public static final String ADMIN_ROLE = "admin";
	public static final String USER_ROLE = "user";
	public User(String username, String email, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = this.USER_ROLE;
		this.blocked = false;
		blockedStr = blocked ? "blocked" : "not blocked";
	}

	public User(String username, String email, String password, String firstName, String lastName, boolean blocked) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.blocked = blocked;
		this.role = this.USER_ROLE;
		blockedStr = blocked ? "blocked" : "not blocked";
	}

	public User(String username, String role, String email, String password, String firstName, String lastName,
			boolean blocked) {
		super();
		this.username = username;
		this.role = role;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.blocked = blocked;
		blockedStr = blocked ? "blocked" : "not blocked";
	}

	public User() {
		super();
	}

	@Id
	@Column(name = "U_USERNAME")
	private String username;
	@Column(name = "U_ROLE")
	private String role;
	@Column(name = "U_EMAIL")
	private String email;
	@Column(name = "U_PASSWORD")
	private String password;
	@Column(name = "U_FIRSTNAME")
	private String firstName;
	@Column(name = "U_LASTNAME")
	private String lastName;
	@Column(name = "BLOCKED")
	private boolean blocked;
	
	private String blockedStr; // Needed for JSP purposes (admin-view-users.jsp)

	public String getBlockedStr() {
		return blockedStr;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setBlockedStr(String blockedStr) {
		this.blockedStr = blockedStr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", role=" + role + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", blocked=" + blocked + "]";
	}

}