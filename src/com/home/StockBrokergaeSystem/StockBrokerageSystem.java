package com.home.StockBrokergaeSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StockBrokerageSystem {

	Map<String, User> users;
	Map<String, Stock> stocks;

	public StockBrokerageSystem() {
		this.stocks = new ConcurrentHashMap<>();
		this.users = new ConcurrentHashMap<>();
	}

	public User registerUser(String name, double initialAmount) {
		User user = new User(name, initialAmount);
		users.put(user.getUserId(), user);
		return user;
	}

	public Stock addStock(String symbol, double initialPrice) {
		Stock stock = new Stock(symbol, initialPrice);
		stocks.put(stock.getName(), stock);
		return stock;
	}

	public void placeBuyOrder(Order order) {
		User user = order.getUser();
		OrderCommand command = new BuyOrderCommand(user.getAccount(), order);
		command.execute();
	}

	public void placeSellOrder(Order order) {
		User user = order.getUser();
		OrderCommand command = new SellOrderCommand(user.getAccount(), order);
		command.execute();
	}

	public void cancelOrder(Order order) {
		order.cancel();
	}
}
