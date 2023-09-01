package com.cardManagement.cardmanagementapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cardManagement.cardmanagementapp.exceptions.CreditCardException;

@RestControllerAdvice
public class CreditCardControllerAdvice {
	
	@ExceptionHandler({CreditCardException.class})
	public ResponseEntity<String> handleApplicationException(CreditCardException creditcardException){
		return new ResponseEntity<String>(creditcardException.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
