package com.cardManagement.cardmanagementapp.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
		@Column(nullable = false, length = 64)
		private String password;
		@Column(name = "name", nullable = false, length = 20)
		private String userName;
		private String mobileNumber;
		@Column(nullable = false, unique = true, length = 45)
		private String email;
		private LocalDateTime lastUpdated;
		@OneToMany
		List<Application> application = new ArrayList<Application>();
		@OneToMany
		List<CreditCard> cards = new ArrayList<CreditCard>();
	    private Role userRole;
	    
		public AppUser() {
			super();
		}

		//for login
		public AppUser(String userName, String email) {
			super();
			this.userName = userName;
			this.email = email;
		}
		
		public AppUser(Integer userId, String password, String userName, String mobileNumber, String email,
				LocalDateTime lastUpdated, List<Application> application, List<CreditCard> cards, Role userRole) {
			super();
			this.userId = userId;
			this.password = password;
			this.userName = userName;
			this.mobileNumber = mobileNumber;
			this.email = email;
			this.lastUpdated = lastUpdated;
			this.application = application;
			this.cards = cards;
			this.userRole = userRole;
		}

		public Role getUserRole() {
			return userRole;
		}

		public void setUserRole(Role userRole) {
			this.userRole = userRole;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
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

		@Override
		public String toString() {
			return "AppUser [userId=" + userId + ", password=" + password + ", userName=" + userName + ", mobileNumber="
					+ mobileNumber + ", email=" + email + ", lastUpdated=" + lastUpdated + ", application="
					+ application + ", cards=" + cards + ", userRole=" + userRole + "]";
		}

	}


