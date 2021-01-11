package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.EMICard;

@Repository
public class DashBoardRepository {
	
	@PersistenceContext
	EntityManager entityManager;

	public EMICard fetchCardByUserId(int userId) {
		return (EMICard) entityManager.createQuery("select e from EMICard e where e.registration.userId = :userId").setParameter("userId", userId).getSingleResult();
			
	}
}
