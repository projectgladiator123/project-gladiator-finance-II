package com.lti.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository extends GenericRepository {
	
public boolean checkIfPersonIsReallyAnAdmin(String username) {
		
		//Query q=entityManager.createQuery("select c from Customer c where c.email:em");
		//q.setParameter(, value)
		
		return (Long) entityManager.createQuery("select count(a.adminId) from Admin a where a.username = :username")
				.setParameter("username", username)
				.getSingleResult() ==1 ? true :false;
		//count returns long and getSingleResult returns here object hence we typecasted it to long
	}
	
	public int findByUserNameAndPassword(String username,String password) {
		
		return (Integer)
				entityManager
				.createQuery("select a.adminId from Admin a where a.username = :username and a.password = :password")
				.setParameter("username", username)
				.setParameter("password", password)
				.getSingleResult();
	}
}



