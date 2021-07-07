package com.revature.project0.entity;

/*
 * Table: transactions
Columns:
transactionId int AI PK
transactionAmount int
debitedAccNo int
creditedAccNo int
userid int
dateOfTransaction times
 * 
 * 
 * 
 * 
 */

public class Transaction {
	
	private int transcationid;
	private int transactionAmount;
	private int debitedAccNo;
	private int creditedAccNo;
	
	// constructor for Transaction
	
	public  Transaction(int transcationid, int transactionAmount, int debitedAccNo, int creditedAccNo) {
		super();
		this.transcationid = transcationid;
		this.transactionAmount = transactionAmount;
		this.debitedAccNo = debitedAccNo;
		this.creditedAccNo = creditedAccNo;
	}

	public int getTranscationid() {
		return transcationid;
	}

	public void setTranscationid(int transcationid) {
		this.transcationid = transcationid;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public int getDebitedAccNo() {
		return debitedAccNo;
	}

	public void setDebitedAccNo(int debitedAccNo) {
		this.debitedAccNo = debitedAccNo;
	}

	public int getCreditedAccNo() {
		return creditedAccNo;
	}

	public void setCreditedAccNo(int creditedAccNo) {
		this.creditedAccNo = creditedAccNo;
	}

	@Override
	public String toString() {
		return "TransactionDetails [transcationid=" + transcationid + ", transactionAmount=" + transactionAmount
				+ ", debitedAccNo=" + debitedAccNo + ", creditedAccNo=" + creditedAccNo + "]";
	}
	
	
	
	
	
	
	
	
	

}
