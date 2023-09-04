package com.cardManagement.cardmanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cardManagement.cardmanagementapp.dao.BillPaymentRepository;

@RestController
public class BillPaymentsController {
	
	@Autowired
	BillPaymentRepository billPaymentRepo;
	
	@GetMapping("/billPayment/")
	public String transaction(@RequestBody BillPaymentRepository billPayment) {
		return "Hello";
	}
	

}
