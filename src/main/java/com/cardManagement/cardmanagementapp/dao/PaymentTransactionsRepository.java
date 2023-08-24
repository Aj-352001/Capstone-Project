package com.cardManagement.cardmanagementapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardManagement.cardmanagementapp.entities.PaymentTransactions;

public interface PaymentTransactionsRepository extends JpaRepository<PaymentTransactions, Integer> {

}
