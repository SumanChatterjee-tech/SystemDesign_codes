package com.home.StockBrokergaeSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Account {

	double balance;
	Map<String, Integer> portfolio; //stock name and quantity
	
	public Account(double intitalCash) {
		this.balance = intitalCash;
		this.portfolio = new ConcurrentHashMap<>();
	}
	
	public synchronized void debit(double amount) {
		if(balance < amount) {
			//throw exception
		}
		balance =- amount;
	}
	
	public synchronized void credit(double amount) {
		balance+=amount;
	}
	
	public synchronized void adStock(String name, int quantity) {
		int currentQuantity = portfolio.getOrDefault(name, 0);
		int totalQuantity = currentQuantity + quantity;
		portfolio.put(name, totalQuantity);
	}
	
	public synchronized void removeStock(String name, int quantity) {
		int currentQuantity = portfolio.get(name);
		if(currentQuantity < quantity) {
			//cant sell throw exception
		}
		portfolio.put(name, currentQuantity-quantity);
	}
	
	public double getBalance() {return balance;}
	public Map<String, Integer> getPortfolio() {return Map.copyOf(portfolio);}
}
