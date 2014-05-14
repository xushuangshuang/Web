package com.bodejidi;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseServlet
{
	static final String jdbcURL = "jdbc:mysql://localhost/test?user=root&password=";
	static final String jdbcDriver = "com.mysql.jdbc.Driver";
	private Connection conn = null;

	public Connection creatConnection ()
	{
		try
		{
			Class.forName(jdbcDriver).newInstance();
		}
		catch(SQLException e)
		{
			
		}

		return DriverManager.getConnection(jdbcURL);
	}
	public DatabaseService newInstance()
	{
		DatabaseService databaseService = new DatabaseService();

		try
		{
			databaseService.conn = 	databaseservice.CreateConnection();	
		}
		catch(Exception e)
		{
		
		}
		return databaseService;
	}

}
