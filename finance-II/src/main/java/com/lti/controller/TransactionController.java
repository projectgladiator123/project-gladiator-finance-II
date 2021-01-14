package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Purchase;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.service.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/transaction")
	public  @ResponseBody Status getBuyingStatus(@RequestBody Purchase purchase) {
		
		if(transactionService.transactionEntry(purchase.getUserId(), purchase.getProductId(),purchase.getTenurePeriodOpted())) {
			 Status status = new Status();
			 status.setStatus(StatusType.SUCESS);

			 
			 status.setMessage("Payment Successfull. Bought succesfully. Product Will be delivered ");
			 return status;
		}
		else {
			Status status = new Status();
			 status.setStatus(StatusType.FAILED);
			 status.setMessage("Payment Rejected !!!!! Not enough credits.");

			 return status;
			
		}
	}
	
	@GetMapping("/installment-payment")
	public @ResponseBody Status gettingPaymentUpdates(@RequestParam("installmentId") int installmentId) {
		transactionService.installmentPaymentEntry(installmentId);		
		    Status status = new Status();
		    status.setStatus(StatusType.InstallmentPaid);
		    status.setMessage("your EMI for this month is paid");
		    return status;
	}
	
	
	
	
}
