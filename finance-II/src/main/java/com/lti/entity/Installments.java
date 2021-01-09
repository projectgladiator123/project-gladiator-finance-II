package com.lti.entity;

import java.time.LocalDate;
import com.lti.entity.Purchases;
import javax.persistence.*;

@Entity
public class Installments {
	  @Id
	  @GeneratedValue
	  @Column(name="Id")
	  private int id;
	  @Column(name="Purchase_Id")
	  Purchases Pid=new Purchases();
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
	
	public Purchases getPid() {
		return Pid;
	}
	public void setPid(Purchases pid) {
		Pid = pid;
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
