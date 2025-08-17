package com.home.StockBrokergaeSystem;

public interface OrderState {

	void handle(Order order);
	void cancel(Order order);
}
