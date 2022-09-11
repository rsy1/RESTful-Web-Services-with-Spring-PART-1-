package com.apsdeveloper.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailRequestModel {
	
	@NotNull(message="First Name required.")
	@Size(min=3, max=16, message="First Name must be at least 3 characters & not more than 16 characters")
	private String firstName;
	
	@NotNull(message="Last Name required.")
	@Size(min=3, max=16, message="Last Name must be at least 3 characters & not more than 16 characters")
	private String lastName;

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

}
