package com.lti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.entity.EMICard;
import com.lti.entity.Purchases;

@Service
public interface DashBoardService {
	
	public EMICard getCard(int userId);
	public List<Purchases> getPurchaseHistory(int userId);

}
