package com.apsdeveloper.app.ws.userservice;

import com.apsdeveloper.app.ws.ui.model.request.UserDetailRequestModel;
import com.apsdeveloper.app.ws.ui.model.response.UserRest;

public interface UserService {
		UserRest createUser( UserDetailRequestModel userDetails);
}
