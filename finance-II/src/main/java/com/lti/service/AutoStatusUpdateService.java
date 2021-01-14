package com.lti.service;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.AutoChangeStatusRepository;
import com.lti.entity.Installments;
 
@Component("due")
public class AutoStatusUpdateService {
	
	@Autowired
	AutoChangeStatusRepository autoChangeStatusRepository;
 
    public void changeStatus() {

    	List<Installments> installments = autoChangeStatusRepository.fetchAllInstallment();
    	for (Installments installment : installments) {
    		
			LocalDate dueDate = installment.getDueDate();
			
			if(installment.getStatus().equalsIgnoreCase("unpaid")) {
				if(dueDate.compareTo(LocalDate.now()) < 0) {
					installment.setStatus("due");
					//send email installment due today
				}
			}
			else if(installment.getStatus().equalsIgnoreCase("due")) {
				//send email installment due ,still not paid for LocalDate.now().compareTo(dueDate) days.
			}
			
			autoChangeStatusRepository.store(installment);
			
		}
    	
    	
    	
    }
}