package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.dao.LoginRepository;
import com.lti.entity.Registration;
import com.lti.exception.LoginServiceException;

public class LoginServiceImpl implements LoginService {

	
	@Autowired
	private LoginRepository loginRepository;
	
	
	public Registration login(String email, String password) {
		
		try {
				if (!loginRepository.isCustomerPresent(email)) {
					throw new LoginServiceException("Customer not registered!");
				} else {
					int id = loginRepository.findByEmailAndPassword(email, password);
					Registration registration = loginRepository.fetch(Registration.class, id);

					return registration;//EmptyResultDataAccessException
				}

			} catch (Exception e) {

				throw new LoginServiceException("Incorrect email/password");

			}

		}
	}

	

