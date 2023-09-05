package com.cardManagement.cardmanagementapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cardManagement.cardmanagementapp.entities.BillPayment;
import com.cardManagement.cardmanagementapp.exceptions.BillPaymentException;
import com.cardManagement.cardmanagementapp.service.BillPaymentsService;

@RestController
public class BillPaymentsController {

	@Autowired
	BillPaymentsService billPaymentService;

	@GetMapping("/billPayment/{paymentId}")
	public BillPayment getBillPaymentById(@PathVariable("paymentId") Integer paymentId) throws BillPaymentException {
		try {
			return this.billPaymentService.getBillPaymentById(paymentId);
		} catch (BillPaymentException e) {
			throw e;
		}
	}

	@PostMapping("/billPayment/")
	public BillPayment addBillPayment(@RequestBody BillPayment newBillPayment) throws BillPaymentException {
		try {
			return this.billPaymentService.addBillPayment(newBillPayment);

		} catch (BillPaymentException e) {
			throw e;
		}
	}

	@GetMapping("/billPayments")
	@ResponseStatus(HttpStatus.OK)
	public List<BillPayment> getBillPayments() {
		List<BillPayment> billPaymentList = this.billPaymentService.getAllBillPayments();
		return billPaymentList;

	}

	@PatchMapping("/billPayment/{cardNo}/{amount}")
	public BillPayment updateBillAmount(@PathVariable Long cardNo, @PathVariable Double amount)
			throws BillPaymentException {
		try {
			return this.billPaymentService.updateAmount(cardNo, amount);

		} catch (BillPaymentException e) {
			throw e;
		}
	}

}
