package com.home.StockBrokergaeSystem;

public class Order {

	String orderId;
	User user;
	Stock stock;
	OrderType type;
	int quantity;
	double price;
	OrderStatus status;
	OrderState currentSate;
	ExecutionStrategy executionStrategy;
	public Order(String orderId, User user, Stock stock, OrderType type, int quantity, double price,
			OrderState currentSate, ExecutionStrategy executionStrategy) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.stock = stock;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
		this.status = OrderStatus.OPEN;
		this.currentSate = new OpenState();
		this.executionStrategy = executionStrategy;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public OrderType getType() {
		return type;
	}
	public void setType(OrderType type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public OrderState getCurrentSate() {
		return currentSate;
	}
	public void setCurrentSate(OrderState currentSate) {
		this.currentSate = currentSate;
	}
	public ExecutionStrategy getExecutionStrategy() {
		return executionStrategy;
	}
	public void setExecutionStrategy(ExecutionStrategy executionStrategy) {
		this.executionStrategy = executionStrategy;
	}
	
	public void cancel() {
		this.status = OrderStatus.CANCELLED;
	}
}
