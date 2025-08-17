package com.home.StockBrokergaeSystem;

public class SellOrderCommand implements OrderCommand{

	Account account;
	Order order;
	StockExchange exchange;
	
	public SellOrderCommand(Account account, Order order) {
		super();
		this.account = account;
		this.order = order;
		this.exchange = new StockExchange();
	}

	
	@Override
	public void execute() {
		this.exchange.placeSellOrder(order);
	}

}
