package com.jsp.ust;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyJDBC1 {

	public static void main(String[] args) {
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("1st step loading is done");
				
				
			// Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
				final String url="jdbc:mysql://localhost:3306";
				final String user="root";
				final String password="root";
				Connection con= DriverManager.getConnection(url, user, password);
				System.out.println("2nd step stablish connection is done");
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}

}
