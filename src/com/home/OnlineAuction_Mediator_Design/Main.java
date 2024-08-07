package com.home.OnlineAuction_Mediator_Design;

public class Main {

	public static void main(String[] args) {
		
		AuctionMediator ac = new AuctionMediatorConcerete();
		Colleauge b1 = new Bidder("Suman1", ac);
		Colleauge b2 = new Bidder("Suman2", ac);
		ac.addBidder(b1);
		ac.addBidder(b2);
		
		ac.bidPlaced("Suman1", 10);

	}

}
