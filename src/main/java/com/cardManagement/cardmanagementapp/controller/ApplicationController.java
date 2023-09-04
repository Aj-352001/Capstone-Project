package com.cardManagement.cardmanagementapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cardManagement.cardmanagementapp.entities.Application;
import com.cardManagement.cardmanagementapp.entities.CardApprovalStatus;
import com.cardManagement.cardmanagementapp.exceptions.ApplicationException;
import com.cardManagement.cardmanagementapp.service.ApplicationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;
	
	@RequestMapping("/v1")

	// APPLICATION OF PARTICULAR USER/CUSTOMER
	@GetMapping("/application/{id}")
	public Application getApplicationById(@PathVariable("id") Integer id) throws ApplicationException {
		try {
			return this.applicationService.displayApplicationById(id);
		} catch (ApplicationException e) {
			throw e;
		}
	}

	// ADDING AN APPLICATION
	@PostMapping("/application/")
	public String addApplication(@RequestBody Application newApplication) throws ApplicationException {
		try {
			this.applicationService.createApplication(newApplication);
			return "application successful";
		} catch (ApplicationException e) {
			throw e;
		}
	}

	// DISPLAYING ALL THE APPLICATIONS
	@GetMapping("/applications/")
	public Collection<Application> displayAllApplication(@RequestBody Application newApplication)
			throws ApplicationException {
		try {
			return this.applicationService.displayAllApplications();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	// UPDATING THE STATUS OF THE APPLICATION BY ADMIN
	@PatchMapping("/application/{id}/{status}")
	public Application updateApplicationStatus(@PathVariable Integer id, @PathVariable CardApprovalStatus status)
			throws Exception {
		try {
			return this.applicationService.updateApplicationStatus(id, status);
		} catch (ApplicationException e) {
			throw e;
		}
	}

	// DELETING THE APPLICATION BY USER
	@DeleteMapping("/delapplication/{id}")
	public String deleteApplication(@PathVariable Integer id)
			throws ApplicationException {
		try {
			return this.applicationService.deleteApplicationById(id);
		} catch (ApplicationException e) {
			throw e;
		}
	}

}
