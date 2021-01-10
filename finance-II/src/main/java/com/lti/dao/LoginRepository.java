package com.lti.dao;

import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository extends GenericRepository {
	
	
public boolean isCustomerPresent(String email) {
		
		//Query q=entityManager.createQuery("select c from Customer c where c.email:em");
		//q.setParameter(, value)
		
		return (Long) entityManager.createQuery("select count(r.userId) from Registration r where r.email = :email")
				.setParameter("email", email)
				.getSingleResult() ==1 ? true :false;
		//count returns long and getSingleResult returns here object hence we typecasted it to long
	}
	
	public int findByEmailAndPassword(String email,String password) {
		
		return (Integer)
				entityManager
				.createQuery("select r.id from Registration r where r.email = :email and r.password = :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();
	}
}
