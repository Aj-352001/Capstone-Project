package com.cardManagement.cardmanagementapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardManagement.cardmanagementapp.entities.BillingCycle;

public interface BillingCycleRepository extends JpaRepository<BillingCycle, Integer>{

}
