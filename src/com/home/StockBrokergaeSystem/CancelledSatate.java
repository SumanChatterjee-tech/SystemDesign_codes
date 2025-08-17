package com.home.StockBrokergaeSystem;

public class CancelledSatate implements OrderState {

	@Override
	public void handle(Order order) {
		System.out.println("Order is cancelled.");
	}

	@Override
	public void cancel(Order order) {
		System.out.println("Order is already cancelled.");
	}
}
