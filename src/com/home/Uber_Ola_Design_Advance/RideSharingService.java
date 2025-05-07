package com.home.Uber_Ola_Design_Advance;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RideSharingService {

	private Map<String, Passernger> passengers;
	private Map<String, Driver> drivers;
	private Map<String, Ride> ride;

	public RideSharingService() {
		super();
		this.passengers = new ConcurrentHashMap<>();
		this.drivers = new ConcurrentHashMap<>();
		;
		this.ride = new ConcurrentHashMap<>();
		;
	}

	public Driver registerDriver(String name, String contact, String licensePlate, String location) {
		Driver driver = new Driver(name, contact, licensePlate, location);
		drivers.put(driver.getId(), driver);
		return driver;
	}

	public Passernger registerPassernger(String name, String contact) {
		Passernger passernger = new Passernger(name, contact);
		this.passengers.put(passernger.getId(), passernger);
		return passernger;
	}
	
	// Need to use Chain of responsibility in driver matching 
	//Payment mode matching using strategy
	// Notification using observer 
}
