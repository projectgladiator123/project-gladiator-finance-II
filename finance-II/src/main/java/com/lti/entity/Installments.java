package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Installments {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="Id")
	  private int id;
	  @Column(name="PurchaseId")
	  private int purchase_id;
	  @Column(name="Payment_Date")
	  private LocalDate paymentDate;
	  @Column(name="Amount_Paid")
	  private long amountPaid;
	  @Column(name="Due_Date")
	  private LocalDate dueDate;
	  @Column(name="Status")
	  private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public long getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(long amountPaid) {
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
	 

	
	   
	  
	  
}
