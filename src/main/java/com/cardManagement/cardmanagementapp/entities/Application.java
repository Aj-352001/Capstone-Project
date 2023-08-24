package com.cardManagement.cardmanagementapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Application {

	@Id
	private Integer applicationId;
	CardApprovalStatus status;
	CardType cardType;

	public Application() {
		super();
	}

	public Application(Integer applicationId, CardApprovalStatus status, CardType cardType) {
		super();
		this.applicationId = applicationId;
		this.status = status;
		this.cardType = cardType;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}


	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public CardApprovalStatus getStatus() {
		return status;
	}

	public void setStatus(CardApprovalStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", status=" + status + ", cardType=" + cardType + "]";
	}

}
