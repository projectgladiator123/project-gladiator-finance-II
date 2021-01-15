package com.lti.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
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
	private JavaMailSender mailSender;
	
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
			
			product.setQuantity(product.getQuantity()-1);
			genericRepository.store(product);
			
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
			
			//generate invoice
			Document dc = new Document();
			try {
				PdfWriter writer = PdfWriter.getInstance(dc, new FileOutputStream("C:\\Users\\subha\\Documents\\GitRepo\\project-gladiator-finance-II\\finance-II\\invoice.pdf"));
				dc.open();
				dc.add(new Paragraph("Product Details"));
				dc.add(new Paragraph("Product : " + product.getProductName()));
				dc.add(new Paragraph(product.getProductDetails()));
				dc.add(new Paragraph("Seller : " + product.getVendor()));
				dc.add(new Paragraph("Price : " + product.getProductPrice()));
				
				dc.add(new Paragraph("Bought By : " + registration.getName()));
				dc.add(new Paragraph("Shipping Address : " + registration.getAddress()));
				dc.add(new Paragraph("Contact Number : " + registration.getPhoneNo() ));
				
				
				dc.add(new Paragraph("Card number : " + emiCard.getCardNo()));
				dc.add(new Paragraph("Card type : " + emiCard.getCardType()));
				
				
				dc.add(new Paragraph("Installments to be paid : " + tenurePeriodOpted));
				dc.add(new Paragraph("Money to be paid in each installment: " + remainingAmount/tenurePeriodOpted));
				dc.add(new Paragraph("Due date for each installment"));
				for(int i= 0;i<tenurePeriodOpted;i++) {
					dc.add(new Paragraph(i+1 +"th installment due date : "+LocalDate.now().plusMonths(i+1).toString()));
				}
				
				dc.close();
				writer.close();
				

				
				MimeMessagePreparator preparator = new MimeMessagePreparator() 
			    {
			        public void prepare(MimeMessage mimeMessage) throws Exception 
			        {
			            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(registration.getEmail()));
			            mimeMessage.setFrom(new InternetAddress("guptasubhajit272@gmail.com"));
			            mimeMessage.setSubject("Invoice");
			            mimeMessage.setText("Purchase Succesfull");
			             
			            FileSystemResource file = new FileSystemResource(new File("C:\\Users\\subha\\Documents\\GitRepo\\project-gladiator-finance-II\\finance-II\\invoice.pdf"));
			            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			            helper.addAttachment("invoice.pdf", file);
			            helper.setText("", true);
			        }
			    };
				
				mailSender.send(preparator);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			
			
			
			
			return true;
		}
		else return false;
		
		
		
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
