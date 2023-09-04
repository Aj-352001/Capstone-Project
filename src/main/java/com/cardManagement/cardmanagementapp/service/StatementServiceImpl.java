package com.cardManagement.cardmanagementapp.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardManagement.cardmanagementapp.dao.StatementRepository;
import com.cardManagement.cardmanagementapp.entities.Statement;
import com.cardManagement.cardmanagementapp.entities.TransactionCategory;
import com.cardManagement.cardmanagementapp.exceptions.StatementException;

@Service
public class StatementServiceImpl implements StatementService {
	
	@Autowired
	private StatementRepository statementRepository;
	
	

	@Override
	public Statement addStatement(Statement newStatement) throws StatementException {
		Optional<Statement> statementopt = this.statementRepository.findById(newStatement.getStatementId());
			if(statementopt.isPresent()) {
				throw new StatementException("already exists" +newStatement.getStatementId());
				
			}
			
			return this.statementRepository.save(newStatement);
		
	}

	@Override
	public Statement updateStatement(Statement newStatement) throws StatementException {
		
		Optional<Statement> statementopt = this.statementRepository.findById(newStatement.getStatementId());
		if (!statementopt.isPresent()) {
			throw new StatementException ("Statement not found for this idd " );
		}
	return statementRepository.save(newStatement);
		
	
	}

	@Override
	public Statement getStatementbystatementId(Integer statementId) throws StatementException {
		
			Optional<Statement> statementopt = this.statementRepository.findById(statementId);
			if (!statementopt.isPresent()) {
				throw new StatementException ("Statement not found for Id " + statementId);
			
		}
		return statementopt.get();
		
	}

	@Override
	public List<Statement> getAllStatements() {
		
		return this.statementRepository.findAll();
	}

	

	@Override
	public Statement interestCalculation(Integer statementId,Double amount)throws StatementException {
		Optional<Statement> statementopt =this.statementRepository.findById(statementId);
		TransactionCategory category= statementopt.get().getCategory();
		Double bill  = statementopt.get().getBill();
		if(category==TransactionCategory.Cash_Withdrawal_ATM) {
			amount+=0.03*amount;
			bill+=amount;
			
		}

		statementopt.get().setBill(bill);
		return this.statementRepository.save(statementopt.get());
		
	}


}


