package com.revature.project0;

import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.revature.project0.repository.JdbcToTransactionRepository;
import com.revature.project0.repository.JdbcToUserRepository;
import com.revature.project0.entity.Transaction;
import com.revature.project0.entity.User;



public class App {
	public int greetAndMenu(Scanner in) {
		System.out
				.println("---------------------------------Welcome  to  InstaPay----------------------------------\n ");
		System.out.println("Enter your option\n ");
		System.out.println("1. To Create New User\n ");
		System.out.println("2. To make new transaction \n ");
		System.out.println("3. To list transaction \n ");
		int optionValue = in.nextInt();
		return optionValue;
		

	}

	public void doTranscation(Scanner in) {
		JdbcToTransactionRepository transcationRepo = new JdbcToTransactionRepository();
		System.out.println("Enter the debit acc no ");
		int debitAccNo = in.nextInt();
		System.out.println("Enter the credit acc no ");
		int creditAccNo = in.nextInt();
		System.out.println("Enter the amount you want transfer ");
		int TransferAmount = in.nextInt();

		List<Transaction> transactions = transcationRepo.transferMoney(debitAccNo, creditAccNo, TransferAmount);
		System.out.println(
				"------------------------------------------------------------------------------------------------------");
		System.out.println(
				"------------------------------------------your transaction details------------------------------------");

		transactions.forEach(System.out::println);

	}

	public void accountCreation(Scanner in) {
		JdbcToUserRepository userRepo = new JdbcToUserRepository();

		System.out.println("Enter your name \n");
		String name = in.next();
		System.out.println("Enter your mobile no \n");
		int mobile = in.nextInt();
		List<User> users = userRepo.createUser(name, mobile);
		users.forEach(System.out::println);

	}
	

	public void viewTransactions(Scanner in) {
		JdbcToTransactionRepository transacationRepo = new JdbcToTransactionRepository();
		System.out.println("Enter your option to list transactions ");
		System.out.println("1. list top ten transcations ");
		System.out.println("2. list  transcations between date range ");
		int  option= in.nextInt();
		switch (option) {
		case 1:
			List<Transaction> topTenTransactions = transacationRepo.listTopTenTransactions();
			topTenTransactions.forEach(System.out::println);
			break;
		case 2:
			System.out.println("Enter the from date like yyyy-mm-dd ");
			String fromDate = in.next();
			System.out.println("Enter the to date like yyyy-mm-dd ");
			String toDate = in.next();
			List<Transaction> ts = transacationRepo.selectByDate(fromDate, toDate);
			ts.forEach(System.out::println);
			break;

		default:
			break;
		}
		
		
		

	}

	public static void main(String[] args) {
		App appObj = new App();
		Scanner in = new Scanner(System.in);
		int option=appObj.greetAndMenu(in);
		switch (option) {
		case 1:
			appObj.accountCreation( in );
			break;
		case 2:
			appObj.doTranscation(in);
			break;
		case 3:
			appObj.viewTransactions(in);
			break;	
			

		default:
			System.out.println("invalid data");
			break;
		}
		// appObj.accountCreation( in );
		//appObj.doTranscation(in);
//    	appObj.viewTransactions(in);

//    	1357800
//    	173358000

	}
}
