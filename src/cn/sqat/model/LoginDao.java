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
				int id = rs.getInt("id");
				bean.setValid(true);
				bean.setId(id);
				
				stmt = currentCon.createStatement();
				rs = stmt.executeQuery("select * from gunsmith where id ="+bean.getId()+";");
				if (!rs.next() ) {
				    System.out.println("Salesperson");
				    /* Salesperson */
				    bean.setGunner(false);
				}
				else
					bean.setGunner(true);
			}
		}
		catch (Exception ex)
		{
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}
		return bean;
	}
}
