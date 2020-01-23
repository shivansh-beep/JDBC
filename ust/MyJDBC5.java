package com.jsp.ust;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBC5 {

	public static void main(String[] args) {
		   
	        	System.out.println("1step load and register ");
	        	System.out.println("=========================");
	        	System.out.println();
				try {
					Class.forName("com.mysql.jdbc.Driver");
				System.out.println("2step get connection");
				System.out.println("=========================");
				System.out.println();
				Connection con;
			
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");
			
				

 con.setAutoCommit(false);
 Statement st=con.createStatement();
 st.execute("update bankaccount set acBalance=acBalance+2000 where accNo=123");
 System.out.println("1 executed");
 
 st.execute("update bankaccount set acBalance=acBalance-2000 where accNo=124");
 System.out.println("2..executed");
 
 con.commit();
 System.out.println("data is commited");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   
	}

}
