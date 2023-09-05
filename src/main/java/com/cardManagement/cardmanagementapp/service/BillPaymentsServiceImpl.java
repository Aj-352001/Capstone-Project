package com.cardManagement.cardmanagementapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cardManagement.cardmanagementapp.dao.BillPaymentRepository;
import com.cardManagement.cardmanagementapp.dao.CreditCardRepository;
import com.cardManagement.cardmanagementapp.entities.BillPayment;
import com.cardManagement.cardmanagementapp.exceptions.BillPaymentException;

@Service
public class BillPaymentsServiceImpl implements BillPaymentsService {

	@Autowired
	BillPaymentRepository billPaymentRepository;
	@Autowired
	CreditCardRepository cardRepo;

	@Override
	public BillPayment addBillPayment(BillPayment newBillayment) throws BillPaymentException {
		return this.billPaymentRepository.save(newBillayment);
	}

	@Override
	public BillPayment getBillPaymentById(Integer Id) throws BillPaymentException {
		Optional<BillPayment> billOpt = this.billPaymentRepository.findById(Id);
		if (!billOpt.isPresent()) {
			throw new BillPaymentException("No payment made");
		}
		return billOpt.get();
	}

	@Override
	public List<BillPayment> getAllBillPayments() {
		return this.billPaymentRepository.findAll();
	}

	@Override
	public BillPayment updateAmount(Long creditCardId, Double amount) throws BillPaymentException {

		Boolean cardNumber = this.cardRepo.existsByCreditCardId(creditCardId);
		BillPayment billDetails = billPaymentRepository.findByCreditCardId(creditCardId);
		if (cardNumber == false) {
			throw new BillPaymentException("Card Does Not exsist");
		}
		Double bill = billDetails.getBillAmount();
		bill -= amount;
		billDetails.setBillAmount(bill);
		Double paidBillAmount = billDetails.getPaidAmount() + amount;
		billDetails.setPaidAmount(paidBillAmount);

		return this.billPaymentRepository.save(billDetails);

	}

}
