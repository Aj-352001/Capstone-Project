package com.cardManagement.cardmanagementapp.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentTransactions {

	@Id
	private Integer transactionID;
	private LocalDate timeStamp;
	private String purchaseInformation;
	private Double amount;
	private Integer branchCode;
	private Boolean status;
	private Double credit;
	private Double debit;
	TransactionCategory category;
	
	public PaymentTransactions() {
		super();
	}

	
	public PaymentTransactions(Integer transactionID, LocalDate timeStamp, String purchaseInformation, Double amount,
			Integer branchCode, Boolean status, Double credit, Double debit, TransactionCategory category) {
		super();
		this.transactionID = transactionID;
		this.timeStamp = timeStamp;
		this.purchaseInformation = purchaseInformation;
		this.amount = amount;
		this.branchCode = branchCode;
		this.status = status;
		this.credit = credit;
		this.debit = debit;
		this.category = category;
	}


	public Integer getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(Integer transactionID) {
		this.transactionID = transactionID;
	}

	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getPurchaseInformation() {
		return purchaseInformation;
	}

	public void setPurchaseInformation(String purchaseInformation) {
		this.purchaseInformation = purchaseInformation;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public Double getDebit() {
		return debit;
	}

	public void setDebit(Double debit) {
		this.debit = debit;
	}

	public TransactionCategory getCategory() {
		return category;
	}

	public void setCategory(TransactionCategory category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "PaymentTransactions [transactionID=" + transactionID + ", timeStamp=" + timeStamp
				+ ", purchaseInformation=" + purchaseInformation + ", amount=" + amount + ", branchCode=" + branchCode
				+ ", status=" + status + ", credit=" + credit + ", debit=" + debit + ", category=" + category + "]";
	}

	
}

