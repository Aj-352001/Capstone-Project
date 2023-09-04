package com.cardManagement.cardmanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cardManagement.cardmanagementapp.dao.BillPaymentRepository;
import com.cardManagement.cardmanagementapp.dao.StatementRepository;

@RestController
public class StatementController {
	
	@Autowired
	StatementRepository statementRepo;
	@Autowired
	BillPaymentRepository paymentRepo;
	
	@GetMapping("/statement/")
	public String transaction(@RequestBody StatementRepository statement) {
		return "Hello";
	}
	

}
