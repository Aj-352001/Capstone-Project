package com.cardManagement.cardmanagementapp.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardManagement.cardmanagementapp.dao.BillingCycleRepository;
import com.cardManagement.cardmanagementapp.dao.CreditCardRepository;
import com.cardManagement.cardmanagementapp.entities.BillingCycle;
import com.cardManagement.cardmanagementapp.entities.CreditCard;
import com.cardManagement.cardmanagementapp.exceptions.BillingCycleException;

@Service
public class BillingCycleServiceImpl implements BillingCycleService{

	@Autowired
	BillingCycleRepository billingCycleRepo;
	
	@Autowired
	CreditCardRepository creditCardRepo;

	

	@Override
	public BillingCycle getBillingCycleById(Integer cycleId) throws BillingCycleException {
		
		return billingCycleRepo.findById(cycleId).orElseThrow(() -> new BillingCycleException("Billing cycle not found"));
		
	}



	@Override
	public BillingCycle createBillingCycle(LocalDate startDate, LocalDate endDate) throws BillingCycleException {
		 BillingCycle billingCycle = new BillingCycle();
	        billingCycle.setStartDate(startDate);
	        billingCycle.setEndDate(endDate);
	        billingCycle.setGracePeriod(endDate.plusDays(10));
	        return billingCycleRepo.save(billingCycle);
		
	}

	@Override
	public void generateBillingCycle() throws BillingCycleException {
		LocalDate currentDate = LocalDate.now();
        LocalDate startDate = currentDate.withDayOfMonth(1);
        LocalDate endDate = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
        createBillingCycle(startDate, endDate);				
	}

//	public BillingCycle createBillingCycle(LocalDate startDate, LocalDate endDate, CreditCard creditCardId)
//            throws BillingCycleException {
//        // Checking if the credit card already has an active billing cycle
//        if (creditCard.hasActiveBillingCycle()) {
//            throw new BillingCycleException("Credit card already has an active billing cycle.");
//        }
//
//        BillingCycle billingCycle = new BillingCycle();
//        billingCycle.setStartDate(startDate);
//        billingCycle.setEndDate(endDate);
//        billingCycle.setGracePeriod(endDate.plusDays(10));
//        billingCycle.setCreditCard(creditCard);
//
//        // Save the billing cycle to the repository
//        return billingCycleRepo.save(billingCycle);
//    }
	
//	public void generateBillingCycle(CreditCard creditCardId) throws BillingCycleException {
//        LocalDate currentDate = LocalDate.now();
//        LocalDate startDate = currentDate.withDayOfMonth(1);
//        LocalDate endDate = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
//
//        // Create a billing cycle for the credit card
//        createBillingCycle(startDate, endDate, creditCardId);
//    }
}
