package com.client;

import java.util.Scanner;
import java.sql.*;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//    Scanner sc=new Scanner(System.in);
//    System.out.println("WELCOME TO HOTEL RESERVATION SYSTEM");
//    System.out.println("--------------------------------------------------------");
//    
//    
//    System.out.println("1.Customer");
//    System.out.println("2.Manager");
//    System.out.println("Enter the user Tye:");
//    int userType=sc.nextInt();
//    
//    switch(userType) {
//    case 1:
//    	System.out.println("1.Book Room");
//    	System.out.println("2.Manage Booking");
//    	System.out.println("3.Cancel Booking");
//    	System.out.println("4.View Booking");
//    	System.out.println("Enter the choice:");
//    	int choice=sc.nextInt();
//    	
//    	if(choice==1) {
//    		
//    	}
//    	else if(choice==2) {
//    		
//    	}
//    	else if(choice==3) {
//    		
//    	}
//    	else if(choice==4) {
//    		
//    	}
//   
//    	
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    }
    
    try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservationsystem","root","");
    	Statement st=con.createStatement();
    	ResultSet rs=st.executeQuery("select * from room");
    	while(rs.next()) {
    		System.out.println(rs.getInt(1)+rs.getString(2));
    	}
    }
    catch(Exception e) {
    	System.out.println(e.toString());
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	}

}
