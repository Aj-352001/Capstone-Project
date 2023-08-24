package com.cardManagement.cardmanagementapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class BillPayment {

	@Id
	private Integer paymentId;
	private Double billAmount;
	private String paymentType;

	public BillPayment(Integer paymentId, Double billAmount, String paymentType) {
		super();
		this.paymentId = paymentId;
		this.billAmount = billAmount;
		this.paymentType = paymentType;
	}

	public BillPayment() {
		super();
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

	@Override
	public String toString() {
		return "BillPayment [paymentId=" + paymentId + ", billAmount=" + billAmount + ", paymentType=" + paymentType
				+ "]";
	}

}
