package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Installments;

@Repository
public class InstallmentsViewRepo extends GenericRepository{
	@PersistenceContext
	EntityManager entityManager;
	@SuppressWarnings("unchecked")
	public List<Installments> fetchAllInstallme(){
		return entityManager.createQuery("select it from Installments it").getResultList();
		
	}
	
	

}
