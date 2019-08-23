package com.collabera.jdbc;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteStatement2
{
	static final String URL = "jdbc:mysql://localhost:3306/sakila";
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
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM actor";
			ResultSet rs = statement.executeQuery(query);
			rs.absolute(5);
			
			String firstName = rs.getString("first_name");
			int actorID = rs.getInt(1);
			
			System.out.println("ID: " + actorID + " Name: " + firstName);
			
			while(rs.next())
			{
				firstName = rs.getString("first_name");
				actorID = rs.getInt(1);
				System.out.println("ID: " + actorID + " Name: " + firstName);
			}
			
			
			conn.close();
			System.out.println("Connection Closed");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}