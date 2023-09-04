package com.cardManagement.cardmanagementapp;


import static org.assertj.core.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.cardManagement.cardmanagementapp.entities.Statement;
import com.cardManagement.cardmanagementapp.exceptions.StatementException;
import com.cardManagement.cardmanagementapp.service.StatementService;
import com.cardManagement.cardmanagementapp.service.StatementServiceImpl;


@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class StatementServiceTests {
	
	@Autowired
	private StatementService statementservice ;
	
	//life cycle methods 	
	
//	@BeforeAll 
//    void beforeAllTest()
//	{
//    System.out.println("It will execute once before all the test cases");
//    statementservice = new StatementServiceImpl(); //allocation of resources
//   
	
	@Test
    public void testGetStatementByStatementId() {
        Statement existingStatement = new Statement();
        existingStatement.setStatementId(1);

      //  statementRepository.save(existingStatement); // Save the statement in the fake repository

        try {
            Statement retrievedStatement = statementservice.getStatementbystatementId(existingStatement.getStatementId());
            assertEquals(existingStatement, retrievedStatement);
        }   
        catch (StatementException e) {
            
        fail("Exception should not have been thrown");
        }
    }

}
	
	
	
	

