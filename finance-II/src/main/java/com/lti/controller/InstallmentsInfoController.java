package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Installments;
import com.lti.service.InstallmentsService;
@RestController
@CrossOrigin
public class InstallmentsInfoController {
	@Autowired
	private InstallmentsService installmentService;
	@GetMapping("/installments-info")
	public List<Installments> fetchAllInstallments(){
		return installmentService.fetchAllInstallments();
	}

}
