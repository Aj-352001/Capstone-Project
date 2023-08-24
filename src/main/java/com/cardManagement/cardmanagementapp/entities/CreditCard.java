package com.cardManagement.cardmanagementapp.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CreditCard {
	@Id
	private Long creditCardId;
	// access card type from application
	private String cardLender;
	private LocalDate expiryDate;
	private Double cardLimit;
	private String cvv;
	private Integer pin;
	// just for display
	private Double outstandingBalance;
	private Double availableBalance;
	private Double dueBalance;
	@OneToMany
	List<PaymentTransactions> transactions = new ArrayList<PaymentTransactions>();
	@OneToOne
	BillingCycle billCycle;
	@OneToMany
	List<Statement> statements = new ArrayList<Statement>();

	public CreditCard() {
		super();
	}

	public CreditCard(Long creditCardId, String cardLender, LocalDate expiryDate, Double cardLimit, String cvv,
			Integer pin, Double outstandingBalance, Double availableBalance, Double dueBalance,
			List<PaymentTransactions> transactions, BillingCycle billCycle, List<Statement> statements) {
		super();
		this.creditCardId = creditCardId;
		this.cardLender = cardLender;
		this.expiryDate = expiryDate;
		this.cardLimit = cardLimit;
		this.cvv = cvv;
		this.pin = pin;
		this.outstandingBalance = outstandingBalance;
		this.availableBalance = availableBalance;
		this.dueBalance = dueBalance;
		this.transactions = transactions;
		this.billCycle = billCycle;
		this.statements = statements;
	}

	public Long getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(Long creditCardId) {
		this.creditCardId = creditCardId;
	}

	public String getCardLender() {
		return cardLender;
	}

	public void setCardLender(String cardLender) {
		this.cardLender = cardLender;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Double getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(Double cardLimit) {
		this.cardLimit = cardLimit;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public Double getOutstandingBalance() {
		return outstandingBalance;
	}

	public void setOutstandingBalance(Double outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}

	public Double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Double getDueBalance() {
		return dueBalance;
	}

	public void setDueBalance(Double dueBalance) {
		this.dueBalance = dueBalance;
	}

	public List<PaymentTransactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<PaymentTransactions> transactions) {
		this.transactions = transactions;
	}

	public BillingCycle getBillCycle() {
		return billCycle;
	}

	public void setBillCycle(BillingCycle billCycle) {
		this.billCycle = billCycle;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	@Override
	public String toString() {
		return "CreditCard [creditCardId=" + creditCardId + ", cardLender=" + cardLender + ", expiryDate=" + expiryDate
				+ ", cardLimit=" + cardLimit + ", cvv=" + cvv + ", pin=" + pin + ", outstandingBalance="
				+ outstandingBalance + ", availableBalance=" + availableBalance + ", dueBalance=" + dueBalance
				+ ", transactions=" + transactions + ", billCycle=" + billCycle + ", statements=" + statements + "]";
	}

}
