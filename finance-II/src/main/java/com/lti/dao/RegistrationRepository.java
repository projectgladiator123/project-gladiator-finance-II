package com.lti.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.lti.entity.Registration;

@Repository
public class RegistrationRepository extends GenericRepository {

	//@Transactional
	//public int registerUser(Registration registration) {
		//Registration newreg=entityManager.merge(registration);
		//return newreg.getUserId();
	}
	


