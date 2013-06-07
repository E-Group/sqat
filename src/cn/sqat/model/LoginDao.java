package cn.sqat.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.sqat.util.ConnectionManager;

public class LoginDao{
	static Connection currentCon = null;
	static ResultSet rs = null;
	public static LoginBean login(LoginBean bean)
	{
		Statement stmt = null;
		String username = bean.getUsername();
		String password = bean.getPassword();
		String searchQuery = "select * from user u where u.name = '"+username+"' AND u.password = '"+password+"'";

		try
		{
			//connecting to the DB
			currentCon = ConnectionManager.getConnection();
			stmt=currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean userExists = rs.next();

			if (!userExists)
			{
				System.out.println("Username/Password entered is Incorrect or User doesnot Exists.");
				bean.setValid(false);
			}
			else if (userExists)
			{
//				String user = rs.getString("name");
				System.out.println("Welcome " + username);
//				bean.setUsername(firstName);
				bean.setValid(true);
				
				int id = rs.getInt("id");
				System.out.println("id: "+id);
				bean.setId(id);
				
			}

		}
		catch (Exception ex)
		{
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}
		return bean;
	}
}
