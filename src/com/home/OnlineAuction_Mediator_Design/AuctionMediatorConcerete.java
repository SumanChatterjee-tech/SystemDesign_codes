package com.home.OnlineAuction_Mediator_Design;
import java.util.*;

public class AuctionMediatorConcerete implements AuctionMediator {

	static List<Colleauge> listOfColleague = new ArrayList<>();
	
	@Override
	public void addBidder(Colleauge bidder) {
		listOfColleague.add(bidder);
	}

	@Override
	public void bidPlaced(String name , int amt) {
		for(Colleauge c: listOfColleague) {
			if(c.getName() != name) {
				c.receivceNotification(amt, name);
			}
		}
	}

}
