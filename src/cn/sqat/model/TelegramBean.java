package cn.sqat.model;

public class TelegramBean {

	private int town,locks,stocks,barrels,id;
	private String date;

	public int getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = Integer.parseInt(town);
	}
	
	public int getId() {
		return id;
	}

	public void setId(String id) {
		this.id = Integer.parseInt(id);;
	}

	public int getLocks() {
		return locks;
	}

	public void setLocks(String locks) {
		this.locks = Integer.parseInt(locks);;
	}
	
	public int getStocks() {
		return stocks;
	}

	public void setStocks(String stocks) {
		this.stocks = Integer.parseInt(stocks);;
	}
	
	public int getBarrels() {
		return barrels;
	}

	public void setBarrels(String barrels) {
		this.barrels = Integer.parseInt(barrels);;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
