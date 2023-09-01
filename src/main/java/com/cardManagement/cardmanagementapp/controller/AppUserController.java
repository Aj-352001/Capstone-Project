package com.cardManagement.cardmanagementapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cardManagement.cardmanagementapp.dto.AppUserDto;
import com.cardManagement.cardmanagementapp.entities.AppUser;
import com.cardManagement.cardmanagementapp.exceptions.AppUserException;
import com.cardManagement.cardmanagementapp.exceptions.EmailVerificationException;
import com.cardManagement.cardmanagementapp.service.AppUserService;
//import com.cardManagement.cardmanagementapp.service.OtpService;
import com.cardManagement.cardmanagementapp.dto.OTPDto;
@RestController
public class AppUserController {

	@Autowired
	private AppUserService userService;

	@PostMapping("/user/")
	public AppUser saveUser(@RequestBody AppUserDto userDto) throws AppUserException {
		return this.userService.saveUser(userDto);
	}

	@PostMapping("/login/")
	public ResponseEntity<String> login(@RequestBody AppUserDto loginDetailsDto) throws AppUserException {
		if (this.userService.validateUser(loginDetailsDto))
			return ResponseEntity.status(HttpStatus.OK).body("You have successfully logged in");
		else
			return ResponseEntity.status(HttpStatus.OK).body("Login failed!");
	}

	@PutMapping("/user/update")
	public AppUser updateUser(@RequestBody AppUser user) throws AppUserException {
		try {
			return this.userService.updateUser(user);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/users/")
	@ResponseStatus(HttpStatus.OK)
	public List<AppUser> getAllUsers() {
		List<AppUser> listUsers = userService.findAllUsers();
		return listUsers;
	}
	
	@PostMapping("/user/otp/generate/")
	@ResponseStatus(HttpStatus.OK)
	public void generateOtp(@RequestBody AppUserDto userDto) throws EmailVerificationException{
		this.userService.generateOtpForEmailVerification(userDto);
		
	}
	@PostMapping("/user/otp/verify/")
    public ResponseEntity<String> verifyOtp(@RequestBody OTPDto otpDto) throws EmailVerificationException
    {
		if( this.userService.verifyOtpForEmailVerification(otpDto)) {
			return ResponseEntity.status(HttpStatus.OK).body("Email validated.");
		}
		return null;
    }
	
}
