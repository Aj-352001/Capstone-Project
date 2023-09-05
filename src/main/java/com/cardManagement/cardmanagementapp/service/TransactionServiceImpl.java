package com.cardManagement.cardmanagementapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardManagement.cardmanagementapp.dao.CreditCardRepository;
import com.cardManagement.cardmanagementapp.dao.PaymentTransactionsRepository;
import com.cardManagement.cardmanagementapp.dao.UserRepository;
import com.cardManagement.cardmanagementapp.entities.CreditCard;
import com.cardManagement.cardmanagementapp.entities.PaymentTransactions;
import com.cardManagement.cardmanagementapp.exceptions.PaymentTransactionException;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private PaymentTransactionsRepository transactionRepo;
	//@Autowired
	//private UserRepository userRepo;
	@Autowired
	private CreditCardRepository cardRepo;	

	@Override
	public PaymentTransactions getPaymentTransactionsByID(Integer transactionID) throws PaymentTransactionException {
		Optional<PaymentTransactions> transactionOpt = this.transactionRepo.findById(transactionID);
		if(!transactionOpt.isPresent()) {
			throw new PaymentTransactionException("Transaction not found by id" + transactionID);
		}
		return transactionOpt.get();
	}

	@Override
	public List<PaymentTransactions> getAllPaymentTransaction() {
		return this.transactionRepo.findAll();
	}

	@Override
	public PaymentTransactions addPaymentTransactions(PaymentTransactions newPaymentTransactions,Integer creditcardNumber)throws PaymentTransactionException {
		PaymentTransactions transaction = new PaymentTransactions();
		Double amount = transaction.getAmount();
		Optional<CreditCard> card = cardRepo.findById(creditcardNumber);
		Double availableLimit = card.get().getAvailableBalance();
		Double cardLimit = card.get().getCardLimit();
		if(amount <= cardLimit && amount <= availableLimit) {
			return this.transactionRepo.save(transaction);
		}
		else {
			throw new PaymentTransactionException("Amount should be less than limit");
		}	
	}
	
	public Double calculateTotalAmount(Double credit,Double debit) {
		List<PaymentTransactions> transactions = transactionRepo.findAll();
        Double creditsum= transactions.stream()
                .mapToDouble(PaymentTransactions::getCredit)
                .sum();
        Double debitsum=transactions.stream()
                .mapToDouble(PaymentTransactions::getDebit)
                .sum();
        
        Double total = creditsum - debitsum;
        return total;
		
    }

}
