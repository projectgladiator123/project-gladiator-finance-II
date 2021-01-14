package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Installments;

@Repository
public class AutoChangeStatusRepository extends GenericRepository{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Installments> fetchAllInstallment(){
		
		return entityManager.createQuery("select i from Installments i").getResultList();
	}

}
