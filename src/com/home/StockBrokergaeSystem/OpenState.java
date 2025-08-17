package com.home.StockBrokergaeSystem;

public class OpenState implements OrderState{

	@Override
	public void handle(Order order) {
		System.out.println("order is currenrly open and waiting for execution");
		
	}

	@Override
	public void cancel(Order order) {
		order.setStatus(OrderStatus.CANCELLED.CANCELLED);
		order.setCurrentSate(new CancelledSatate());
		System.out.println("Order has been cancelled");
	}

}
