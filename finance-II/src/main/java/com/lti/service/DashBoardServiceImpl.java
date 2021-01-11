package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.DashBoardRepository;
import com.lti.entity.EMICard;

@Service
public class DashBoardServiceImpl implements DashBoardService{

	@Autowired
	DashBoardRepository dashBoardRepository;
	
	public EMICard getCard(int userId) {		
		return dashBoardRepository.fetchCardByUserId(userId);
	}
	
}
