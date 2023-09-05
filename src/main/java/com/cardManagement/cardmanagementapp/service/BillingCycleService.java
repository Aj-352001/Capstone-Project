package com.cardManagement.cardmanagementapp.service;

import java.time.LocalDate;

import com.cardManagement.cardmanagementapp.entities.BillingCycle;
import com.cardManagement.cardmanagementapp.exceptions.BillingCycleException;

public interface BillingCycleService {

    BillingCycle createBillingCycle(LocalDate startDate, LocalDate endDate) throws BillingCycleException;

    void generateBillingCycle() throws BillingCycleException;

    BillingCycle getBillingCycleById(Integer cycleId) throws BillingCycleException;

}
