package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Purchases {

	public List<Installments> getInstallments() {
		return installments;
	}
	public void setInstallments(List<Installments> installments) {
		this.installments = installments;
	}
	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "User_Id")
	private Registration registration;
	
	@ManyToOne
	@JoinColumn(name = "Product_Id")
	private Product product;
	
	@OneToMany(mappedBy = "purchases", cascade = CascadeType.MERGE)
	private List<Installments> installments;
	
	@Column(name="Tenure_Period_Opted")
	private int tenurePeriodOpted;
	
	@Column(name="Date_Of_Purchase")
	private LocalDate dateOfPurchase;
	
	
	@ManyToOne
	@JoinColumn(name = "Card_No")
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
