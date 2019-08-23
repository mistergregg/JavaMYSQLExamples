package com.collabera.jdbc;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigFileEx
{
	static final String URL = "jdbc:mysql://localhost:3306/testdb";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	
	public static Connection getConnection() throws IOException
	{
		Connection conn = null;
		
		try
		{
			FileInputStream file = new FileInputStream("D:/JavaApps/JDBCExample/src/com/collabera/jdbc/config.txt");
			
			Properties props = new Properties();
			props.load(file);
			String url = (String) props.get("url");
			String userName = (String) props.get("user");
			String password = (String) props.get("password");
			
			file.close();
			System.out.println("File CLosed");
			
			
			
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Connection Opened");
            
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) throws IOException
	{
		Connection conn = ConfigFileEx.getConnection();
		
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