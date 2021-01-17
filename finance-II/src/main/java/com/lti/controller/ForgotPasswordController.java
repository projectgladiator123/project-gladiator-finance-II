package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.LoginStatus;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entity.Registration;
import com.lti.exception.LoginServiceException;
import com.lti.service.ForgotPasswordService;

@RestController
@CrossOrigin
public class ForgotPasswordController {
	
	@Autowired
	ForgotPasswordService forgotPasswordService;
     
	@GetMapping("/recover-password")
	public @ResponseBody Status gettingPaymentUpdates(@RequestParam("username") String username) {
		try {
		Registration registration= forgotPasswordService.getPasswordThroughEmail(username);
		
			Status status = new Status();
			status.setStatus(StatusType.SUCESS);
			status.setMessage(registration.getUsername()+" your password is recovered check your email account registered with the company");
			return status;
		}
		catch (LoginServiceException e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;
		}
		
	}
	
	
	
}
