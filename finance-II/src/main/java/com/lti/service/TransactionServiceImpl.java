package com.lti.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.DashBoardRepository;
import com.lti.dao.GenericRepository;
import com.lti.entity.EMICard;
import com.lti.entity.Installments;
import com.lti.entity.Product;
import com.lti.entity.Purchases;
import com.lti.entity.Registration;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private GenericRepository genericRepository;
	
	@Autowired
	private DashBoardRepository dashBoardRepository;
	
public void transactionEntry(int userId, int productId, int tenurePeriodOpted) {
		
		Registration registration = genericRepository.fetch(Registration.class,userId);
		EMICard emiCard=  dashBoardRepository.fetchCardByUserId(userId);
		Product product = genericRepository.fetch(Product.class,productId);
		double remainingAmount= product.getProductPrice();
		
		Purchases purchases = new Purchases();
		purchases.setDateOfPurchase(LocalDate.now());
		purchases.setTenurePeriodOpted(tenurePeriodOpted);
		purchases.setInstallmentsRemaining(tenurePeriodOpted);
		purchases.setRemainingAmount(remainingAmount);
		purchases.setEmiCard(emiCard);
		purchases.setRegistration(registration);
		purchases.setProduct(product);
		
		
		List<Installments> installments = new ArrayList<Installments>();
		
		
		
		for(int i= 0;i<tenurePeriodOpted;i++) {
			Installments installment = new Installments();
			installment.setAmountPaid(0);
			installment.setDueDate(LocalDate.now().plusMonths(i+1));
			installment.setPaymentDate(null);
			installment.setStatus("unpaid");
			installment.setPurchases(purchases);
			installments.add(installment);			
		}
		purchases.setInstallments(installments);
		genericRepository.store(purchases);
	}
	
}
