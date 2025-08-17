package com.home.StockBrokergaeSystem;

public class User implements StockObserver{

	String userId;
	String name;
	Account account;
	
	public User(String name, double initialBalance) {
		this.name = name;
		this.account = new Account(initialBalance);
	}
	
	

	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}



	@Override
	public void update(Stock stock) {
		System.out.printf("[Notification for %s] Stock %s price updated to: $%.2f%n",
                name, stock.getName(), stock.getPrice());		
	}
	
	
}
