package com.cardManagement.cardmanagementapp.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardManagement.cardmanagementapp.dao.ApplicationRepository;
import com.cardManagement.cardmanagementapp.entities.Application;
import com.cardManagement.cardmanagementapp.entities.CardApprovalStatus;
import com.cardManagement.cardmanagementapp.exceptions.ApplicationException;

@Service
public class ApplicationServiceImpl implements ApplicationService{
	
	@Autowired
	private ApplicationRepository applicationRepo;
	
	@Override
	public String createApplication(Application newApplication) throws ApplicationException {
//		if(newApplication==null) {
//			throw new ApplicationException("There is no data available. Please enter data to apply. ");
//		}
		this.applicationRepo.save(newApplication);
		return "Your appplication was applied succcessfully";
	}

	@Override
	public Application displayApplicationById(Integer id) throws ApplicationException {
		Optional<Application> applicationOpt= this.applicationRepo.findById(id);
		if(!applicationOpt.isPresent()) {
			throw new ApplicationException("application requested DOESNOT exists");
		}
		return applicationOpt.get();
	}

	@Override
	public Collection<Application> displayAllApplications() {
		List<Application> applicationList= this.applicationRepo.findAll();
		for(Application application : applicationList) {
			System.out.println("Application is: " + application);
		}
		return applicationList;
	}

	@Override
	public Application updateApplicationStatus(Integer id, CardApprovalStatus status) throws ApplicationException {
		Optional<Application> applicationOpt = this.applicationRepo.findById(id);
		if(!applicationOpt.isPresent()) {
			throw new ApplicationException("application requested DOESNOT exists");
		}
		applicationOpt.get().setStatus(status);
		
		return this.applicationRepo.save(applicationOpt.get());
	}

	@Override
	public String deleteApplicationById(Integer id) throws ApplicationException {
		Optional<Application> appOpt=this.applicationRepo.findById(id);
		if(!appOpt.isPresent()) {
			throw new ApplicationException("product does not exists ");
		}
		this.applicationRepo.deleteById(id);
		return "product got deleted";
	}

	
	
	


}
