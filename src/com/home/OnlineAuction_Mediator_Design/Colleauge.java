package com.home.OnlineAuction_Mediator_Design;

public interface Colleauge {
	public void placeBid(int amt);
	public void receivceNotification(int amt, String whoPlaced);
	String getName();
}
