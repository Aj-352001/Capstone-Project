package com.cardManagement.cardmanagementapp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cardManagement.cardmanagementapp.entities.PaymentTransactions;
import com.cardManagement.cardmanagementapp.exceptions.PaymentTransactionException;
import com.cardManagement.cardmanagementapp.service.TransactionService;

@SpringBootTest
public class TransactionServiceTests {

	@Autowired
	private TransactionService transactionService;
	
	@Test
    public void testGetPaymentTransactionsByID() throws PaymentTransactionException{
        Integer validTransactionID = 1;
        PaymentTransactions transaction;
		try {
			transaction = transactionService.getPaymentTransactionsByID(validTransactionID);
			assertNotNull(transaction);
	        assertEquals(validTransactionID, transaction.getTransactionID());
		} 
			catch (PaymentTransactionException e) {
			throw e;
		}
        
    }
	
	@Test
    public void testGetAllPaymentTransaction() {
        List<PaymentTransactions> transactions = transactionService.getAllPaymentTransaction();
        assertNotNull(transactions);
        assertFalse(transactions.isEmpty());
    }
	
	@Test
    public void testAddPaymentTransactions() throws PaymentTransactionException{
        PaymentTransactions newPaymentTransaction = new PaymentTransactions();
        newPaymentTransaction.setAmount(50.0); // Set a valid amount
        Integer creditcardNumber = 1234567890; // Existing card number in your test data
        PaymentTransactions savedTransaction;
		try {
			savedTransaction = transactionService.addPaymentTransactions(newPaymentTransaction, creditcardNumber);
			 assertNotNull(savedTransaction);
		     assertEquals(newPaymentTransaction.getAmount(), savedTransaction.getAmount());
		} catch (PaymentTransactionException e) {
		  throw e;
		}
       
    }
	
	@Test
    public void testCalculateTotalAmount() throws PaymentTransactionException{
        Double totalAmount;
		try {
			totalAmount = transactionService.calculateTotalAmount(100.0, 50.0);
	        assertEquals(50.0, totalAmount); // Assuming there are transactions in your test data that sum up to 50.0

		} catch (PaymentTransactionException e) {
			throw e;
		}
    }
	
}
