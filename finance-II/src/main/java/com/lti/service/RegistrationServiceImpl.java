package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.RegistrationRepository;
import com.lti.entity.Registration;
@Service
public class RegistrationServiceImpl implements RegistrationService{
	@Autowired
	RegistrationRepository repo;
	public int register(Registration registration) {
		return repo.registerUser(registration);
		
	}
}
