package com.home.Uber_Ola_Design;

import java.util.Date;

public class Trip {

	Rider rider;
	Driver driver;
	String source;
	String dest;
	int tripId;
	Date date;
	int price;
	
	public Trip(Rider rider, Driver driver, String source, String dest, int tripId, Date date, int price) {
		super();
		this.rider = rider;
		this.driver = driver;
		this.source = source;
		this.dest = dest;
		this.tripId = tripId;
		this.date = date;
		this.price = price;
	}
}
