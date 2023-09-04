package com.cardManagement.cardmanagementapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cardManagement.cardmanagementapp.entities.AppUser;


public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
	
	
    Optional<AppUser> findByEmail(String email);

}
