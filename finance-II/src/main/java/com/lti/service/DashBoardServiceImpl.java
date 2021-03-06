package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.DashBoardRepository;
import com.lti.entity.EMICard;
import com.lti.entity.Installments;
import com.lti.entity.Purchases;

@Service
public class DashBoardServiceImpl implements DashBoardService{

	@Autowired
	DashBoardRepository dashBoardRepository;
	
	public EMICard getCard(int userId) {		
		return dashBoardRepository.fetchCardByUserId(userId);
	}

	public List<Purchases> getPurchaseHistory(int userId) {
		return dashBoardRepository.fetchPurchaseHistory(userId);
	}

	public List<Installments> getInstallmentHistory(int id) {
		return dashBoardRepository.fetchInstallmentHistory(id);
	}

	public void upgrade(long cardNo) {
		
		EMICard card =  dashBoardRepository.fetch(EMICard.class, cardNo);
		if(card.getCardType().equalsIgnoreCase("gold")) {
			card.setCardType("platinum");
			card.setBalance(card.getBalance() + 50000);
			dashBoardRepository.store(card);
		}
	}
	
}
