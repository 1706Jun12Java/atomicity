package com.atomicity.components;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component(value = "login")
public class LoginComponent {

	@NotNull
	private String username;
	@NotNull
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
