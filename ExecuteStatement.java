package com.collabera.jdbc;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExecuteStatement
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
			Statement statement = conn.createStatement();
			
			boolean flag = statement.execute("select * from Jump_people");
			
			if(!flag)
			{
				System.out.println("Here are the rows" + statement.getUpdateCount());
			}
			
			int count = statement.executeUpdate("Insert into Jump_people(firstName,lastName) values ('#######', '########')");
            System.out.println("Row Inserted and now the count is  " + count);
            
            //-----Update
            count = statement.executeUpdate("Update Jump_people set firstName = '######' where firstName = '######'");
            System.out.println("Row Updated and now the count is  " + count);
            
            //-----delete
            count = statement.executeUpdate("Delete from Jump_people where firstName = '#######'");
            System.out.println("Row deleted and now the count is  " + count);
            
			conn.close();
			System.out.println("Connection Closed");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}