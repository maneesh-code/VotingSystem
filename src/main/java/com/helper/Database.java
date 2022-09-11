package com.helper;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	
	public static void main(String[] args) {
		
	}
	
	public String databasestring() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection obj=DriverManager.getConnection("jdbc:mysql://localhost/votersystem","root","admin@123");
			String  con = obj;
			return con;
	
			}
		catch(Exception e){ System.out.println(e);} 
		
	}
	  
}
