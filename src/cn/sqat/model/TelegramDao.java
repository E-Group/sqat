package cn.sqat.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.sqat.util.ConnectionManager;

public class TelegramDao {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static final int MAX_LOCKS = 70;
	static final int MAX_STOCKS = 80;
	static final int MAX_BARRELS = 90;

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
				throw new IllegalStateException("Specified month is already reported!<br>");
			}

		} catch (SQLException e) {
			System.out.println("DB failed: An Exception has occurred! " + e);
		}

		try{
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery("select * from sale where date like '"+bean.getDate().substring(0,7)+"%' and salesperson="+bean.getId()+";");
			int locks = 0;
			int stocks = 0;
			int barrels = 0;

			while (rs.next()){
				int item = rs.getInt("item");
				int quantity = rs.getInt("quantity");
				
				switch(item){
				case 1: locks += quantity; 
				break;
				case 2: stocks += quantity; 
				break;
				case 3: barrels += quantity; 
				break;
				}
			}
			StringBuilder str = new StringBuilder();
			
			if((bean.getLocks()+locks) > MAX_LOCKS){
//				throw new IllegalStateException("Too many locks inserted, you have "+(MAX_LOCKS-locks)+" left in your inventory for this month.");
				str.append("Too many locks inserted, you have "+(MAX_LOCKS-locks)+" left in your inventory for this month.<br>");
			}
			if ((bean.getStocks()+stocks) > MAX_STOCKS){
//				throw new IllegalStateException("Too many stocks inserted, you have "+(MAX_STOCKS-stocks)+" left in your inventory for this month.");
				str.append("Too many stocks inserted, you have "+(MAX_STOCKS-stocks)+" left in your inventory for this month.<br>");
			}
			if ((bean.getBarrels()+barrels) > MAX_BARRELS){
				str.append("Too many barrels inserted, you have "+(MAX_BARRELS-barrels)+" left in your inventory for this month.<br>");
//				throw new IllegalStateException("Too many barrels inserted, you have "+(MAX_BARRELS-barrels)+" left in your inventory for this month.");
			}
			
			if(!str.toString().isEmpty()){
				System.out.println(str.toString());
				throw new IllegalStateException(str.toString());
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
		
		try{
		currentCon.setAutoCommit(false);
		 
		if(locks > 0){
			stmt.addBatch("insert into sale (salesperson, town, item, date, quantity) values "+
					"("+id+","+town+",1,'"+date+"',"+locks+");");
		}
		if(stocks > 0){
			stmt.addBatch("insert into sale (salesperson, town, item, date, quantity) values "+
					"("+id+","+town+",2,'"+date+"',"+stocks+");");
		}
		if(barrels > 0) {
			stmt.addBatch("insert into sale (salesperson, town, item, date, quantity) values "+
					"("+id+","+town+",3,'"+date+"',"+barrels+");");
		}
		if(locks == 0 && stocks == 0 && barrels == 0){
			throw new IllegalStateException("You cannot send an empty telegram!<br>");
		}
			stmt.executeBatch();
			currentCon.commit();
		}
		catch (Exception ex){
			System.out.println("DB failed: An Exception has occurred! " + ex);
			throw new IllegalStateException("Telegram failed.<br>");
		}
		return bean;
	}
}
