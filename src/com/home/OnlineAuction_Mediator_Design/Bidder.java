package com.home.OnlineAuction_Mediator_Design;

public class Bidder implements Colleauge {

	String name;
	AuctionMediator mediator;
	
	public Bidder(String name, AuctionMediator mediator) {
		super();
		this.name = name;
		this.mediator = mediator;
	}

	@Override
	public void placeBid(int amt) {
		mediator.bidPlaced(name, amt);
	}

	@Override
	public void receivceNotification(int amt, String whoPlaced) {
		System.out.println("A bid of amount "+ amt + " placed by "+ whoPlaced);

	}

	@Override
	public String getName() {
		return this.name;
	}

}
