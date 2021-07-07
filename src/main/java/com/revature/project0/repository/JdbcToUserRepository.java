package com.revature.project0.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project0.database.DbConnectionFactory;
import com.revature.project0.repository.UserRepository;
import com.revature.project0.entity.User;

public class JdbcToUserRepository implements UserRepository {
	Connection conn ;
	@Override
	public List<User> findUser(String column,int value) {
		List<User> list = new ArrayList<>();
		
		try {
			conn = DbConnectionFactory.getConnection();
			
			String findQuery="select * from users where "+column+"="+value;
			PreparedStatement ps = conn.prepareStatement(findQuery);
//			ps.setString(1, column);
//			ps.setInt(1, value);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User user = new User(rs.getInt("id"),rs.getString("userName"),rs.getInt("accNo"),rs.getInt("accBal"));
				user.setAccNo(rs.getInt("accNo"));
				user.setName(rs.getString("userName"));
				user.setAccBal(rs.getInt("accBal"));
				list.add(user);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
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
	public List<User> findByMobile(int mobile){
		
		return findUser("mobile",mobile);
		
	}
	
	
	@Override
	public List<User> findByAccNo(int accNo){
		return findUser("accNo",accNo);
	}
		
	
	// create  a new user in database

	@Override
	public List<User> createUser(String name,int mobile){
		
		List<User> list = new ArrayList<>();
		try {
			conn = DbConnectionFactory.getConnection();
			
			int accNo=200*mobile;
			int accBal=5000;
			
			String insertQuery="insert into users (userName,accNo,accBal,mobile)"+ "values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(insertQuery);
			ps.setString(1, name);
			ps.setInt(2, accNo);
			ps.setInt(3, accBal);
			ps.setInt(4, mobile);
			
			ps.executeUpdate(insertQuery);
			
			System.out.println("Account created succesfully");
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		findByMobile(mobile);
		
		return list;
		
		
	}
}
	
		
	
	

