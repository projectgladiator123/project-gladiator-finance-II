package com.lti.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.lti.dao.GenericRepository;
import com.lti.entity.Registration;

@Component
public class RegistrationServiceImpl implements RegistrationService{
	@Autowired
	private GenericRepository genericRepository;
	
	public int register(Registration registration) {
			Registration updatedregister = (Registration) genericRepository.store(registration);
			
			return updatedregister.getUserId();
		}
		
	}

