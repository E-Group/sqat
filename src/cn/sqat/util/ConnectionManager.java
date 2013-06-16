package cn.sqat.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionManager
{
	static Connection conn;

	public static Connection getConnection()
	{
		Properties prop = new Properties();

		try {
			//load a properties file
			//prop.load(new FileInputStream("/Commission/config.properties"));
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
			
			//get the property value and print it out
			//System.out.println(prop.getProperty("database"));
			//System.out.println(prop.getProperty("dbuser"));
			//System.out.println(prop.getProperty("dbpassword"));
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		try
		{

			Class.forName(Provider.DRIVER);
			try
			{
				String url = Provider.CONNECTION_URL;
				url += prop.getProperty("database");
				conn = DriverManager.getConnection(url, prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			}
			catch (SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		return conn;
	}

}