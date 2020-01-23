package com.jsp.ust;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class MyJDBC4 {

	public static void main(String[] args) {
		   try {
	        	System.out.println("1step load and register ");
	        	System.out.println("=========================");
	        	System.out.println();
				Class.forName("com.mysql.jdbc.Driver");
				
				
				System.out.println("2step get connection");
				System.out.println("=========================");
				System.out.println();
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");
				

  con.setAutoCommit(false);
  Statement st=con.createStatement();
  st.execute("update bankaccount set acBalance=acBalance+2000 where accNo=123");
  System.out.println("1 executed");
  
  st.execute("update bankaccount set acBalance=acBalance-2000 where accNo=124");
  System.out.println("2..executed");
  
  con.commit();
  System.out.println("data is commited");
		   }
		   catch(Exception e){
		   e.printStackTrace();
		   }
	}
}
  
  
  
	
