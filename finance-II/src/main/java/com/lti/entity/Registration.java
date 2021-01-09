package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Registration {

@Id
@GeneratedValue
@Column(name = "User_Id")
private int userId;

@Column(name = "Name")
private String name;

@Column(name = "DOB")
private LocalDate dateOfBirth;

@Column(name = "Email_Id")
private String email;

@Column(name = "PhoneNo")
private long phoneNo;

@Column(name = "Username")
private String username;

@Column(name = "Password")
private String password;

@Column(name = "Address")
private String address;

@Column(name = "Card_Type")
private String cardType;

@Column(name = "Bank_Name")
private String bankName;

@Column(name = "Savings_Account_No")
private long accountNo;

@Column(name = "IFSC_Code")
private String ifscCode;

@Column(name = "Card_Status")
private String userStatus;

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public LocalDate getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public long getPhoneNo() {
	return phoneNo;
}

public void setPhoneNo(long phoneNo) {
	this.phoneNo = phoneNo;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCardType() {
	return cardType;
}

public void setCardType(String cardType) {
	this.cardType = cardType;
}

public String getBankName() {
	return bankName;
}

public void setBankName(String bankName) {
	this.bankName = bankName;
}

public long getAccountNo() {
	return accountNo;
}

public void setAccountNo(long accountNo) {
	this.accountNo = accountNo;
}

public String getIfscCode() {
	return ifscCode;
}

public void setIfscCode(String ifscCode) {
	this.ifscCode = ifscCode;
}

public String getUserStatus() {
	return userStatus;
}

public void setUserStatus(String userStatus) {
	this.userStatus = userStatus;
}




}
