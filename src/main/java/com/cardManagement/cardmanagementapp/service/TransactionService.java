package com.cardManagement.cardmanagementapp.service;

import java.util.List;

import com.cardManagement.cardmanagementapp.entities.PaymentTransactions;
import com.cardManagement.cardmanagementapp.entities.TransactionsDto;
import com.cardManagement.cardmanagementapp.exceptions.PaymentTransactionException;

public interface TransactionService {

	PaymentTransactions addPaymentTransactions(PaymentTransactions newPaymentTransactions,Integer creditcardNumber) throws PaymentTransactionException;
	
	PaymentTransactions getPaymentTransactionsByID(Integer transactionID) throws PaymentTransactionException;
	
	List<PaymentTransactions> getAllPaymentTransaction();
	
	Double calculateTotalAmount(Double credit,Double debit) throws PaymentTransactionException;

	//PaymentTransactions addPaymentTransactions(TransactionsDto transactionDto, Integer creditcardNumber) throws PaymentTransactionException;

}
