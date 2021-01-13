package com.lti.service;

public interface TransactionService {

	public void transactionEntry(int userId,int productId,int tenurePeriodOpted);
	public void installmentPaymentEntry(int installmentId);
}
