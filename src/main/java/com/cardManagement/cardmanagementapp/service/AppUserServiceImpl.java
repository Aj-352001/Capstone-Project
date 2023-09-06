package com.cardManagement.cardmanagementapp.service;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cardManagement.cardmanagementapp.dao.AppUserRepository;
import com.cardManagement.cardmanagementapp.dto.AppUserDto;
import com.cardManagement.cardmanagementapp.dto.OTPDto;
import com.cardManagement.cardmanagementapp.entities.AppUser;
import com.cardManagement.cardmanagementapp.entities.Role;
import com.cardManagement.cardmanagementapp.exceptions.AppUserException;
import com.cardManagement.cardmanagementapp.exceptions.EmailVerificationException;

@Service
public class AppUserServiceImpl implements AppUserService{
	
	@Autowired
	private AppUserRepository userRepo;
	@Autowired
	private OtpService otpService;
	@Autowired
	private EmailService emailService;

    @Override
    public List<AppUser> findAllUsers() {
        List<AppUser> users = userRepo.findAll();
		return users;
    }

	@Override
	public AppUser saveUser(AppUserDto userDto) throws AppUserException{
		Optional<AppUser> userOpt = this.userRepo.findByEmail(userDto.getEmail());
		if(userOpt.isPresent())
			throw new AppUserException("There is already an account registered with the same email");
	    AppUser user = new AppUser();
        user.setUserName(userDto.getName());
        user.setEmail(userDto.getEmail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        user.setPassword(encodedPassword);
        user.setUserRole(Role.USER);
        return this.userRepo.save(user);  
	}

	@Override
	public Boolean validateUser(AppUserDto loginDetails) throws AppUserException {
		Optional<AppUser> userOpt =this.userRepo.findByEmail(loginDetails.getEmail());
		AppUser user = userOpt.get();
		String email = user.getEmail();
		String password = user.getPassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(!email.equals(loginDetails.getEmail())) {
			throw new AppUserException("You have entered wrong email.");
		}
		if(!passwordEncoder.matches(loginDetails.getPassword(),password)) {
			throw new AppUserException("You have entered wrong password.");
		}
		return true;
	}

	@Override
	public AppUser updateUser(AppUser user) throws AppUserException {
		Optional<AppUser> userOpt = this.userRepo.findByEmail(user.getEmail());
		if(!userOpt.isPresent())
			throw new AppUserException("User not found");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepo.save(user);
	}

	@Override
	public void generateOtpForEmailVerification(AppUserDto userDto) throws EmailVerificationException {
		String userEmail = userDto.getEmail();
		Integer generatedOtp = otpService.generateOTP(userEmail);
		String message = generatedOtp + "is your Otp for email verification. This OTP is valid for 5 minutes.";
		try {
			emailService.sendOtpMessage(userEmail, "OTP for email verification",message);
		}
		catch(MessagingException e) {
			throw new EmailVerificationException("Email cannot be sent");
		}
	}

	public Boolean verifyOtpForEmailVerification(OTPDto otpDto) throws EmailVerificationException{
		String clientEmail = otpDto.getEmail();
		Integer clientOTP = otpDto.getOtp();
		Boolean isVerified = this.otpService.validateOTP(clientEmail,clientOTP);
		if(! isVerified)
		{
			throw new EmailVerificationException("You have entered wrong OTP.");
		}
		return true;
	}

}
