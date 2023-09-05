package com.cardManagement.cardmanagementapp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cardManagement.cardmanagementapp.dao.BillingCycleRepository;
import com.cardManagement.cardmanagementapp.entities.BillingCycle;
import com.cardManagement.cardmanagementapp.exceptions.BillingCycleException;
import com.cardManagement.cardmanagementapp.service.BillingCycleService;

@SpringBootTest
public class BillingCycleTests {

	@Autowired
	BillingCycleService billingCycleService;
	
	@Autowired
	BillingCycleRepository billingCycleRepo;
	
	
	@Test
    public void testGetBillingCycleById() throws BillingCycleException {
        Integer validCycleId = 1; // Assuming you have a billing cycle with ID 1 in your test data
        BillingCycle billingCycle;
		try {
			billingCycle = billingCycleService.getBillingCycleById(validCycleId);
			 assertNotNull(billingCycle);
		     assertEquals(validCycleId, billingCycle.getCycleID());
		} catch (BillingCycleException e) {
			throw e;
		}
    }
	
	@Test
    public void testCreateBillingCycle() throws BillingCycleException {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(1);
        BillingCycle billingCycle;
		try {
			billingCycle = billingCycleService.createBillingCycle(startDate, endDate);
			 assertNotNull(billingCycle);
		     assertEquals(startDate, billingCycle.getStartDate());
		     assertEquals(endDate, billingCycle.getEndDate());
		     assertNotNull(billingCycle.getGracePeriod());
		} catch (BillingCycleException e) {
			throw e;
		}
    }
	
//	@Test
//	public void testGenerateBillingCycle() throws BillingCycleException{
//	    int initialBillingCycleCount = billingCycleRepo.findAll().size();
//
//	    try {
//			billingCycleService.generateBillingCycle();
//		} catch (BillingCycleException e) {
//			throw e;
//		}
//
//	    int updatedBillingCycleCount = billingCycleRepo.findAll().size();
//	    assertEquals(initialBillingCycleCount + 1, updatedBillingCycleCount);
//	}
	
}
