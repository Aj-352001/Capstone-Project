package com.cardManagement.cardmanagementapp.controller;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardManagement.cardmanagementapp.entities.BillingCycle;
import com.cardManagement.cardmanagementapp.exceptions.BillingCycleException;
import com.cardManagement.cardmanagementapp.service.BillingCycleService;

@RestController
public class BillingCycleController {
	
	
	@Autowired
	private BillingCycleService billingCycleService;
	
//	@GetMapping("/billingCycle/")
//	public String transaction(@RequestBody BillingCycleRepository billingCycle) {
//		return "Hello";
//	}
	
	@PostMapping("/generate/")
    public ResponseEntity<String> generateBillingCycle(LocalDate startDate, LocalDate endDate){
        try {
			billingCycleService.generateBillingCycle();
		} catch (BillingCycleException e) {
			
			e.printStackTrace();
		}
        return ResponseEntity.ok("Billing cycle generated successfully.");
    }
	
	@GetMapping("generate/{cycleId}")
    public BillingCycle getBillingCycleById(@PathVariable Integer cycleId) throws BillingCycleException{
        try {
			return billingCycleService.getBillingCycleById(cycleId);
		} 
        catch (BillingCycleException e) {
			
			throw e;
		}
    }

}
