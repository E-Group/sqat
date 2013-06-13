package cn.sqat.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.sqat.util.ConnectionManager;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


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

	/**
	 * Function that returns a list of beans from the report table
	 * @param id - The id of the user
	 * @param confirmed - True if the list should contain only the confirmed records,
	 * false if the list should contain only the unconfirmed values
	 * @return A list of report beans
	 */
	public static List<ReportBean> queryReports(Object id, boolean confirmed)
	{
		List<ReportBean> dataList = new ArrayList<ReportBean>(); 
		Statement stmt = null;
		try
		{
			currentCon = ConnectionManager.getConnection();
			stmt=currentCon.createStatement();

			if(confirmed){
				rs = stmt.executeQuery("SELECT * FROM report,salesperson,user WHERE " +
						"salesperson='"+id+"' AND " +
						"salesperson.id=report.salesperson AND salesperson.id=user.id AND salary IS NOT NULL ORDER BY month DESC;");
			}else{
				rs = stmt.executeQuery("SELECT * FROM report,salesperson,user WHERE " +
						"salesperson='"+id+"' AND " +
						"salesperson.id=report.salesperson AND salesperson.id=user.id AND salary IS NULL ORDER BY month DESC;");
			}
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

	public static List<CommissionBean> queryCommissions(int id)
	{
		List<CommissionBean> dataList = new ArrayList<CommissionBean>(); 
		Statement stmt = null;
		try
		{
			currentCon = ConnectionManager.getConnection();
			stmt=currentCon.createStatement();
			rs = stmt.executeQuery("SELECT * FROM salesperson JOIN user JOIN report JOIN sale JOIN item ON salesperson.id = user.id AND user.id = report.salesperson AND report.salesperson = sale.salesperson AND sale.item = item.id WHERE salesperson.gunsmith = 1 AND MONTH(report.month) = MONTH(sale.date) AND YEAR(report.month) = YEAR(sale.date) AND salary IS NULL Group by date, item.id Order by user.id, date;");


			String tempMonth = "";
			int	tempId = 0;
			CommissionBean cb = null;
			int comId = 1;
			while (rs.next()){

				if(!tempMonth.equals(rs.getString("month")) || tempId != rs.getInt("id")){
					cb = new CommissionBean();
					cb.setComId(comId);
					comId++;
					cb.setId(rs.getInt("salesperson.id"));
					cb.setName(rs.getString("user.name"));
					cb.setGunsmith(id);
					cb.setSalary(rs.getInt("salary")); // KOMMER VARA NULL;
					cb.setMonth(rs.getString("month"));
					cb.setTown(rs.getInt("town"));
					tempId = cb.getId();
					tempMonth= cb.getMonth();
					dataList.add(cb);
				}
				int itemId = rs.getInt("item.id");

				switch(itemId){
				case 1: cb.setLocks(cb.getLocks()+rs.getInt("quantity"));
				cb.setLocksPrice(rs.getInt("price"));
				System.out.println(cb.getLocks()+" Lock");
				break;
				case 2: cb.setStocks(cb.getStocks()+rs.getInt("quantity"));
				cb.setStocksPrice(rs.getInt("price"));
				System.out.println(cb.getStocks()+" Stock");
				break;
				case 3: cb.setBarrels(cb.getBarrels()+rs.getInt("quantity"));
				cb.setBarrelsPrice(rs.getInt("price"));
				System.out.println(cb.getBarrels() +" Barrels");
				break;

				}
				System.out.println(cb.getMonth());
			}
		}
		catch (Exception ex)
		{
			System.out.println("Query failed: An Exception has occurred! " + ex);
		}
		System.out.println("Done with SQL");
		return dataList;
	}

	public static ReportBean submitReport(ReportBean report) {
		if(report.getMonth().equals("-01")){
			report.setError("Please select a month.");
			return report;
		}
		
		Statement stmt = null;
		int salesId = report.getId();
		String month = report.getMonth();
		String insertQuery = "insert into report (salesperson, month) values "+
				"("+salesId+",'"+month+"');";
		String query = "SELECT * FROM sale WHERE date LIKE '"+report.getMonth().substring(0, 7)+"%' AND" +
				" salesperson = "+report.getId()+";";

		try
		{
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			rs = stmt.executeQuery(query);
			boolean saleExist = rs.next();

			if(saleExist){
				if(!stmt.execute(insertQuery)){
					System.out.println("Insert completed");
					System.out.println("Rows updated: "+stmt.getUpdateCount());
				}else{
					System.out.println("Insert failed");
				}
			}else{
				report.setError("You have no sales to report, please select another month.");
			}
		}
		catch (Exception ex)
		{
			System.out.println("DB failed: An Exception has occurred! " + ex);
			report.setError("Error in Database, please try again.");
			if(ex instanceof MySQLIntegrityConstraintViolationException){
				report.setError("A sales report already exist for "+report.getMonth().substring(0, 7)+", please" +
						" select another month.");
			}
		}
		return report;
	}

	public static CommissionBean submitCommission(CommissionBean comm) {
		Statement stmt = null;
		int salesId = comm.getId();
		String month = comm.getMonth();
		int salary = comm.getSalary();

		String update = "update report SET salary = "+salary+" WHERE " +
				"salesperson="+salesId+" AND month ='"+month+"';";

		try
		{
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			boolean saleExist = stmt.execute(update);

			if(saleExist){
				System.out.println("Insert completed");
				System.out.println("Rows updated: "+stmt.getUpdateCount());

			}
			else{
				System.out.println("Insert failed");
				//				report.setError("Something wrong in DB");
			}
		}
		catch (Exception ex)
		{
			System.out.println("DB failed: An Exception has occurred! " + ex);
		}
		return comm;
	}
}

