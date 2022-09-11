package com.apsdeveloper.app.ws.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.apsdeveloper.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> hanadleException(Exception exc, WebRequest webRequest) {

		String errorMessageDescription = exc.getLocalizedMessage();

		if (errorMessageDescription == null)
			errorMessageDescription = exc.toString();

		ErrorMessage message = new ErrorMessage(new Date(), errorMessageDescription);

		return new ResponseEntity<Object>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { NullPointerException.class, UserServiceException.class })
	public ResponseEntity<Object> hanadlNullPointereException(Exception exc, WebRequest webRequest) {

		String errorMessageDescription = exc.getLocalizedMessage();

		if (errorMessageDescription == null)
			errorMessageDescription = exc.toString();

		ErrorMessage message = new ErrorMessage(new Date(), errorMessageDescription);

		return new ResponseEntity<Object>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 * @ExceptionHandler(value = { UserServiceException.class }) public
	 * ResponseEntity<Object> hanadlUserServiceException(UserServiceException exc,
	 * WebRequest webRequest) {
	 * 
	 * String errorMessageDescription = exc.getLocalizedMessage();
	 * 
	 * if (errorMessageDescription == null) errorMessageDescription =
	 * exc.toString();
	 * 
	 * ErrorMessage message = new ErrorMessage(new Date(), errorMessageDescription);
	 * 
	 * return new ResponseEntity<Object>(message, new HttpHeaders(),
	 * HttpStatus.INTERNAL_SERVER_ERROR);
	 * 
	 * }
	 */
}