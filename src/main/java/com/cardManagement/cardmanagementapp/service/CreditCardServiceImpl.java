package com.cardManagement.cardmanagementapp.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardManagement.cardmanagementapp.dao.ApplicationRepository;
import com.cardManagement.cardmanagementapp.dao.CreditCardRepository;
import com.cardManagement.cardmanagementapp.dao.PaymentTransactionsRepository;
import com.cardManagement.cardmanagementapp.dao.UserRepository;
import com.cardManagement.cardmanagementapp.entities.AppUser;
import com.cardManagement.cardmanagementapp.entities.Application;
import com.cardManagement.cardmanagementapp.entities.CardApprovalStatus;
import com.cardManagement.cardmanagementapp.entities.CardType;
import com.cardManagement.cardmanagementapp.entities.CreditCard;
import com.cardManagement.cardmanagementapp.entities.PaymentTransactions;
import com.cardManagement.cardmanagementapp.exceptions.ApplicationException;
import com.cardManagement.cardmanagementapp.exceptions.CreditCardException;
@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private CreditCardRepository creditcardRepo;
	
	@Autowired
	private ApplicationRepository appRepo;
	
	@Autowired
	private PaymentTransactionsRepository transactionRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	//generate card number
	Random random = new Random();
	public Long generatecardnumber() {
		
		String fix = "52427200";
		StringBuilder sb = new StringBuilder(8);
		for(int i =0; i < 8 ; i++) {
			int randomDigit = random.nextInt(10);
			sb.append(randomDigit);
			
		}
		String ab = fix+sb;
		Long creditcardId = new Long(ab.toString());
		return creditcardId;
	}
	
	//generate expire date
	public LocalDate generateExpiryDate(){
		LocalDate today = LocalDate.now();
		LocalDate expirydate = today.plusYears(5);
		return expirydate;
	}
	
	//generate limit
	public Double generateLimit(CardType type) {
		Double limit ;
		if(type == CardType.GOLD) {
			limit = 200000.0;
		}
		if(type == CardType.PLATINUM) {
			limit = 500000.0;
		}
		else {
			limit=1000000.0;
		}
		return limit;
	}
	
	//generate cvv
	public String generatecvv() {
		StringBuilder sb = new StringBuilder(3);
		for(int i =0; i < 3 ; i++) {
			int randomDigit = random.nextInt(10);
			sb.append(randomDigit);
		}
		String cvv = new String(sb);
		return cvv;
	}
	
	//generate pin
	public Integer generatepin() {
		StringBuilder sb = new StringBuilder(4);
		for(int i =0; i < 4 ; i++) {
			int randomDigit = random.nextInt(10);
			sb.append(randomDigit);
		}
		Integer pin = new Integer(sb.toString());
		return pin;
	}
	
	//generate outstanding balance
	public Double generateOutstandingbalance() {
		Double outstandingbal = 0.0;
		List<PaymentTransactions> transactions = this.transactionRepo.findAll();
		for (PaymentTransactions paymentTransactions : transactions) {
			outstandingbal +=paymentTransactions.getAmount();
		}
		return outstandingbal;
	}
	
	//generate available balance
	
	
	@Override
	public CreditCard createCreditCard(Integer id) throws ApplicationException {
		Optional<Application> appOpt = this.appRepo.findById(id);
		if(!appOpt.isPresent()) {
			throw new ApplicationException("application is not present");
		}
		CardApprovalStatus stat = appOpt.get().getStatus();
		if(stat != CardApprovalStatus.APPROVED) {
			throw new ApplicationException("the application is not approved yet");
		}
		CreditCard card = new CreditCard();
		Long cardNumber = generatecardnumber();
		card.setCreditCardId(cardNumber);
		
		card.setCardLender("HDFC");
		
		LocalDate expiryDate = generateExpiryDate();
		card.setExpiryDate(expiryDate);
		
		Double limit = generateLimit(appOpt.get().getCardType());
		card.setCardLimit(limit);
		
		String cvv = generatecvv();
		card.setCvv(cvv);
		
		Integer pin = generatepin();
		card.setPin(pin);
		
		card.setCreditScore(670);
		
		Double outbal = generateOutstandingbalance();
		card.setOutstandingBalance(outbal);
		
		card.setAvailableBalance(0.0);
		
		card.setDueBalance(null);
		
		card.setTransactions(null);
		
		card.setBillCycle(null);
		
		card.setStatements(null);
		return this.creditcardRepo.save(card);
		//EMAIL INTEGRATION REQUIRED
	}

	@Override
	public Collection<CreditCard> displayAllCards() {
		List<CreditCard> cards = this.creditcardRepo.findAll();
		for(CreditCard creditCard: cards) {
			System.out.println("credit card is "+ cards);
		}
		return cards;
	}

	

}
