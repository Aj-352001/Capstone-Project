package com.cardManagement.cardmanagementapp.service;

import java.util.Collection;

import com.cardManagement.cardmanagementapp.entities.Application;
import com.cardManagement.cardmanagementapp.entities.CardApprovalStatus;
import com.cardManagement.cardmanagementapp.exceptions.ApplicationException;

public interface ApplicationService {
	
	String createApplication(Application newApplication) throws ApplicationException;
	Application displayApplicationById(Integer id) throws ApplicationException;
	Collection<Application> displayAllApplications();
	Application updateApplicationStatus(Integer id, CardApprovalStatus status) throws ApplicationException;
	String deleteApplicationById(Integer id) throws ApplicationException;
}
