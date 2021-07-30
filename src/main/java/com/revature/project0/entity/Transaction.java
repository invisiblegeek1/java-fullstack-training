package com.revature.project0.entity;

import java.sql.Timestamp;

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
	private String timeStamp;
	
	// constructor for Transaction
	
	

	public  Transaction() {
		super();
		this.transcationid = transcationid;
		this.transactionAmount = transactionAmount;
		this.debitedAccNo = debitedAccNo;
		this.creditedAccNo = creditedAccNo;
		this.timeStamp=timeStamp;
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
	
	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStemp) {
		this.timeStamp = timeStemp;
	}

	@Override
	public String toString() {
		System.out.println("------------------------------------------------------------------------------------------------------");
		return "\n"
				+ "transcationid : \t" + transcationid + "\ntransactionAmount : \t" + transactionAmount
				+ "\ndebitedAccNo : \t" + debitedAccNo + "\ncreditedAccNo : \t" + creditedAccNo + "\ntimeStamp : \t" + timeStamp+
				"\n------------------------------------------------------------------------------------------------------"
				;
	}

	
	
	
	
	
	
	
	
	
	

}
