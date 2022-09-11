package com.apsdeveloper.app.ws.ui.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.apsdeveloper.app.ws.exception.UserServiceException;
import com.apsdeveloper.app.ws.ui.model.request.UpdateUserDetailRequestModel;
import com.apsdeveloper.app.ws.ui.model.request.UserDetailRequestModel;
import com.apsdeveloper.app.ws.ui.model.response.UserRest;
import com.apsdeveloper.app.ws.userservice.UserService;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserControler {

	Map<String, UserRest> users;
	
	@Autowired
	UserService userService;

	// Defining basic CRUD operation

	@GetMapping() // binding the method to http GET request
	public UserRest getUsers(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", required = false, defaultValue = "desc") String sort) { // Request map path
																									// parameter
		UserRest user = new UserRest();
		user.setEmail("royal.siyanata@gmail.com");
		user.setFirstName("Royal");
		user.setLastName("Siyanata");
		return user;
	}
	
	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })//binding the method to http GET Request	
	public ResponseEntity<UserRest> getUsers(@PathVariable String userId) { // user id is a request path parameter

		//String nullValue = null;
		//int nullValueLength = nullValue.length();
		
		//if(true)throw new UserServiceException("A User service exception is thrown.....");
		
		if (users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
	}

	// This webservice endpoint Recievess Json/XML payload and create a Java object
	// from the payload
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
				 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }) //binding the method to http POST Request																				
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailRequestModel userDetails) {
		
		UserRest returnValue = userService.createUser(userDetails);
		
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
			  	produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }) //binding the method to http PUT request
	public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailRequestModel userDetails) {
		UserRest storedUserDetails = users.get(userId);
		storedUserDetails.setFirstName(userDetails.getFirstName());
		storedUserDetails.setLastName(userDetails.getLastName());
		
		users.put(userId, storedUserDetails);
		
		return storedUserDetails;
	}

	@DeleteMapping(path="/{id}") // binding the method to http DELETE request
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
	
		users.remove(id);
		
		return ResponseEntity.noContent().build();
	}

	/*
	 * @GetMapping() //binding the method to http GET request public String
	 * getUsers(@RequestParam(value="page", defaultValue = "1", required = false)
	 * int page,
	 * 
	 * @RequestParam(value="limit", defaultValue = "50") int limit) { //Request map
	 * path parameter return "get uers was called with page = "+ page + " limit " +
	 * limit; }
	 */

}
