package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.LoginStatus;
import com.lti.dto.RegisterStatus;
import com.lti.dto.Status.StatusType;
import com.lti.entity.Registration;
import com.lti.exception.CustomerServiceException;
import com.lti.service.RegistrationService;

@RestController
@CrossOrigin
public class RegistrationController {
	@Autowired
	RegistrationService registrationService;
	@PostMapping("/registration")
	public  @ResponseBody RegisterStatus register(@RequestBody Registration registration) {
		
		try {
			int id = registrationService.register(registration);
			
			
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.SUCESS);
			status.setMessage("Registration Successful");
			status.setRegisteredCustomerId(id);
			return status;

		} catch (CustomerServiceException e) {
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;
		} 

}
	}