package com.cardManagement.cardmanagementapp.service;



import java.util.List;

import com.cardManagement.cardmanagementapp.entities.Statement;
import com.cardManagement.cardmanagementapp.entities.TransactionCategory;
import com.cardManagement.cardmanagementapp.exceptions.StatementException;


public interface StatementService {
	
	
	
	Statement getStatementbystatementId (Integer statementId) throws StatementException ;
	
	Statement addStatement (Statement newStatement) throws StatementException ; 
	
	Statement updateStatement (Statement newStatement) throws StatementException ; 
	
	Statement interestCalculation (Integer statementId,Double amount) throws StatementException;

	List <Statement> getAllStatements();

}
