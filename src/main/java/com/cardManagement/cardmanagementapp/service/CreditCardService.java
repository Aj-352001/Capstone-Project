package com.cardManagement.cardmanagementapp.service;

import java.util.Collection;

import com.cardManagement.cardmanagementapp.entities.CreditCard;
import com.cardManagement.cardmanagementapp.exceptions.ApplicationException;
import com.cardManagement.cardmanagementapp.exceptions.CreditCardException;

public interface CreditCardService {
	
	CreditCard createCreditCard( Integer Id) throws ApplicationException;
	Collection<CreditCard> displayAllCards();

}
