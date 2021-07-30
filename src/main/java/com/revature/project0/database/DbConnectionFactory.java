package com.revature.project0.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnectionFactory {

	private static Properties props = new Properties();
	
	static {
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/db.properties");
			props.load(fis);
			fis.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//com.mysql.cj.jdbc.Driver
	static{
		try {
			
			Class.forName(props.getProperty("db.driver"));
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		
	}
	// Factory Method
	public static Connection getConnection() throws SQLException{
		
		String url = props.getProperty("db.url");
		String userName = props.getProperty("db.username");
		String password = props.getProperty("db.password");
		Connection conn = DriverManager.getConnection(url,userName,password);
		
		return conn;
		
		
	}
	
}

