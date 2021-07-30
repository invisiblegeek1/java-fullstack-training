package com.revature.project0.repository;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcPreparedStatement;
import com.revature.project0.Exception.TransactionNotFoundException;
import com.revature.project0.Exception.UserNotFoundException;
import com.revature.project0.database.DbConnectionFactory;
import com.revature.project0.repository.UserRepository;
import com.revature.project0.entity.User;

public class JdbcToUserRepository implements UserRepository {
	Connection conn;

	@Override
	public List<User> findUser(String column, int value) {
		List<User> list = new ArrayList<>();

		try {
			conn = DbConnectionFactory.getConnection();

			String findQuery = "select * from `users` where " + column + "=" + value;
			PreparedStatement ps = conn.prepareStatement(findQuery);
//			ps.setString(1, column);
//			ps.setInt(1, value);

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

	@Override
	public List<User> findByMobile(int mobile) {

		System.out.println("find by mobile");
		 return findUser("mobile", mobile);

	}

	@Override
	public List<User> findByAccNo(int accNo) {

		 return findUser("accNo", accNo);
	}

	// create a new user in database

	@Override
	public List<User> createUser(String username, int mobile) {

		
		try {
			conn = DbConnectionFactory.getConnection();

			int accNo = 200 * mobile;
			int accBal = 5000;
			
			

//			CallableStatement nsf = conn.prepareCall("{call newuser_procedure(?,?,?,?)}");
			
			String addQuery = "insert into `users`(username,accNo,accBal,mobile) values(?,?,?,?)";

			PreparedStatement  nsf= conn.prepareStatement(addQuery);

			nsf.setString(1, username);
			nsf.setInt(2, accNo);
			nsf.setInt(3, accBal);
			nsf.setInt(4, mobile);

			nsf.execute();

			

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
