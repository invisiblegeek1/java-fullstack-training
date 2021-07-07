package com.revature.project0.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnectionFactory {

//	private static Properties props = new Properties();
	
//	static {
//		try {
//			FileInputStream fis = new FileInputStream("/resources/db.properties");
//			props.load(fis);
//			fis.close();
//		}catch(FileNotFoundException e) {
//			e.printStackTrace();
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	static{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		
	}
	public static Connection getConnection() throws SQLException{
		
		String url = "jdbc:mysql://localhost:3306/project0";
		String userName = "root";
		String password = "Moorthy45$";
		Connection conn = DriverManager.getConnection(url,userName,password);
		
		return conn;
		
		
	}
	
}

