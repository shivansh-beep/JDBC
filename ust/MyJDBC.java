 package com.jsp.ust;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class MyJDBC {

	public static void main(String[] args) {
			/* STATIC WAY:-
			 Driver d;
			try {
				d = new Driver();
				DriverManager.registerDriver(d);
				System.out.println("driver class load and register is done");
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
		
		
			//DYNAMIC WAY:-
			 try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver class loading and registering is done");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
			
	}

}
