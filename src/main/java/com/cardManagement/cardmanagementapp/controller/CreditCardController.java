package com.cardManagement.cardmanagementapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cardManagement.cardmanagementapp.dao.BillingCycleRepository;
import com.cardManagement.cardmanagementapp.dao.CreditCardRepository;
import com.cardManagement.cardmanagementapp.dao.PaymentTransactionsRepository;
import com.cardManagement.cardmanagementapp.dao.StatementRepository;
import com.cardManagement.cardmanagementapp.entities.CreditCard;
import com.cardManagement.cardmanagementapp.exceptions.ApplicationException;
import com.cardManagement.cardmanagementapp.exceptions.CreditCardException;
import com.cardManagement.cardmanagementapp.service.CreditCardService;

@RestController
public class CreditCardController {

	@Autowired
	private CreditCardService creditcardService;

	// CREATE A CARD
	@PostMapping("/creditcard/{appId}")
	public CreditCard createCreditCard(@PathVariable Integer appId)
			throws ApplicationException {
		try {
			return this.creditcardService.createCreditCard(appId);
		} catch (ApplicationException e) {
			throw e;
		}
	}
	
	//display all cards
	@GetMapping("/cards/")
	public Collection<CreditCard> displayAllcards() throws CreditCardException{
		return this.creditcardService.displayAllCards();
	}

}
