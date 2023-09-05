package com.cardManagement.cardmanagementapp.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardManagement.cardmanagementapp.dao.ApplicationRepository;
import com.cardManagement.cardmanagementapp.dto.ApplicationDto;
import com.cardManagement.cardmanagementapp.dto.ApplicationMapper;
import com.cardManagement.cardmanagementapp.entities.Application;
import com.cardManagement.cardmanagementapp.entities.CardApprovalStatus;
import com.cardManagement.cardmanagementapp.exceptions.ApplicationException;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepo;

	@Override
	public String createApplication(ApplicationDto applicationDto) throws ApplicationException {
		Application newapplication = ApplicationMapper.mapToApplication(applicationDto);
		Application savedapp = this.applicationRepo.save(newapplication);
		ApplicationDto savedappDto=ApplicationMapper.mapToApplicationDto(savedapp);
//		if(newApplication==null) {
//			throw new ApplicationException("There is no data available. Please enter data to apply. ");
//		}
		return "Your appplication was applied successfully";
	}

	@Override
	public ApplicationDto displayApplicationById(Integer id) throws ApplicationException {
		
		Optional<Application> applicationOpt = this.applicationRepo.findById(id);
		if (!applicationOpt.isPresent()) {
			throw new ApplicationException("application requested doesnot exists");
		}
		Application app = applicationOpt.get();
		return ApplicationMapper.mapToApplicationDto(app);
	}

	@Override
	public List<ApplicationDto> displayAllApplications() {
		List<Application> applicationList = this.applicationRepo.findAll();
		
		return applicationList.stream().map(ApplicationMapper::mapToApplicationDto).collect(Collectors.toList());
	}

	@Override
	public ApplicationDto updateApplicationStatus(Integer id, CardApprovalStatus status) throws ApplicationException {
		Optional<Application> applicationOpt = this.applicationRepo.findById(id);
		
		if (!applicationOpt.isPresent()) {
			throw new ApplicationException("application requested DOESNOT exists");
		}
		applicationOpt.get().setStatus(status);
		Application updatedapp = this.applicationRepo.save(applicationOpt.get());

		return ApplicationMapper.mapToApplicationDto(updatedapp);
	}

	@Override
	public String deleteApplicationById(Integer id) throws ApplicationException {
		Optional<Application> appOpt = this.applicationRepo.findById(id);
		if (!appOpt.isPresent()) {
			throw new ApplicationException("product does not exists ");
		}
		this.applicationRepo.deleteById(id);
		return "product got deleted";
	}

}
