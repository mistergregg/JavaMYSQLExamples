package com.collabera.jdbc;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionSecurity
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
		Connection conn = ConnectionSecurity.getConnection();
		
		try
		{
			Statement state = conn.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Type name of city you looking for: ");
			
			String name = sc.nextLine();
			
			String query = String.format("SELECT * FROM city WHERE name = '%s'", name);
			
			//String query = String.format("SELECT * FROM city WHERE name = 'x' OR 'a' = 'a'");
			
			System.out.println(query);
			
			ResultSet rs = state.executeQuery(query);
			
			System.out.println(query);
			
			conn.close();
			System.out.println("Connection Closed");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}