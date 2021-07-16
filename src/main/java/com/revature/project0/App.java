package com.revature.project0;


import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.revature.project0.repository.JdbcToTransactionRepository;
import com.revature.project0.repository.JdbcToUserRepository;
import com.revature.project0.entity.Transaction;
import com.revature.project0.entity.User;

/**
 * Hello world!
 *
 */


public class App 
{
	
	public void doTranscation(Scanner in ) {
		JdbcToTransactionRepository transcationRepo= new JdbcToTransactionRepository();
	       System.out.println("Enter the debit acc no ");
	       int debitAccNo=in.nextInt();
	       System.out.println("Enter the credit acc no ");
	       int creditAccNo=in.nextInt();
	       System.out.println("Enter the amount you want transfer ");
	       int TransferAmount=in.nextInt();
	       
	       List<Transaction>  transactions = transcationRepo.transferMoney(debitAccNo,creditAccNo,TransferAmount);
	       System.out.println("------------------------------------------------------------------------------------------------------");
	       System.out.println("------------------------------------------your transaction details------------------------------------");
	       
	       transactions.forEach(System.out::println);
		
		
	}
	
	public void accountCreation(Scanner in ) {
		JdbcToUserRepository userRepo = new JdbcToUserRepository();
    	
	       System.out.println("Enter your name ");
	       String name = in.nextLine();
	       System.out.println("Enter your mobile no ");
	       int mobile=in.nextInt();
	       List<User> users = userRepo.createUser(name, mobile);
	       users.forEach(System.out::println);
	       
		
	}
	
	public void viewTransactions(Scanner in)  {
		JdbcToTransactionRepository transacationRepo= new JdbcToTransactionRepository();
		System.out.println("Enter the from date ");
	       String fromDate=in.nextLine();
	       Date fromDateObject = null;
		try {
			fromDateObject = new SimpleDateFormat("dd-mm-yyyy").parse(fromDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       System.out.println("Enter the to date ");
	       String toDate=in.nextLine    ();
	       Date toDateObject = null;
		try {
			toDateObject = new SimpleDateFormat("dd-mm-yyyy").parse(toDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       transacationRepo.selectByDate((Timestamp)fromDateObject, (Timestamp)toDateObject);
	       
	       
		
	}
	
	
	
    public static void main( String[] args ) 
    {
    	App appObj = new App();
    	Scanner in = new Scanner(System.in);
    	//appObj.accountCreation( in );
    	//appObj.doTranscation(in);
   	appObj.viewTransactions(in);
    	
    	
    	System.out.println("---------------------------------Welcome  to  InstaPay----------------------------------\n ");
    	
    	
//    	1357800
//    	173358000
     
    	
       
       
      
      
       
        
        
        
        
       
        
        
    }
}
