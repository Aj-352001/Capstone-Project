package com.cardManagement.cardmanagementapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Entity
public class BillPayment {

	@Id
	private Integer paymentId;
	@NotNull
	private Double billAmount;
	private String paymentType;	
	@NotNull
	private Long  creditCardId;
	
	private Double paidAmount = 0.0;
	
	public BillPayment() {
		super();
	}

	public BillPayment(Integer paymentId, Double billAmount, String paymentType, Long creditCardNumber,
			Double paidAmount) {
		super();
		this.paymentId = paymentId;
		this.billAmount = billAmount;
		this.paymentType = paymentType;
		this.creditCardId = creditCardNumber;
		this.paidAmount = paidAmount;
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

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Long getCreditCardNumber() {
		return creditCardId;
	}

	public void setCreditCardNumber(Long creditCardNumber) {
		this.creditCardId = creditCardNumber;
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	@Override
	public String toString() {
		return "BillPayment [paymentId=" + paymentId + ", billAmount=" + billAmount + ", paymentType=" + paymentType
				+ ", creditCardNumber=" + creditCardId + ", paidAmount=" + paidAmount + "]";
	}
	
	
	
	
	
	
		

}