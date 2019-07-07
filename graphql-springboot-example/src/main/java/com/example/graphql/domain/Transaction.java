package com.example.graphql.domain;

public class Transaction {
	
	private Integer accountNumber;
	private Integer transactionId;
	private String transactionDate;
	private String transactionDescription;
	private String merchantName;
	
	public Transaction(Integer accountNumber,Integer transactionId, String transactionDate, String transactionDescription, String merchantName) {
		this.accountNumber = accountNumber;
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.transactionDescription = transactionDescription;
		this.merchantName = merchantName;
	}
	
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	
	

}
