package com.cardManagement.cardmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cardManagement.cardmanagementapp.entities.Statement;
import com.cardManagement.cardmanagementapp.exceptions.StatementException;
import com.cardManagement.cardmanagementapp.service.StatementService;
@RestController
public class StatementController {
	
	@Autowired
	private StatementService statementservice;

	@GetMapping ("/statement/{statementId}")
	public Statement getStatementbystatementId(@PathVariable ("statementId") Integer statementId ) throws StatementException{
		return this.statementservice.getStatementbystatementId(statementId);
	
	}
	
	@PostMapping("/statement/")
	public Statement addStatement(@RequestBody Statement newStatement )throws StatementException {
		try {
			return this.statementservice.addStatement(newStatement);
			
		}
		catch (StatementException e){
			throw e;             
			}
		}
		
	@PutMapping("/statement/update/{statementId}")
	 public  Statement updateStatement(@RequestBody Statement newStatement) throws StatementException {
		return this.statementservice.updateStatement(newStatement);
	}
	
	@PatchMapping("/statement/{statementId}/{amount}")
	public Statement interestCalculation(@PathVariable Integer statementId,@PathVariable Double amount) throws StatementException {
		return this.statementservice.interestCalculation(statementId, amount);
	}
	
	@GetMapping("/statements/")  //http local host
	public List<Statement>getStatements(){
		List<Statement>statementList = this.statementservice.getAllStatements();
		return statementList;
	}
}
