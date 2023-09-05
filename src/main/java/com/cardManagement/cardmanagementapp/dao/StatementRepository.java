package com.cardManagement.cardmanagementapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardManagement.cardmanagementapp.entities.Statement;
import com.cardManagement.cardmanagementapp.entities.TransactionCategory;

public interface StatementRepository extends JpaRepository<Statement, Integer>{
	public Statement findByCategory(TransactionCategory category);
}
