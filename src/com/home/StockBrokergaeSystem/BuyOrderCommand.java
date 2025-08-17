package com.home.StockBrokergaeSystem;

public class BuyOrderCommand implements OrderCommand{

	Account account;
	Order order;
	StockExchange exchange;
	
	public BuyOrderCommand(Account account, Order order) {
		super();
		this.account = account;
		this.order = order;
		this.exchange = new StockExchange();
	}

	@Override
	public void execute() {
		this.exchange.placeBuyOrder(order);
	}

}
