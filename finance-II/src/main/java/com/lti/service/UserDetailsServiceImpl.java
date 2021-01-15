package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.lti.dao.UserDetailsRepository;
import com.lti.entity.EMICard;
import com.lti.entity.Registration;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Autowired
	private MailSender mailSender;
	
	public List<Registration> showAll() {
		return userDetailsRepository.fetchAllUser();
	}

	public void delete(int userId) {
		userDetailsRepository.deleteUser(userId);		
	}

	public void updateStatus(int userId) {
		userDetailsRepository.updateStatus(userId);		
	}

	@Override
	public long addCard(int userId, String cardType) {
		Registration registration = userDetailsRepository.fetch(Registration.class, userId);
		
		EMICard emiCard = new EMICard();
		emiCard.setCardType(cardType);
		emiCard.setBalance(cardType.equalsIgnoreCase("gold")?100000:150000);
		emiCard.setValidityOfCard(LocalDate.now().plusYears(5));
		emiCard.setRegistration(registration);
		
		EMICard updatedEmiCard = (EMICard) userDetailsRepository.store(emiCard); 
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("guptasubhajit272@gmail.com");
		message.setTo(registration.getEmail());
		message.setSubject("User Activated.");
		message.setText("Your request for card is granted. Card is generated with card number "+ updatedEmiCard.getCardNo() + ". For more details login to your account.");
		
		mailSender.send(message);
		return updatedEmiCard.getCardNo();
	}

}
