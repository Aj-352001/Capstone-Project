package com.cardManagement.cardmanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cardManagement.cardmanagementapp.dao.BillingCycleRepository;
import com.cardManagement.cardmanagementapp.dao.CreditCardRepository;
import com.cardManagement.cardmanagementapp.dao.PaymentTransactionsRepository;
import com.cardManagement.cardmanagementapp.dao.StatementRepository;

@RestController
public class CreditCardController {
	
	@Autowired
	CreditCardRepository creditCardRepo;
	@Autowired
	PaymentTransactionsRepository transactionRepo;
	@Autowired
	BillingCycleRepository billCycleRepo;
	@Autowired
	StatementRepository statementRepo;
	
	@GetMapping("/transaction/")
	public String transaction(@RequestBody CreditCardRepository creditcard) {
		return "Hello";
	}
	

}
