package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Purchase;
import com.lti.service.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/transaction")
	public  void getBuyingStatus(@RequestBody Purchase purchase) {
		
		    transactionService.transactionEntry(purchase.getUserId(), purchase.getProductId(),purchase.getTenurePeriodOpted());
		    
		
	}
	
	
	
}
