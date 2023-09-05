package com.cardManagement.cardmanagementapp.service;

import java.util.Collection;
import java.util.List;

import com.cardManagement.cardmanagementapp.dto.ApplicationDto;
import com.cardManagement.cardmanagementapp.entities.Application;
import com.cardManagement.cardmanagementapp.entities.CardApprovalStatus;
import com.cardManagement.cardmanagementapp.exceptions.ApplicationException;

public interface ApplicationService {

	String createApplication(ApplicationDto newApplication) throws ApplicationException;

	ApplicationDto displayApplicationById(Integer id) throws ApplicationException;

	List<ApplicationDto> displayAllApplications();

	ApplicationDto updateApplicationStatus(Integer id, CardApprovalStatus status) throws ApplicationException;

	String deleteApplicationById(Integer id) throws ApplicationException;
}
