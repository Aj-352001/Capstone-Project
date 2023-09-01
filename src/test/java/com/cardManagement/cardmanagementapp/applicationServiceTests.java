package com.cardManagement.cardmanagementapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Date;

import com.cardManagement.cardmanagementapp.entities.Application;
import com.cardManagement.cardmanagementapp.entities.CardApprovalStatus;
import com.cardManagement.cardmanagementapp.entities.CardType;
import com.cardManagement.cardmanagementapp.exceptions.ApplicationException;
import com.cardManagement.cardmanagementapp.service.ApplicationService;
import com.cardManagement.cardmanagementapp.service.ApplicationServiceImpl;
@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class applicationServiceTests {

	@Autowired
	private ApplicationService applicationService;

	// life cycle methods
	@BeforeAll
	void beforeAllTests() throws ApplicationException {
		System.out.println("will get excecuted once before all tests");
		// applicationService = new ApplicationServiceImpl();
		try {
			this.applicationService.createApplication(new Application(101, "APXYH2346", "183932834323",
					LocalDate.of(2001, 10, 20), 23567.0, CardApprovalStatus.PROCESSING, CardType.INTERNATIONAL));
			this.applicationService.createApplication(new Application(102, "GSYH23462", "123678343423",
					LocalDate.of(2000, 12, 01), 45567.0, CardApprovalStatus.DENIED, CardType.GOLD));

		} catch (ApplicationException e) {
			throw e;
		}
	}

//	@Test
//	void createApplication() throws ApplicationException {
//		System.out.println("createapplication");
//		Application newApp = new Application(1, "GJKASDG12356", "517236834322", LocalDate.of(2001, 2, 10), 516273.0,
//				CardApprovalStatus.APPROVED, CardType.GOLD);
//
//		try {
//			
//			assertEquals("Your appplication was applied succcessfully", this.applicationService.createApplication(newApp));
//		} catch (ApplicationException e) {
//			throw e;
//		}
//	}
	
	@Test
	void displayAllApplications() {
		System.out.println("all the applications are: ");
		try {
			System.out.println(this.applicationService.displayAllApplications());
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test
	public void displayAllApplicationById() throws ApplicationException {
		System.out.println("get application by id.");
		Application application = new Application(2, "GJKASDG12356", "517236834322", LocalDate.of(2001, 2, 10), 516273.0,
				CardApprovalStatus.APPROVED, CardType.GOLD);
		Integer id =2;
		try {
			System.out.println(this.applicationService.displayApplicationById(id));
			//assertEquals(application, this.applicationService.displayApplicationById(id));
		} catch (ApplicationException e) {
			throw e;
		}
	}
	
	@Test
	public void updateApplicationStatus() throws ApplicationException {
		System.out.println("update of application status. ");
		Integer id = 12;
		try {
			System.out.println(this.applicationService.updateApplicationStatus(id, CardApprovalStatus.DENIED));
		}catch (ApplicationException e) {
			throw e;
		}
	}

	@Test
	public void deleteApplicationById() throws ApplicationException {
		System.out.println("deleteApplicationById");
		try {
			// this.applicationService.deleteApplicationById(1);

			assertEquals("product got deleted", this.applicationService.deleteApplicationById(19));

		} catch (ApplicationException e) {
			throw e;
		}
	}


}
