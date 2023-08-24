package com.cardManagement.cardmanagementapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardManagement.cardmanagementapp.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer>{

}
