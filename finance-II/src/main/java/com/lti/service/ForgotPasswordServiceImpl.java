package com.lti.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.lti.dao.ForgotPasswordRepository;
import com.lti.entity.Registration;
import com.lti.exception.LoginServiceException;
@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {


	@Autowired
	ForgotPasswordRepository forgotPasswordRepository;
	
	@Autowired
	private MailSender mailSender;
	
	public Registration getPasswordThroughEmail(String username) {
		try {
      Registration registration= forgotPasswordRepository.getPasswordByDatabaseThroughEmail(username);
		String emailId=registration.getEmail();
		String password=registration.getPassword();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("guptasubhajit272@gmail.com");
		message.setTo(emailId);
		message.setSubject("Forgot Password Request ");
		message.setText(password);
		
		mailSender.send(message);
		return registration;
		}
		catch (NoResultException e) {

			throw new LoginServiceException("User is not registered");

		}
		
	}

}
