package com.jsp.ust;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestDemo {

	public static void main(String[] args) {
		char b;
		int choice;
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class is load and Register......");
			System.out.println();
			System.out.println("Connection established.........");
			System.out.println();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ust?user=root&password=shivam");
			Statement st=con.createStatement(); 
			st.executeUpdate("Alter table test ADD UNIQUE(contactno)");
			st.executeUpdate("Alter table test ADD UNIQUE(email)");
			System.out.println("update account....");
			PreparedStatement pst=con.prepareStatement("insert into test values(?,?,?,?,?,?,?)");  
	     	System.out.println("Platform is created.....");                                        
				                                                     
			
			System.out.println("Enter your choice: 1 signup(insertion)...2 2.login(fetching)...." );
			choice=sc.nextInt();
			switch (choice){
			case 1:	

			do{
			System.out.println("Enter id....");
			int id=sc.nextInt();
			System.out.println("Enter your name: ");
			String name=sc.next();
			sc.nextLine();
			System.out.println("Enter your stream: ");
			String stream=sc.next();
			System.out.println("Enter your passing year: ");
			int yop=sc.nextInt();
			System.out.println("Enter your date of birth(year/month/date): ");
			String dob=sc.next();
			sc.nextLine();
			System.out.println("Enter your contact n0: ");
			long contactno=sc.nextLong();
			String str=String.valueOf(contactno);
			if(str.length()==10){
				contactno=Long.parseLong(str);
			}else{
				System.out.println("wrong contact no....");
				System.out.println("Enter contact no again....");
				 contactno=sc.nextLong();
			}
			
			System.out.println("Enter your email id: ");
			String email=sc.next();
			pst.setInt(1, id);
			pst.setString(2,name);
			
			pst.setString(3, stream);
			pst.setInt(4,yop);
			pst.setString(5,dob);
			pst.setLong(6,contactno);
			if(email.contains("@")&& email.contains(".com")){
				pst.setString(7, email);
			}
			else{
				for(;;){
					System.out.println("enter valid email id... ");
					System.out.println("Enter email again...");
					email=sc.next();
					if(email.contains("@")&& email.contains(".com")){
						pst.setString(7,email);
						break;
					}
				}
			}
			pst.execute();
			System.out.println("data inserted Successfully.......");
			System.out.println("Enter y for more details and n for furthur process ");
			System.out.println(" ");
			b=sc.next().charAt(0);
			}while(b=='Y'||b=='y');	
	break;
	
			case 2:PreparedStatement pst1=con.prepareStatement("Select * from test where id=? and name=?");
			System.out.println("Enter id:");
			int id=sc.nextInt();
			pst1.setInt(1,id);
			System.out.println("Enter name");
			String name=sc.next();
			pst1.setString(2,name);
			ResultSet rs=pst1.executeQuery();
			if(rs.next()){
			System.out.println("id :="+rs.getInt(1)+" "+"name:="+rs.getString(2)+" "+"Stream:="+rs.getString(3)+" "+"yop:="+rs.getInt(4)+" "+"dob:="+rs.getString(5)+" "+"contactno:="+rs.getLong(6)+" "+"email:="+rs.getString(7));
			}else{
				System.out.println("invalid details");
				for(;;){
					System.out.println("enter id");
					id=sc.nextInt();
					pst1.setInt(1, id);
					System.out.println("Enter name:");
					name=sc.next();
					pst1.setString(2, name);
					rs=pst1.executeQuery();
					if(rs.next()){
						System.out.println("id :="+rs.getInt(1)+" "+"name:="+rs.getString(2)+" "+"Stream:="+rs.getString(3)+" "+"yop:="+rs.getInt(4)+" "+"dob:="+rs.getString(5)+" "+"contactno:="+rs.getLong(6)+" "+"email:="+rs.getString(7));
					}
					break;
				}				}
			
			default : System.out.println("program end");
			break;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Duplicate phone no or Email id......");
		}

	}


}



