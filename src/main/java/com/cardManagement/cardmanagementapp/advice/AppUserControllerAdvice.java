package com.cardManagement.cardmanagementapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cardManagement.cardmanagementapp.exceptions.AppUserException;

public class AppUserControllerAdvice {
	
	@ExceptionHandler({AppUserException.class})
	public ResponseEntity<String> handleProductException(AppUserException userException){
		return new ResponseEntity<String>(userException.getMessage(),HttpStatus.BAD_REQUEST);
		
	}

}
