package com.cardManagement.cardmanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cardManagement.cardmanagementapp.dao.BillingCycleRepository;

@RestController
public class BillingCycleController {
	
	@Autowired
	BillingCycleRepository billingRepo;
	
	@GetMapping("/billingCycle/")
	public String transaction(@RequestBody BillingCycleRepository billingCycle) {
		return "Hello";
	}
	

}
