package cn.sqat.model;

public class CommissionBean {

	private String name;
	private int gunsmith;
	private int	id;
	private int comId;
	private int salary;
	private String month;
	private int town;
	private int locks = 0;
	private int stocks = 0;
	private int barrels = 0;
	private int locksPrice;
	private int stocksPrice;
	private int barrelsPrice;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getLocks() {
		return locks;
	}
	public void setLocks(int locks) {
		this.locks = locks;
	}
	public int getStocks() {
		return stocks;
	}
	public void setStocks(int stocks) {
		this.stocks = stocks;
	}
	public int getBarrels() {
		return barrels;
	}
	public void setBarrels(int barrels) {
		this.barrels = barrels;
	}
	public int getGunsmith() {
		return gunsmith;
	}
	public void setGunsmith(int gunsmith) {
		this.gunsmith = gunsmith;
	}
	public int getLocksPrice() {
		return locksPrice;
	}
	public void setLocksPrice(int locksPrice) {
		this.locksPrice = locksPrice;
	}
	public int getStocksPrice() {
		return stocksPrice;
	}
	public void setStocksPrice(int stocksPrice) {
		this.stocksPrice = stocksPrice;
	}
	public int getBarrelsPrice() {
		return barrelsPrice;
	}
	public void setBarrelsPrice(int barrelsPrice) {
		this.barrelsPrice = barrelsPrice;
	}
	public int getTown() {
		return town;
	}
	public void setTown(int town) {
		this.town = town;
	}
	public int getComId() {
		return comId;
	}
	public void setComId(int comId) {
		this.comId = comId;
	}

}
