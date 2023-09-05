package com.cardManagement.cardmanagementapp.dto;

import com.cardManagement.cardmanagementapp.entities.Application;

public class ApplicationMapper {
	
	public static ApplicationDto mapToApplicationDto(Application newApplication) {
		ApplicationDto applicationDto=new ApplicationDto(
				newApplication.getApplicationId(),
				newApplication.getPanNumber(),
				newApplication.getAadharNumber(),
				newApplication.getDateOfBirth(),
				newApplication.getIncome(),
				newApplication.getStatus(),
				newApplication.getCardType()
				);
		
		return applicationDto;
	}

	public static Application mapToApplication(ApplicationDto applicationDto) {
		Application newapplication=new Application(
				applicationDto.getApplicationId(),
				applicationDto.getPanNumber(),
				applicationDto.getAadharNumber(),
				applicationDto.getDateOfBirth(),
				applicationDto.getIncome(),
				applicationDto.getStatus(),
				applicationDto.getCardType()
				);
		
		return newapplication;
	}
	

}
