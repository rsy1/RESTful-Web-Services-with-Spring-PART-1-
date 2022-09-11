package com.apsdeveloper.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailRequestModel {
	@NotNull(message="First Name required.")
	@Size(min=3, max=16, message="First Name must be at least 3 characters & not more than 16 characters")
	private String firstName;
	
	@NotNull(message="Last Name required.")
	@Size(min=3, max=16, message="Last Name must be at least 3 characters & not more than 16 characters")
	private String lastName;
	
	@NotNull(message="Valid email required.")
	@Email
	private String email;
	
	@NotNull(message="Valid password required.")
	@Size(min=8, max=16, message="Password must be at least 8 characters & not more than 16 characters")
	private String password;

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

}
