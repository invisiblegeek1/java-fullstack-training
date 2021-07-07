package com.revature.project0;


import java.util.List;
import java.util.Scanner;

import com.revature.project0.repository.JdbcToUserRepository;
import com.revature.project0.entity.User;

/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args )
    {
    	Scanner in = new Scanner(System.in);
    	JdbcToUserRepository userRepo = new JdbcToUserRepository();
    	
       System.out.println("Enter your name ");
       String name = in.nextLine();
       System.out.println("Enter your mobile no ");
       int mobile=in.nextInt();
       
////        
////        
       List<User> users = userRepo.createUser(name, mobile);
//        List<User> users = userRepo.findUser("accNo", 4213);
        users.forEach(System.out::println);
        
        
        
        
       
        
        
    }
}
