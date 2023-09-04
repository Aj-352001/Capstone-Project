package com.cardManagement.cardmanagementapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cardManagement.cardmanagementapp.exceptions.ApplicationException;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	@ExceptionHandler({ApplicationException.class})
	public ResponseEntity<String> handleApplicationException(ApplicationException applicationException){
		return new ResponseEntity<String>(applicationException.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
