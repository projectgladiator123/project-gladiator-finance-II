package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name = "Product_Id")
	private int productId;
	
	@Column(name = "Product_name")
	private String productName;
	
	private String vendor;
	
	@Column(name = "Price")
	private double productPrice;
	
	@Column(name = "Product_Id")
	private String productDetails;
	
	private EligibilityType eligibility;
	
	private int quantity;
	
	@Column(name = "Max_Tenure_Period(Months)")
	private int maxTenure;
	
	@Column(name = "IMAGE")
	private String productImage;
	
	
	public static enum EligibilityType{
		GOLD,PLATINUM
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getVendor() {
		return vendor;
	}


	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductDetails() {
		return productDetails;
	}


	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}


	public EligibilityType getEligibility() {
		return eligibility;
	}


	public void setEligibility(EligibilityType eligibility) {
		this.eligibility = eligibility;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getMaxTenure() {
		return maxTenure;
	}


	public void setMaxTenure(int maxTenure) {
		this.maxTenure = maxTenure;
	}


	public String getProductImage() {
		return productImage;
	}


	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	

}
