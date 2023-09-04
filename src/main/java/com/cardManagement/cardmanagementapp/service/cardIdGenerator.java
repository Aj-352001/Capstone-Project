package com.cardManagement.cardmanagementapp.service;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class cardIdGenerator implements IdentifierGenerator {
	
	public static final String generatorName = "cardIdGenerator";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException 
	{
		String cardId =  UUID.randomUUID().toString().replace("-", "");
		return cardId;
	}

}
