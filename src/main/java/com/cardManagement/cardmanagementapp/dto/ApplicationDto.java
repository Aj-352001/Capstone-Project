package com.cardManagement.cardmanagementapp.dto;

import java.time.LocalDate;

import com.cardManagement.cardmanagementapp.entities.CardApprovalStatus;
import com.cardManagement.cardmanagementapp.entities.CardType;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ApplicationDto {
	
	private Integer applicationId;
	private String panNumber;
	private String aadharNumber;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	private Double income;
	private CardApprovalStatus status;
	private CardType cardType;
	public ApplicationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApplicationDto(Integer applicationId, String panNumber, String aadharNumber, LocalDate dateOfBirth,
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
	public Integer getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
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
	
	
	

}
