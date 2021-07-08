package com.revature.project0;


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
	
	
	
    public static void main( String[] args )
    {
    	Scanner in = new Scanner(System.in);
    	System.out.println("---------------------------------Welcome  to  InstaPay---------------------------------- ");
    	
    	
//    	1357800
//    	173358000
     
    	
       
       
      
      
       
        
        
        
        
       
        
        
    }
}
