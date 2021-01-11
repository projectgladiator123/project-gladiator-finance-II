package com.lti.service;

import org.springframework.stereotype.Service;

import com.lti.entity.EMICard;

@Service
public interface DashBoardService {
	
	public EMICard getCard(int userId);

}
