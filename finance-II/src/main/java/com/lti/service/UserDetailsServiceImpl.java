package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.UserDetailsRepository;
import com.lti.entity.Registration;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	public List<Registration> showAll() {
		return userDetailsRepository.fetchAllUser();
	}

	public void delete(int userId) {
		userDetailsRepository.deleteUser(userId);		
	}

	public void updateStatus(int userId) {
		userDetailsRepository.updateStatus(userId);		
	}

}
