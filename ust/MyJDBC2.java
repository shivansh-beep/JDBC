package com.jsp.ust;

//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyJDBC2 {

	public static void main(String[] args) {
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("1st step loading is done");
				
				
			// Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
				/*
				final String url="jdbc:mysql://localhost:3306";
				final String user="root";
				final String password="root";
				Connection con= DriverManager.getConnection(url, user, password);
				*/
				FileReader file=new FileReader("config/db.properties");
					Properties pr = new Properties();
					pr.load(file);
					DriverManager.getConnection("jdbc:mysql://localhost:3306", pr);
				System.out.println("2nd step stablish connection is done");
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
	}
		 catch(FileNotFoundException e){
			 e.printStackTrace();
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 }
		 }


