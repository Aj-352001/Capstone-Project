package com.cardManagement.cardmanagementapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cardManagement.cardmanagementapp.exceptions.PaymentTransactionException;

@RestControllerAdvice
public class TransactionControllerAdvice {

	@ExceptionHandler(PaymentTransactionException.class)
	public ResponseEntity<String> handleProductException(PaymentTransactionException productException){//response entity used to return status code 
		return new ResponseEntity<String>(productException.getMessage(), HttpStatus.BAD_REQUEST);      
		
	}
}
