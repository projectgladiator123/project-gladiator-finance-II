package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Registration;
import com.lti.service.RegistrationService;

@RestController
@CrossOrigin
public class RegistrationController {
		@Autowired
		private RegistrationService registrationService;
		
		@PostMapping("/registration")
		public int regsiter(Registration registration) {
			 return registrationService.register(registration);
			
		}

}
