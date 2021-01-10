package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class GenericRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public Object store(Object obj) {
		
		Object updatedObj = entityManager.merge(obj);
		return updatedObj;
	}
		
	
	public <E> E  fetch(Class<E> cl, Object pk) {
		
		E  e = entityManager.find(cl, pk);
		return e;
		
	}

}
