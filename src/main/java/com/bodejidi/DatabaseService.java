package com.bodejidi;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Date;
import java.sql.PreparedStatement;

public class DatabaseService
{
	static final Logger logger = LoggerFactory.getLogger(DatabaseService.class);
	static final String jdbcURL = "jdbc:mysql://localhost/test?user=root&password=";
		
	static final String jdbcDriver = "com.mysql.jdbc.Driver";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private int parameterIndex;

	private static Connection createConnection () throws SQLException
	{
		try
		{
			Class.forName(jdbcDriver).newInstance();
		}
		catch(Exception e)
		{
			
		}

		return DriverManager.getConnection(jdbcURL);
	}
	public static DatabaseService newInstance() 
	{
		DatabaseService databaseService = new DatabaseService();

		try
		{
			databaseService.conn = 	DatabaseService.createConnection();	
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
		logger.trace("Set parameter value  " + parameterIndex + "  "+  param );
		parameterIndex ++;
		return this;
	}
	public DatabaseService setLong(Long param) throws SQLException
	{
		pstmt.setLong(parameterIndex, param);
		logger.trace("Set parameter value  " + parameterIndex + "  "+  param );
		parameterIndex++;
		return this;
	}
	public DatabaseService setDate() throws SQLException
	{
		Date date = new Date();
		pstmt.setDate(parameterIndex, new java.sql.Date(date.getTime()));
		logger.trace("Set parameter value  " + date.getTime());
		parameterIndex++;
		return this;
	}
	public void execute() throws SQLException
	{
		pstmt.executeUpdate();
		logger.debug("Set parameter value  " );
		
	}

	public void close()
	{
		close(pstmt);
		pstmt = null;

		close(conn);
		conn = null;
	}
	public void close(AutoCloseable obj)
	{
		if(obj != null)
		{
			try
			{
				obj.close();
			}
			catch(Exception e)
			{
				logger.debug("Set parameter value  " + e );
			}
		}
		
	}



}
