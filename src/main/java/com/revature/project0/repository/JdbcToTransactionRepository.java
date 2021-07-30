package com.revature.project0.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.project0.Exception.DateNotFoundException;
import com.revature.project0.Exception.TransactionNotFoundException;
import com.revature.project0.database.DbConnectionFactory;
import com.revature.project0.entity.Transaction;
import com.revature.project0.entity.User;

public class JdbcToTransactionRepository implements TransactionRepository {

	Connection conn;

	@Override
	public List<Transaction> transferMoney(int debitAccNo, int creditAccNo, int transactAmount) {
		
		LocalDate today = LocalDate.now();
		String date = today.toString();

		List<Transaction> list = new ArrayList<>();

		try {
			conn = DbConnectionFactory.getConnection();

			String addQuery = "insert into `transactions`(transactionAmount,debitedAccNo,creditedAccNo,dateOfTransaction) values(?,?,?,?)";

			PreparedStatement ps2 = conn.prepareStatement(addQuery);
			ps2.setInt(1, transactAmount);
			ps2.setInt(2, debitAccNo);
			ps2.setInt(3, creditAccNo);
			ps2.setString(4, date);

			this.updateAccount(debitAccNo, creditAccNo, transactAmount);

			ps2.executeUpdate();

			System.out.println("transaction completed");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listTransactions(debitAccNo);

	}

	@Override
	public List<Transaction> listTransactions(int debitAccNo) {

		List<Transaction> list = new ArrayList<>();

		try {
			conn = DbConnectionFactory.getConnection();

			String selectQuery = "select * from `transactions` where debitedAccNo=?";

			PreparedStatement ps2 = conn.prepareStatement(selectQuery);
			ps2.setInt(1, debitAccNo);

			ResultSet rs = ps2.executeQuery();

			while (rs.next()) {
				Transaction ts1 = new Transaction();
				ts1.setCreditedAccNo(rs.getInt("creditedAccNo"));
				ts1.setDebitedAccNo(rs.getInt("debitedAccNo"));
				ts1.setTransactionAmount(rs.getInt("transactionAmount"));
				ts1.setTranscationid(rs.getInt("transactionId"));
				ts1.setTimeStamp(rs.getString("dateOfTransaction"));
				list.add(ts1);
			}
			if(list==null) {
				
				throw new TransactionNotFoundException("invalid Acc no");
			}

		} catch (SQLException | TransactionNotFoundException e) {
			e.printStackTrace();

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;

	}

	@Override
	public void updateAccount(int debitAccNo, int creditAccNo, int transferAmount) {

		try {
			conn = DbConnectionFactory.getConnection();

			String debitQuery = "update users set accBal=accBal-? where accNo=?";
			String creditQuery = "update users set accBal=accBal+? where accNo=?";

			PreparedStatement dbQ = conn.prepareStatement(debitQuery);
			dbQ.setInt(1, transferAmount);
			dbQ.setInt(2, debitAccNo);
			dbQ.executeUpdate();
			System.out.println("The amount of " + transferAmount + " has debited from " + debitAccNo + " successfully");
			PreparedStatement crQ = conn.prepareStatement(creditQuery);
			crQ.setInt(1, transferAmount);
			crQ.setInt(2, creditAccNo);
			crQ.executeUpdate();
			System.out.println("The amount of " + transferAmount + " has credited into " + creditAccNo + " successfully");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	
	@Override
	public List<Transaction> selectByDate(String fromDate,String toDate) {
		List<Transaction> list = new ArrayList<>();
		
		
		
		
		try {
			conn = DbConnectionFactory.getConnection();

			String dateQuery = "SELECT * FROM `transactions` where dateOfTransaction between ? and ?";
			
			

			PreparedStatement sbQ = conn.prepareStatement(dateQuery);
			sbQ.setString(1, fromDate);
			sbQ.setString(2, toDate);
			
			ResultSet rs = sbQ.executeQuery();

			while (rs.next()) {
				Transaction ts1 = new Transaction();
				ts1.setCreditedAccNo(rs.getInt("creditedAccNo"));
				ts1.setDebitedAccNo(rs.getInt("debitedAccNo"));
				ts1.setTransactionAmount(rs.getInt("transactionAmount"));
				ts1.setTranscationid(rs.getInt("transactionId"));
				ts1.setTimeStamp(rs.getString("dateOfTransaction"));
				list.add(ts1);
			}
			if(list==null) {
				
				throw new DateNotFoundException("invalid date");
			}
			

		} catch (SQLException | DateNotFoundException e) {
			e.printStackTrace();

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
		
	}

}
