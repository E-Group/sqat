package cn.sqat.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.sqat.util.ConnectionManager;

public class QueryDao {

	static Connection currentCon = null;
	static ResultSet rs = null;
	public static List<SaleBean> query(String query)
	{
		List<SaleBean> dataList = new ArrayList<SaleBean>(); 
		Statement stmt = null;
//		String searchQuery = "select * from user u where u.name = '"+username+"' AND u.password = '"+password+"'";
		
		try
		{
			//connecting to the DB
			currentCon = ConnectionManager.getConnection();
			stmt=currentCon.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next ()){
				//Add records into data list
				SaleBean sb = new SaleBean();
				sb.setId(rs.getInt("id"));
				sb.setSalesperson(rs.getInt("salesperson"));
				sb.setTown(rs.getInt("town"));
				sb.setDate(rs.getString("date"));
				sb.setQuantity(rs.getInt("quantity"));
				dataList.add(sb);
			}
			
//			boolean userExists = rs.next();
//			if (!userExists)
//			{
//			
//			}
//			else if (userExists)
//			{
//
//			}

		}
		catch (Exception ex)
		{
			System.out.println("Query failed: An Exception has occurred! " + ex);
		}
		return dataList;
	}
}

