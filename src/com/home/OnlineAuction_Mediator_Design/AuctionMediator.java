package com.home.OnlineAuction_Mediator_Design;

public interface AuctionMediator {
	public void addBidder(Colleauge bidder);
	public void bidPlaced(String name,  int amt);
}
