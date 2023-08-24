package com.cardManagement.cardmanagementapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardManagement.cardmanagementapp.entities.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer>{

}
