package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.EMICard;
import com.lti.entity.Purchases;

@Repository
public class DashBoardRepository {
	
	@PersistenceContext
	EntityManager entityManager;

	public EMICard fetchCardByUserId(int userId) {
		return (EMICard) entityManager.createQuery("select e from EMICard e where e.registration.userId = :userId").setParameter("userId", userId).getSingleResult();
			
	}
	
	@SuppressWarnings("unchecked")
	public List<Purchases> fetchPurchaseHistory(int userId) {
		return entityManager.createQuery("select p from Purchases p where p.registration.userId = :userId").setParameter("userId", userId).getResultList();
	}
}
