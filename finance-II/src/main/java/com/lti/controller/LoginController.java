package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lti.dto.Login;
import com.lti.dto.LoginStatus;
import com.lti.dto.Status.StatusType;
import com.lti.entity.Registration;
import com.lti.exception.LoginServiceException;
import com.lti.service.LoginService;

public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public LoginStatus login(@RequestBody Login login) {
		try {
			Registration registration = loginService.login(login.getEmail(), login.getPassword());
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.SUCESS);
			status.setMessage("Login Successful");
			status.setCustomerId(registration.getUserId());
			status.setCustomerName(registration.getName());
			return status;

		} catch (LoginServiceException e) {
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;
		}
	}
}
