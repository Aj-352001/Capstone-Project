package com.cardManagement.cardmanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// dfshtrumhygk,
import com.cardManagement.cardmanagementapp.dao.ApplicationRepository;

@RestController
public class ApplicationController {
	
	@Autowired
	ApplicationRepository applicationRepo;
	
	@PostMapping("/application/")
	public String Application(@RequestBody ApplicationRepository appUser) {
		return "hello";
	}
	
	

}
