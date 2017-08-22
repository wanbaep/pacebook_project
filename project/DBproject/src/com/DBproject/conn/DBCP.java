package com.DBproject.conn;

import java.sql.*;

public class DBCP {
	
	private static DBCP instance = new DBCP();
	
	String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost/facebook";	
    String dbid = "root";
    String upw = "1234";
    
	
	private DBCP(){
    	try {
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
    }
	
	public static DBCP getInstance(){
		if(instance==null)
		{
			instance=new DBCP();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, dbid, upw);
	}
}
