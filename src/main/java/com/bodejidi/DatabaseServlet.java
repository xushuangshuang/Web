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
	private PreParedStatement pstmt = null;

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
	public DatabaseService prepare(String sql)throws SQLException
	{
		pstmt = conn.prepareStatement(sql);
		parameterIndex = 1;
		return this;
	}
	public DatabaseService setString(String param) throws SQLException
	{
		pstmt.setString(parameterIndex, param);
		parameterIndex++;
		return this;
	}
	public DatabaseService setLong(String param) throws SQLException
	{
		pstmt.setLong(parameterIndex, param);
		parameterIndex++;
		return this;
	}
	public DatabaseService setDate() throws SQLException
	{
		pstmt.setDate(parameterIndex, java.util.Date date);
		parameterIndex++;
		return this;
	}

	public void close()
	{
		close(rs);
		rs = null;

		close(pstmt);
		pstmt = null;

		close(conn);
		conn = null;
	}
	public void close(String obj)
	{
		if(obj != null)
		{
			obj.close();
		}
		catch(Exception e)
		{
		
		}
	}



}
