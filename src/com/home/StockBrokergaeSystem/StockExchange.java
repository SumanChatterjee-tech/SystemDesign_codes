package com.home.StockBrokergaeSystem;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class StockExchange {

	Map<String, List<Order>> buyOrders;
	Map<String, List<Order>> sellOrders;
	
	public StockExchange() {
		this.buyOrders = new ConcurrentHashMap<>();
		this.sellOrders = new ConcurrentHashMap<>();
	}
	
	public void placeBuyOrder(Order order) {
		buyOrders.computeIfAbsent(order.getStock().getName(), k-> new CopyOnWriteArrayList<>()).add(order);
		//matchOrders(order.getStock()); it will match the order and trade, its a black box for me
	}
	
	public void placeSellOrder(Order order) {
		sellOrders.computeIfAbsent(order.getStock().getName(), k-> new CopyOnWriteArrayList<>()).add(order);
		//matchOrders(order.getStock()); it will match the order and trade, its a black box for me
	}
}
