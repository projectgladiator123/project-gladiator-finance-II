package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.EMICard;
import com.lti.entity.Installments;
import com.lti.entity.Purchases;
import com.lti.service.DashBoardService;

@RestController
@CrossOrigin
public class DashBoardController {
	
	@Autowired
	private DashBoardService dashBoardService;
	
	@GetMapping("/dashboard-card")
	public EMICard showAll(int userId){
		return dashBoardService.getCard(userId);		
	}
	
	@GetMapping("/dashboard-purchase-history")
	public List<Purchases> fetchPurchase(int userId){
		return dashBoardService.getPurchaseHistory(userId);
	}
	
	@GetMapping("/dashboard-installment-history")
	public List<Installments> fetchInstallments(int id){
		return dashBoardService.getInstallmentHistory(id);
	}
		
	@GetMapping("/upgrade")
	public void upgrade(long cardNo){
		dashBoardService.upgrade(cardNo);
	}

}
