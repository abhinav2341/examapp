package com.util;
import java.sql.Connection;
import java.sql.DriverManager;
public final class DB_utility
{
	private static final String Connection= null;
	static Connection connection=null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Problem in registering driver");
			e.printStackTrace();
		}
	}
	public static Connection getDBConnection()
	{
		try
		{
			if(Connection == null || connection.isClosed())
			{
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_app","root","root"); 
				
				return connection;
			}
			else {
				return connection;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}