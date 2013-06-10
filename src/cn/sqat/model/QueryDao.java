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
	
	public static List<SalesPersonBean> querySalesPersons(String query)
	{
		List<SalesPersonBean> dataList = new ArrayList<SalesPersonBean>(); 
		Statement stmt = null;

		try
		{
			//connecting to the DB
			currentCon = ConnectionManager.getConnection();
			stmt=currentCon.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()){
				SalesPersonBean b = new SalesPersonBean();
				b.setId(rs.getInt("id"));
				b.setName(rs.getString("name"));
				dataList.add(b);
			}
		}
		catch (Exception ex)
		{
			System.out.println("Query failed: An Exception has occurred! " + ex);
		}
		return dataList;
	}

	
	public static List<TownBean> queryTowns(String query)
	{
		List<TownBean> dataList = new ArrayList<TownBean>(); 
		Statement stmt = null;

		try
		{
			//connecting to the DB
			currentCon = ConnectionManager.getConnection();
			stmt=currentCon.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()){
				TownBean tb = new TownBean();
				tb.setId(rs.getInt("id"));
				tb.setName(rs.getString("name"));
				dataList.add(tb);
			}
		}
		catch (Exception ex)
		{
			System.out.println("Query failed: An Exception has occurred! " + ex);
		}
		return dataList;
	}
	
	public static List<ItemBean> queryItems(String query)
	{
		List<ItemBean> dataList = new ArrayList<ItemBean>(); 
		Statement stmt = null;

		try
		{
			//connecting to the DB
			currentCon = ConnectionManager.getConnection();
			stmt=currentCon.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()){
				ItemBean ib = new ItemBean();
				ib.setId(rs.getInt("id"));
				ib.setName(rs.getString("name"));
				ib.setPrice(rs.getInt("price"));
				dataList.add(ib);
			}
		}
		catch (Exception ex)
		{
			System.out.println("Query failed: An Exception has occurred! " + ex);
		}
		return dataList;
	}

	public static List<SaleBean> querySales(String query)
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

			while (rs.next()){
				//Add records into data list
				SaleBean sb = new SaleBean();
				sb.setId(rs.getInt("id"));
				
				sb.setSalesperson(rs.getInt("salesperson"));
				sb.setTown(rs.getString("town.name"));
				sb.setItem(rs.getString("item.name"));
				
				sb.setDate(rs.getString("date"));
				sb.setQuantity(rs.getInt("quantity"));
				dataList.add(sb);
			}

		}
		catch (Exception ex)
		{
			System.out.println("Query failed: An Exception has occurred! " + ex);
		}
		return dataList;
	}
	
	public static List<ReportBean> queryReports(Object id)
	{
		List<ReportBean> dataList = new ArrayList<ReportBean>(); 
		Statement stmt = null;
		try
		{
			currentCon = ConnectionManager.getConnection();
			stmt=currentCon.createStatement();
			rs = stmt.executeQuery("SELECT * FROM report,salesperson,user WHERE " +
					"salesperson='"+id+"' AND " +
					"salesperson.id=report.salesperson AND salesperson.id=user.id ORDER BY month DESC;");
			while (rs.next()){
				//Add records into data list
				ReportBean rb = new ReportBean();
				rb.setSalesperson(rs.getString("user.name"));
				rb.setMonth(rs.getString("month"));
				rb.setSalary(rs.getInt("salary"));
				dataList.add(rb);
			}

		}
		catch (Exception ex)
		{
			System.out.println("Query failed: An Exception has occurred! " + ex);
		}
		return dataList;
	}
}

