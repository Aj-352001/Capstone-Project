package com.cardManagement.cardmanagementapp.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Statement {

	@Id
	private Integer statementId;
	private LocalDate generationDate;
	private Double bill;
	private String transactionDetails;
	private TransactionCategory category;
	@OneToMany
	List<BillPayment> billPayments = new ArrayList<BillPayment>();

	public Statement() {
		super();
	}

	public Statement(Integer statementId, LocalDate generationDate, Double bill, String transactionDetails,
			TransactionCategory category, List<BillPayment> billPayments) {
		super();
		this.statementId = statementId;
		this.generationDate = generationDate;
		this.bill = bill;
		this.transactionDetails = transactionDetails;
		this.category = category;
		this.billPayments = billPayments;
	}

	public Integer getStatementId() {
		return statementId;
	}

	public void setStatementId(Integer statementId) {
		this.statementId = statementId;
	}

	public LocalDate getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(LocalDate generationDate) {
		this.generationDate = generationDate;
	}

	public Double getBill() {
		return bill;
	}

	public void setBill(Double bill) {
		this.bill = bill;
	}

	public String getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	public TransactionCategory getCategory() {
		return category;
	}

	public void setCategory(TransactionCategory category) {
		this.category = category;
	}

	public List<BillPayment> getBillPayments() {
		return billPayments;
	}

	public void setBillPayments(List<BillPayment> billPayments) {
		this.billPayments = billPayments;
	}

	@Override
	public String toString() {
		return "Statement [statementId=" + statementId + ", generationDate=" + generationDate + ", bill=" + bill
				+ ", transactionDetails=" + transactionDetails + ", category=" + category + ", billPayments="
				+ billPayments + "]";
	}

	}