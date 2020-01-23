 package com.jsp.ust;

import java.sql.*;

import com.mysql.jdbc.Driver;

public class MyJDBC3 {

	public static void main(String[] args) {
		/*try {
			Driver d=new Driver();
			Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("1step");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println();
			System.out.println("1step");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        try {
        	System.out.println("1step load and register ");
        	System.out.println("=========================");
        	System.out.println();
			Class.forName("com.mysql.jdbc.Driver");
			
			
			System.out.println("2step get connection");
			System.out.println("=========================");
			System.out.println();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");
			
			
			System.out.println("3 step update account");
			System.out.println("=========================");
			System.out.println();
			 PreparedStatement ps1=con.prepareStatement("update bankaccount set acBalance=acBalance+? where accNo=?");
			 	ps1.setDouble(1, 2000.00);
			 	ps1.setInt(2, 123);
			ps1.execute();
			System.out.println("1...alok's account is cradited with 2000");
			
			 PreparedStatement ps2=con.prepareStatement("update bankaccount set acBalance=acBalance-? where accNo=?");
			 PreparedStatement ps3=con.prepareStatement("select * from bankaccount");
			ps2.setDouble(1, 2000);
			ps2.setInt(2, 124);
			ps2.execute();
			System.out.println("2...karan's account is deducted by 2000");
			
				ResultSet rs=ps3.executeQuery();
				while(rs.next()){
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
					
				}
		}
     
        
        
        
        catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}
	
}