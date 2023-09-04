package com.cardManagement.cardmanagementapp.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer applicationId;
	private String panNumber;
	private String aadharNumber;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfBirth;
	private Double income;
	private CardApprovalStatus status;
	private CardType cardType;

	public Application() {
		super();
	}

	public Application(Integer applicationId, String panNumber, String aadharNumber, LocalDate dateOfBirth,
			Double income, CardApprovalStatus status, CardType cardType) {
		super();
		this.applicationId = applicationId;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
		this.dateOfBirth = dateOfBirth;
		this.income = income;
		this.status = status;
		this.cardType = cardType;
	}



	public CardApprovalStatus getStatus() {
		return status;
	}

	public void setStatus(CardApprovalStatus status) {
		this.status = status;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", panNumber=" + panNumber + ", aadharNumber="
				+ aadharNumber + ", dateOfBirth=" + dateOfBirth + ", income=" + income + ", status=" + status
				+ ", cardType=" + cardType + "]";
	}

	

	
}
