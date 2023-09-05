package com.cardManagement.cardmanagementapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardManagement.cardmanagementapp.entities.BillPayment;

public interface BillPaymentRepository extends JpaRepository<BillPayment, Integer> {
	
	public BillPayment findByCreditCardId(long creditCardId);
}

