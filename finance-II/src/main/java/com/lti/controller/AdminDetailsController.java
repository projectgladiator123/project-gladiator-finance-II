package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Login;
import com.lti.dto.LoginStatus;
import com.lti.dto.Status.StatusType;
import com.lti.entity.Admin;
import com.lti.exception.LoginServiceException;
import com.lti.service.AdminDetailsService;

@RestController
@CrossOrigin
public class AdminDetailsController {

	@Autowired
	private AdminDetailsService adminDetailsService;

	@PostMapping("/admin-login")
	public @ResponseBody LoginStatus login(@RequestBody Login login) {
		try {
			Admin admin = adminDetailsService.login(login.getUsername(), login.getPassword());
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.SUCESS);
			status.setMessage("Login Successful");
			
			
			return status;

		} catch (LoginServiceException e) {
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	
}
