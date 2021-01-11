package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.EMICard;
import com.lti.service.DashBoardService;

@RestController
@CrossOrigin
public class DashBoardController {
	
	@Autowired
	private DashBoardService dashBoardService;
	
	@GetMapping("/dashboard")
	public EMICard showAll(int userId){
		return dashBoardService.getCard(userId);		
	}

}
