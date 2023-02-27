package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	static Connection getDatabaseConnection() {
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=CustomerDetails;encrept=true;trustServerCertificate=true";
		String userName = "sa";
		String password = "Admin@123";
		Connection conn = null;
		
		try {
		
			conn=DriverManager.getConnection(url, userName, password);
			System.out.println("Connection created successfully..\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;

		
	}

}
