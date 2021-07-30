package com.revature.project0.repository;

import java.sql.Timestamp;
import java.util.List;

import com.revature.project0.entity.Transaction;

public interface TransactionRepository {

	public List<Transaction> transferMoney(int debitAccNo, int creditAccNo, int transactAmount);

	public List<Transaction> listTransactions(int debitAccNo);
	
	public void updateAccount(int debitAccNo,int creditAccNo,int transferAmount);
	
	public List<Transaction> selectByDate(String fromDate,String toDate);

}
