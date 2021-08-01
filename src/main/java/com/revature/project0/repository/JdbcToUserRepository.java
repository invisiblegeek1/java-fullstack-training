package com.revature.project0.repository;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mysql.cj.jdbc.JdbcPreparedStatement;
import com.revature.project0.Exception.TransactionNotFoundException;
import com.revature.project0.Exception.UserNotFoundException;
import com.revature.project0.database.DbConnectionFactory;
import com.revature.project0.repository.UserRepository;
import com.revature.project0.entity.User;

public class JdbcToUserRepository implements UserRepository {
	Connection conn;
	public static Logger loggers = Logger.getLogger("app");

	@Override
	public List<User> findUser(String column, int value) {
		List<User> list = new ArrayList<>();

		try {
			conn = DbConnectionFactory.getConnection();

			String findQuery = "select * from `users` where " + column + "=" + value;
			PreparedStatement ps = conn.prepareStatement(findQuery);


			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setAccNo(rs.getInt("accNo"));
				user.setName(rs.getString("username"));
				user.setAccBal(rs.getInt("accBal"));
				user.setId(rs.getInt("id"));
				list.add(user);
			}
			if(list==null) {
				
				throw new UserNotFoundException("invalid data");
				
			}

		} catch (SQLException | UserNotFoundException e) {
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
	// User has selected based on mobile number
	@Override
	public List<User> findByMobile(int mobile) {

		System.out.println("find by mobile");
		 return findUser("mobile", mobile);

	}
	// User has selected based on account number
	@Override
	public List<User> findByAccNo(int accNo) {

		 return findUser("accNo", accNo);
	}

	// create a new user in database

	@Override
	public List<User> createUser(String username, int mobile) {
		

		
		try {
			conn = DbConnectionFactory.getConnection();
			
			String IFSC_CODE="6023";
			String IFSCWithAccNo=IFSC_CODE+Integer.toString(mobile);
			
			

			int accNo = Integer.parseInt(IFSCWithAccNo);
			int accBal = 5000;
			
			


			
			String addQuery = "insert into `users`(username,accNo,accBal,mobile) values(?,?,?,?)";

			PreparedStatement  nsf= conn.prepareStatement(addQuery);

			nsf.setString(1, username);
			nsf.setInt(2, accNo);
			nsf.setInt(3, accBal);
			nsf.setInt(4, mobile);

			nsf.execute();

			
			loggers.info("Account created succesfully");
			System.out.println("Account created succesfully");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return findByMobile(mobile);

	}

	
}
