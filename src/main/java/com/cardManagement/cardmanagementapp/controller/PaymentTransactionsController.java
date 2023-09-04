package com.cardManagement.cardmanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cardManagement.cardmanagementapp.dao.BillingCycleRepository;
import com.cardManagement.cardmanagementapp.dao.PaymentTransactionsRepository;
@RestController
public class PaymentTransactionsController {
	
	@Autowired
	PaymentTransactionsRepository paymentRepo;
	
	@Autowired
	BillingCycleRepository billCycleRepo;
	
	@GetMapping("/payment/")
	public String transaction(@RequestBody PaymentTransactionsRepository payments) {
		return "Hello";
	}

}
