package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Registration;
import com.lti.service.UserDetailsService;

@RestController
@CrossOrigin
public class UserDetailsController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@PostMapping("/user-details")
	public @ResponseBody List<Registration> showAll(){
		return  userDetailsService.showAll();		
	}

}
