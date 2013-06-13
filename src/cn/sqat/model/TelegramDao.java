package cn.sqat.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.sqat.util.ConnectionManager;

public class TelegramDao {

	static Connection currentCon = null;
	static ResultSet rs = null;
	public static TelegramBean submit(TelegramBean bean)
	{
		Statement stmt = null;

		//connecting to the DB
		currentCon = ConnectionManager.getConnection();
		try {
			stmt=currentCon.createStatement();
			ResultSet rs = stmt.executeQuery("select * from report where month like '"+bean.getDate().substring(0,7)+"%' " +
					"and salesperson="+bean.getId()+"");

			boolean reportExists = rs.next();
			if (reportExists){
				throw new IllegalStateException();
			}
			

		} catch (SQLException e) {
			System.out.println("DB failed: An Exception has occurred! " + e);
		}

		int id = bean.getId();
		int town = bean.getTown();
		int locks = bean.getLocks();
		int stocks = bean.getStocks();
		int barrels = bean.getBarrels();
		String date = bean.getDate();

		String insertQuery = "insert into sale (salesperson, town, item, date, quantity) values "+
				"("+id+","+town+",1,'"+date+"',"+locks+"),"+
				"("+id+","+town+",2,'"+date+"',"+stocks+"),"+
				"("+id+","+town+",3,'"+date+"',"+barrels+");";

		try{
			stmt=currentCon.createStatement();
			if(!stmt.execute(insertQuery)){
				System.out.println("Insert completed");
				System.out.println("Rows updated: "+stmt.getUpdateCount());
			}else{
				System.out.println("Insert failed");
			}

		}
		catch (Exception ex){
			System.out.println("DB failed: An Exception has occurred! " + ex);
		}
		return bean;
	}
}
