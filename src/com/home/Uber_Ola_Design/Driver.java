package com.home.Uber_Ola_Design;

public class Driver {
	int id;
	String name;
	int rating;
	
	public Driver(int id, String name, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
	}
	
	public String getName() {
		return this.name;
	}
}
