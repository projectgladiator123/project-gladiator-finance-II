package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.LoginRepository;
import com.lti.entity.Registration;
import com.lti.exception.LoginServiceException;

@Service
public class LoginServiceImpl implements LoginService {

	
	@Autowired
	private LoginRepository loginRepository;
	
	
	public Registration login(String username, String password) {
		
		try {
				if (!loginRepository.isCustomerPresent(username)) {
					throw new LoginServiceException("Customer not registered!");
				} else {
					int id = loginRepository.findByUserNameAndPassword(username, password);
					Registration registration = loginRepository.fetch(Registration.class, id);

					return registration;//EmptyResultDataAccessException
				}

			} catch (Exception e) {

				throw new LoginServiceException("Incorrect username/password");

			}

		}
	}

	

