package com.cardManagement.cardmanagementapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cardManagement.cardmanagementapp.entities.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer>{

	Boolean existsByCreditCardId(Long creditCardId);
	
	Optional<CreditCard> findByCreditCardId(Long creditCardId);

}
