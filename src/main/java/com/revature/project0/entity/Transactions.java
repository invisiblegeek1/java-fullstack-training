package com.revature.project0.entity;

public interface Transactions {
	
	public void  sendMoney(int debitAccNo,int creditAccNo, int transactAmount);
	
	public void listTransactions();

}
