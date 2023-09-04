package com.cardManagement.cardmanagementapp;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cardManagement.cardmanagementapp.entities.CreditCard;
import com.cardManagement.cardmanagementapp.exceptions.ApplicationException;
import com.cardManagement.cardmanagementapp.service.CreditCardServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class creditcardServiceTests {
	
	@Autowired
	CreditCardServiceImpl creditCardService;
	
	@BeforeAll
	void beforeAllTests() throws ApplicationException {
		System.out.println("will get excecuted once before all tests");
		Integer id=10;
//		CreditCard card = new CreditCard(5242720031398456,"SBI",LocalDate.of(2025, 03, 10),327467.0,"268",4235,
//				567.9,100000.0,20000.0,0.0,null,null,null);
		// applicationService = new ApplicationServiceImpl();
		try {
			this.creditCardService.createCreditCard(id);
		} catch (ApplicationException e) {
			throw e;
		}
	}

}
