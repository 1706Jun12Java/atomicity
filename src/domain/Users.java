package domain;

import javax.persistence.*;

@NamedQueries({
	@NamedQuery(name="getAllUsers",query="FROM Users"),
	@NamedQuery(name="getUsersByUsername",query="FROM Users WHERE username = :var")
})

@Entity
@Table(name = "A_USERS")
public class Users {

	public Users(String username, String password, String firstName, String lastName, boolean blocked) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.blocked = blocked;
	}

	@Id
	@Column(name = "U_USERNAME")
	private String username;
	@Column(name = "U_PASSWORD")
	private String password;
	@Column(name = "U_FIRSTNAME")
	private String firstName;
	@Column(name = "U_LASTNAME")
	private String lastName;
	@Column(name = "BLOCKED")
	private boolean blocked;

	public String getUsername() {
		return username;
	}

	public Users setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public Users setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Users setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public Users setBlocked(boolean blocked) {
		this.blocked = blocked;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Users setPassword(String password) {
		this.password = password;
		return this;
	}

}
