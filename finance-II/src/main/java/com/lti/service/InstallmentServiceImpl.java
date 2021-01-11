package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.dao.InstallmentsViewRepo;
import com.lti.entity.Installments;


public class InstallmentServiceImpl {

	@Autowired
	InstallmentsViewRepo installmentsRepository;
	
	public List<Installments> fetchAllInstallments() {
		
		return installmentsRepository.fetchAllInstallments();
	}

}
