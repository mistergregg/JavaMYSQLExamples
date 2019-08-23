package com.collabera.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager
{
	static final String URL = "jdbc:mysql://localhost:3306/testdb";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	
	public static Connection getConnection()
	{
		Connection conn = null;
		
		try
		{
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection Opened");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args)
	{
		Connection conn = ConnectionManager.getConnection();
		
		try
		{
			conn.close();
			System.out.println("Connection Closed");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}