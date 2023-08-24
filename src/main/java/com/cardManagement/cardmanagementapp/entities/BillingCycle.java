package com.cardManagement.cardmanagementapp.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BillingCycle {
	
	@Id
	private Integer cycleID;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate gracePeriod;

	public BillingCycle() {
		super();
	}

	public BillingCycle(Integer cycleID, LocalDate startDate, LocalDate endDate, LocalDate gracePeriod) {
		super();
		this.cycleID = cycleID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.gracePeriod = gracePeriod;
	}

	public Integer getCycleID() {
		return cycleID;
	}

	public void setCycleID(Integer cycleID) {
		this.cycleID = cycleID;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getGracePeriod() {
		return gracePeriod;
	}

	public void setGracePeriod(LocalDate gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	@Override
	public String toString() {
		return "BillingCycle [cycleID=" + cycleID + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", gracePeriod=" + gracePeriod + "]";
	}


}
