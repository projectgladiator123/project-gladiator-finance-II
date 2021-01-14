package com.lti.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminRepository;
import com.lti.entity.Admin;
import com.lti.entity.Registration;
import com.lti.exception.LoginServiceException;

@Service
public class AdminDetailsServiceImpl implements AdminDetailsService {

	@Autowired
	private AdminRepository adminRepository;
	
	
	public Admin login(String username, String password) {
		
			
			try {
					if (!adminRepository.checkIfPersonIsReallyAnAdmin(username)) {
						throw new LoginServiceException("person is not an admin!");
					} else {
						int id = adminRepository.findByUserNameAndPassword(username, password);
						Admin admin= adminRepository.fetch(Admin.class, id);

						return admin;
					}

				} catch (NoResultException e) {

					throw new LoginServiceException("Incorrect username/password");

				}

			
		
	}

}
