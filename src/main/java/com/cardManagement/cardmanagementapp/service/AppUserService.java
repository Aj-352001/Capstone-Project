package com.cardManagement.cardmanagementapp.service;

import java.util.List;

import com.cardManagement.cardmanagementapp.dto.AppUserDto;
import com.cardManagement.cardmanagementapp.dto.OTPDto;
import com.cardManagement.cardmanagementapp.entities.AppUser;
import com.cardManagement.cardmanagementapp.exceptions.AppUserException;
import com.cardManagement.cardmanagementapp.exceptions.EmailVerificationException;

public interface AppUserService {

	AppUser saveUser(AppUserDto userDto) throws AppUserException;

    List<AppUser> findAllUsers();
    
    Boolean validateUser(AppUserDto loginDetails) throws AppUserException;
    
	AppUser updateUser(AppUser user) throws AppUserException;
    
	void generateOtpForEmailVerification(AppUserDto userDto) throws EmailVerificationException;
	
	Boolean verifyOtpForEmailVerification(OTPDto otpDto) throws EmailVerificationException;

}
