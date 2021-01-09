package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Purchases {

	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
	
	private Registration registration;
	private Product product;
	
	@Column(name="Tenure_Period_Opted")
	private int tenurePeriodOpted;
	
	@Column(name="Date_Of_Purchase")
	private LocalDate dateOfPurchase;
	
	private EMICard emiCard;
	
	@Column(name="Remaining_Amount")
	private double remainingAmount;
	
	@Column(name="Installments_Remaining")
	private int installmentsRemaining;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Registration getRegistration() {
		return registration;
	}
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getTenurePeriodOpted() {
		return tenurePeriodOpted;
	}
	public void setTenurePeriodOpted(int tenurePeriodOpted) {
		this.tenurePeriodOpted = tenurePeriodOpted;
	}
	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public EMICard getEmiCard() {
		return emiCard;
	}
	public void setEmiCard(EMICard emiCard) {
		this.emiCard = emiCard;
	}
	public double getRemainingAmount() {
		return remainingAmount;
	}
	public void setRemainingAmount(double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	public int getInstallmentsRemaining() {
		return installmentsRemaining;
	}
	public void setInstallmentsRemaining(int installmentsRemaining) {
		this.installmentsRemaining = installmentsRemaining;
	}
	
	
	
}
