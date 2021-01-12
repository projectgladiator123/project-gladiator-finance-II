package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.InstallmentsViewRepo;
import com.lti.entity.Installments;

@Service
public class InstallmentServiceImpl implements InstallmentsService {
	
	@Autowired
	InstallmentsViewRepo installmentsRepository;
	 
	public List<Installments> fetchAllInstallments(){
		return installmentsRepository.fetchAllInstallments();
	}
	

}
