package com.lti.entity;

import java.time.LocalDate;
import com.lti.entity.Purchases;
import javax.persistence.*;

@Entity
public class Installments {
	
	  @Id
	  @GeneratedValue
	  @Column(name="Id")
	  private int installmentId;
	  
	
	  @Column(name="Payment_Date")
	  private LocalDate paymentDate;
	  
	  @Column(name="Amount_Paid")
	  private double amountPaid;
	  
	  @Column(name="Due_date")
	  private LocalDate dueDate;
	  
	  @Column(name="Status")
	  private String status;
	  
	  
	  private Purchases purchases;


	public int getInstallmentId() {
		return installmentId;
	}


	public void setInstallmentId(int installmentId) {
		this.installmentId = installmentId;
	}


	public LocalDate getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}


	public double getAmountPaid() {
		return amountPaid;
	}


	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}


	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Purchases getPurchases() {
		return purchases;
	}


	public void setPurchases(Purchases purchases) {
		this.purchases = purchases;
	}
	  
	
	  
}
