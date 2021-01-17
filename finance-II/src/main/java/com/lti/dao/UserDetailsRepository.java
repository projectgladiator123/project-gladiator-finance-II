package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
	
	@Transactional
	public void deleteUser(int userId) {
		entityManager.createQuery("delete from Registration r where r.userId = :userId").setParameter("userId", userId).executeUpdate();
	}
	
	@Transactional
	public void updateStatus(int userId) {
		entityManager.createQuery("update Registration r set r.userStatus = :status  where r.userId = :userId").setParameter("userId", userId).setParameter("status", "activated").executeUpdate();
	}

	@Transactional
	public void deleteProduct(int productId) {
		entityManager.createQuery("delete from Product p where p.productId = :productId").setParameter("productId", productId).executeUpdate();
		
	}

}
