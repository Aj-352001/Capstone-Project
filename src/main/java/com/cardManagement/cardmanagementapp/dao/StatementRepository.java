package com.cardManagement.cardmanagementapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardManagement.cardmanagementapp.entities.Statement;

public interface StatementRepository extends JpaRepository<Statement, Integer>{

}
