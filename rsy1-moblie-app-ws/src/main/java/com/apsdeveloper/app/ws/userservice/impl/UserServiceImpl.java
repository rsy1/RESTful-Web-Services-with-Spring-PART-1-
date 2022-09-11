package com.apsdeveloper.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apsdeveloper.app.ws.shared.Utils;
import com.apsdeveloper.app.ws.ui.model.request.UserDetailRequestModel;
import com.apsdeveloper.app.ws.ui.model.response.UserRest;
import com.apsdeveloper.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {

	Map<String, UserRest> users;
	Utils utils;
	
	public UserServiceImpl() {}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}

	@Override
	public UserRest createUser(UserDetailRequestModel userDetails) {
		UserRest user = new UserRest();

		user.setEmail(userDetails.getEmail());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setPassword(userDetails.getPassword());

		String userId = utils.generateUserID();
		user.setUserId(userId);

		if (users == null)
			users = new HashMap<>();
		users.put(userId, user);
		return user;
	}

}
