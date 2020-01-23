package com.jsp.ust;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class JDBC1 {
public static void main(String[] args) {
	Connection con;
	int b;
	int choise;
	//int count=1;
	Scanner sc=new Scanner(System.in);
	
	 try {
		
		 Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver loaded");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");
		
	System.out.println("get connection");
	System.out.println("Platform is created.....");
	PreparedStatement pst=con.prepareStatement("insert into stud values(?,?,?,?,?,?,?)");
	/*Statement st=con.createStatement(); 
	st.executeUpdate("Alter table test ADD UNIQUE(contactno)");
	st.executeUpdate("Alter table test ADD UNIQUE(email)");*/

	System.out.println("enter 1 for data insertion ");
	System.out.println("enter 2 for fetch the data");
	
	choise=sc.nextInt();
	
	switch(choise){
	case 1: 
		do{
	System.out.println("enter id");
	int id =sc.nextInt();
	System.out.println("Enter your name: ");
	String name=sc.next();
	sc.nextLine();
	System.out.println("Enter your stream: ");
	String stream=sc.next();
	System.out.println("Enter your yop: ");
	int yop=sc.nextInt();
	System.out.println("Enter your date of birth: ");
	String dob=sc.next();
	sc.nextLine();
	System.out.println("Enter your contact no: ");
	String contactno=sc.next();
	if(contactno.length()!=10){
		System.out.println("invalid contact no.");
		
		}
	System.out.println("Enter your email id: ");

	String email=sc.next();
	if(email.contains("@") && email.contains(".com")){
		pst.setString(7, email);
		
	}
	else{
		for(;;){
			System.out.println("enter valid email id");
			email=sc.next();
			
			if(email.contains("@") && email.contains(".com")){
				pst.setString(7, email);
				break;
			}
		}
		
	}
	pst.setInt(1, id);
	pst.setString(2,name);
	pst.setString(3, stream);
	pst.setInt(4,yop);
	pst.setString(5,dob);
	pst.setString(6,contactno);
	
	pst.execute();
	System.out.println("data inserted Successfully.......");
	System.out.println("Enter y for more details ");
	System.out.println("enter n for other process");
	
	b=sc.next().charAt(0);
	}while(b=='y'||b=='Y');
		break;
	case 2: 
		System.out.println("FOR validation");
		System.out.println("enter id ");
		int id=sc.nextInt();
		System.out.println("Enter your name");
		String name=sc.next();
		
		PreparedStatement ps1=con.prepareStatement("select * from stud where id=? and name=?");
		ps1.setInt(1, id);
		ps1.setString(2, name);
		ps1.execute();
		ResultSet rs=ps1.executeQuery();
		if(rs.next()){
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			
		}
		else{
			System.out.println("no record found");
			for(;;){
					System.out.println("enter id");
					id=sc.nextInt();
					
					ps1.setInt(1, id);
					System.out.println("enter name");
					
					name=sc.next();
					ps1.setString(2, name);
					rs=ps1.executeQuery();
					if(rs.next()){
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
						
					}
				}
			}
			
			
		
			break;
			default : System.out.println("program ends");
	}
	

}
catch(MySQLIntegrityConstraintViolationException e){
	System.out.println("contact already exists");
	
		System.out.println("enter valid contactno");

		
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



	
