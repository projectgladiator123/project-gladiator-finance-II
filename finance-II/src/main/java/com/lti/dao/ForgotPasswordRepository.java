package com.lti.dao;

import org.springframework.stereotype.Repository;

import com.lti.entity.Registration;

@Repository
public class ForgotPasswordRepository extends GenericRepository {

	public Registration getPasswordByDatabaseThroughEmail(String username) {
		
		     return (Registration)
				entityManager.createQuery("select r from Registration r where r.username =:username")
				.setParameter("username",username)
				.getSingleResult();
	}
	
	
}
