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
	
public boolean transactionEntry(int userId, int productId, int tenurePeriodOpted) {
		
		Registration registration = genericRepository.fetch(Registration.class,userId);
		EMICard emiCard=  dashBoardRepository.fetchCardByUserId(userId);
		Product product = genericRepository.fetch(Product.class,productId);
		double remainingAmount= product.getProductPrice();
		
		if(emiCard.getBalance() > remainingAmount) {
			
			emiCard.setBalance(emiCard.getBalance() - remainingAmount);
			genericRepository.store(emiCard);
			
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
			return true;
		}
		else {
			//failed 
			return false;
		}
		
		
		
	}

public void installmentPaymentEntry(int installmentId) {
	
	Installments installment = genericRepository.fetch(Installments.class,installmentId);
	int purchaseId=installment.getPurchases().getId();
	Purchases purchase = genericRepository.fetch(Purchases.class,purchaseId);
	double amountPaid =	(purchase.getRemainingAmount()/purchase.getInstallmentsRemaining());
	
	EMICard emiCard = genericRepository.fetch(EMICard.class, purchase.getEmiCard().getCardNo());
	emiCard.setBalance(emiCard.getBalance() + amountPaid);
	genericRepository.store(emiCard);
	
	
	purchase.setRemainingAmount(purchase.getRemainingAmount() - amountPaid);
    purchase.setInstallmentsRemaining(purchase.getInstallmentsRemaining()-1);
   
    
   List<Installments> installments =purchase.getInstallments();
   for (Installments installments2 : installments) {
	   if(installments2.getInstallmentId()==installmentId) {
		   
		   installments2.setAmountPaid(amountPaid);
	       installments2.setPaymentDate(LocalDate.now());
	       installments2.setStatus("paid");
	   }
	
}    
   purchase.setInstallments(installments);
   genericRepository.store(purchase);

   
  
	
}
	
}
