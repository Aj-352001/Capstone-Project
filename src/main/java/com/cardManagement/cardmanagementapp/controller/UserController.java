package com.cardManagement.cardmanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cardManagement.cardmanagementapp.dao.ApplicationRepository;
import com.cardManagement.cardmanagementapp.dao.CreditCardRepository;
import com.cardManagement.cardmanagementapp.dao.UserRepository;
import com.cardManagement.cardmanagementapp.entities.AppUser;


@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	ApplicationRepository applicationRepo;
	@Autowired
	CreditCardRepository cardRepo;
	
	@PostMapping("/")
	public String createUser(@RequestBody AppUser users) {
		this.userRepo.save(users);
		return "Credit Card Management System";
		
	}
	@GetMapping("/admin/")
	public String Credit_Card() {
		return "Hello";
	}
	

}
