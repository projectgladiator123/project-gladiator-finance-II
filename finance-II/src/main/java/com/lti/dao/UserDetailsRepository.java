package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Registration;

@Repository
public class UserDetailsRepository extends GenericRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Registration> fetchAllUser(){		
		return entityManager.createQuery("select r from Registration r").getResultList();
	}
	
	public void deleteUser(int userId) {
		entityManager.createQuery("delete from Registration r where r.userId = :userId").setParameter("userId", userId).executeUpdate();
	}

}
