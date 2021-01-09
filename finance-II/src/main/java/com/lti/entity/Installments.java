package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Installments {
	  @Id
	 
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  
	  private int id;
	  private int purchase_id;
	  private LocalDate Payment_Date;
	  private long Amount_Paid;
	  private LocalDate Due_Date;
	  
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

	public LocalDate getPayment_Date() {
		return Payment_Date;
	}

	public void setPayment_Date(LocalDate payment_Date) {
		Payment_Date = payment_Date;
	}

	public long getAmount_Paid() {
		return Amount_Paid;
	}

	public void setAmount_Paid(long amount_Paid) {
		Amount_Paid = amount_Paid;
	}

	public LocalDate getDue_Date() {
		return Due_Date;
	}

	public void setDue_Date(LocalDate due_Date) {
		Due_Date = due_Date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	   
	  
	  
}
