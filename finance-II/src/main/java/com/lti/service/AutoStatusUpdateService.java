package com.lti.service;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.lti.dao.AutoChangeStatusRepository;
import com.lti.entity.Installments;
 
@Component("due")
public class AutoStatusUpdateService {
	
	@Autowired
	AutoChangeStatusRepository autoChangeStatusRepository;
	
	@Autowired
	private MailSender mailSender;
 
    public void changeStatus() {

    	List<Installments> installments = autoChangeStatusRepository.fetchAllInstallment();
    	for (Installments installment : installments) {
    		
			LocalDate dueDate = installment.getDueDate();
			
			if(installment.getStatus().equalsIgnoreCase("unpaid")) {
				if(dueDate.compareTo(LocalDate.now()) <= 0) {
					installment.setStatus("due");
					
					SimpleMailMessage message = new SimpleMailMessage();
					message.setFrom("guptasubhajit272@gmail.com");
					message.setTo("99subhajit99gupta@gmail.com");
					message.setSubject("Installment payment due.");
					message.setText("Installment payment last date today.");
					
					mailSender.send(message);
				}
			}
			else if(installment.getStatus().equalsIgnoreCase("due")) {
				
				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("guptasubhajit272@gmail.com");
				message.setTo("99subhajit99gupta@gmail.com");
				message.setSubject("Installment payment due.");
				message.setText("email installment due ,still not paid for"+ LocalDate.now().compareTo(dueDate) + " days");
				
				mailSender.send(message);

			}
			
			autoChangeStatusRepository.store(installment);
			
		}
    	
    	
    	
    }
}