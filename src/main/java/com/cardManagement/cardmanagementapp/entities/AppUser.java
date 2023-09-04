package com.cardManagement.cardmanagementapp.entities;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

	@Entity
	public class AppUser {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer userId;
		private String userName;
		private String mobileNumber;
		private String panNumber;
		private String aadharNumber;
		private LocalDate dateOfBirth;
		private Double income;
		private Double creditScore;
		private String email;
		private LocalDateTime lastUpdated;
		@OneToMany
		List<Application> application = new ArrayList<Application>();
		@OneToMany
		List<CreditCard> cards = new ArrayList<CreditCard>();
		UserRole role;

		public AppUser() {
			super();
		}

		public AppUser(Integer userId, String userName, String mobileNumber, String panNumber, String aadharNumber,
				LocalDate dateOfBirth, Double income, Double creditScore, String email, LocalDateTime lastUpdated,
				List<Application> application, List<CreditCard> cards, UserRole role) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.mobileNumber = mobileNumber;
			this.panNumber = panNumber;
			this.aadharNumber = aadharNumber;
			this.dateOfBirth = dateOfBirth;
			this.income = income;
			this.creditScore = creditScore;
			this.email = email;
			this.lastUpdated = lastUpdated;
			this.application = application;
			this.cards = cards;
			this.role = role;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getPanNumber() {
			return panNumber;
		}

		public void setPanNumber(String panNumber) {
			this.panNumber = panNumber;
		}

		public String getAadhaNumber() {
			return aadharNumber;
		}

		public void setAadhaNumber(String aadharNumber) {
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

		public Double getCreditScore() {
			return creditScore;
		}

		public void setCreditScore(Double creditScore) {
			this.creditScore = creditScore;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public LocalDateTime getLastUpdated() {
			return lastUpdated;
		}

		public void setLastUpdated(LocalDateTime lastUpdated) {
			this.lastUpdated = lastUpdated;
		}

		public List<Application> getApplication() {
			return application;
		}

		public void setApplication(List<Application> application) {
			this.application = application;
		}

		public List<CreditCard> getCards() {
			return cards;
		}

		public void setCards(List<CreditCard> cards) {
			this.cards = cards;
		}

		public UserRole getRole() {
			return role;
		}

		public void setRole(UserRole role) {
			this.role = role;
		}

		@Override
		public String toString() {
			return "AppUser [userId=" + userId + ", userName=" + userName + ", mobileNumber=" + mobileNumber
					+ ", panNumber=" + panNumber + ", aadharNumber=" + aadharNumber + ", dateOfBirth=" + dateOfBirth
					+ ", income=" + income + ", creditScore=" + creditScore + ", email=" + email + ", lastUpdated="
					+ lastUpdated + ", application=" + application + ", cards=" + cards + ", role=" + role + "]";
		}

	}


