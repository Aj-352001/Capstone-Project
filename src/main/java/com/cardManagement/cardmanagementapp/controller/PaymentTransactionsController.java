package com.cardManagement.cardmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cardManagement.cardmanagementapp.entities.PaymentTransactions;
import com.cardManagement.cardmanagementapp.exceptions.PaymentTransactionException;
import com.cardManagement.cardmanagementapp.service.TransactionService;
import org.springframework.http.HttpStatus;
@RestController
public class PaymentTransactionsController {
	
	@Autowired
	private TransactionService transactionService;
	
//	@GetMapping("/payment/")
//	public String transaction(@RequestBody PaymentTransactionsRepository payments) {
//		return "Hello";
//	}
	
	@PostMapping("/transaction/{creditcardNumber}")
	public PaymentTransactions addPaymentTransactions(@RequestBody PaymentTransactions newPaymentTransactions,@PathVariable Integer creditcardNumber) throws PaymentTransactionException{
		try{
			return this.transactionService.addPaymentTransactions(newPaymentTransactions,creditcardNumber);
			
		} catch(PaymentTransactionException e) {
			throw e;
		}
	}
	
	@GetMapping("/transaction/{transactionID}")
	public PaymentTransactions getPaymentTransactionById(@PathVariable("transactionID") Integer transactionID) throws PaymentTransactionException {
		try {
			return this.transactionService.getPaymentTransactionsByID(transactionID);
		} catch (PaymentTransactionException e) {
			throw e;
		}
	}
	@GetMapping("/transactions/")
	@ResponseStatus(HttpStatus.OK)
	public List<PaymentTransactions> getAllProducts(){
		List<PaymentTransactions> paymentTransactionList = this.transactionService.getAllPaymentTransaction();
		return paymentTransactionList;
	}
	
	@GetMapping("/totalAmount")
    public Double getTotalDebitAmount(@PathVariable("credit") Double credit,@PathVariable("debit") Double debit) throws PaymentTransactionException{
        Double totalDebitAmount;
		try {
			totalDebitAmount = this.transactionService.calculateTotalAmount(credit,debit);
	        return totalDebitAmount;
		} catch (PaymentTransactionException e) {
			
			throw e;
		}
    }

}
