package com.cardManagement.cardmanagementapp.service;

import java.util.List;

import com.cardManagement.cardmanagementapp.entities.BillPayment;
import com.cardManagement.cardmanagementapp.exceptions.BillPaymentException;

public interface BillPaymentsService {

	BillPayment addBillPayment(BillPayment newBillPayment) throws BillPaymentException;

	BillPayment getBillPaymentById(Integer Id) throws BillPaymentException;

	List<BillPayment> getAllBillPayments();

	BillPayment updateAmount(Long creditCardNumber, Double amount) throws BillPaymentException;

}
