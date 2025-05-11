package com.home.Uber_Ola_Design_Advance;

import java.util.List;
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
		this.ride = new ConcurrentHashMap<>();
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
	
	public synchronized Ride requestRide(String passengerId, String fromLoc, String toLoc) {
		//Notify All Drivers
		List<Driver> drivers = getDriversBasedOnConditions(fromLoc, toLoc);
		//lets dtermine the fair and send notification
		double fare = paymentDeterminationStrategy(fromLoc, toLoc);
		notifyDrivers(fromLoc, toLoc, fare);
		
		Passernger p = this.passengers.get(passengerId);
		Ride ride = new Ride(null, p, fromLoc, toLoc);
		ride.setFare(fare);
		return ride;
	}
	
	private double paymentDeterminationStrategy(String fromLoc, String toLoc) {
		// TODO Auto-generated method stub
		//a dumy value, we can implement later
		return 50;
	}

	private void notifyDrivers(String fromLoc, String toLoc, double fare) {
		for(Map.Entry<String, Driver> map : this.drivers.entrySet()) {
			map.getValue().update("Would you like to accept this ride from "+ fromLoc + "to "+toLoc+" fare: "+ fare);
		}
		
	}

	private List<Driver> getDriversBasedOnConditions(String fromLoc, String toLoc) {
		DriverMatchingHandler driverMatchingHandler1 = new ProximityDriverMatchingHandler();
		DriverMatchingHandler driverMatchingHandler2 = new RatingDriverMatchingHandler();
		driverMatchingHandler1.setNext(driverMatchingHandler2);
		List<Driver> listOfDriver = (List<Driver>) this.drivers.values();
		return driverMatchingHandler1.applyFilter(listOfDriver, fromLoc, toLoc);
	}

	public void acceptRide(String driverId, Ride ride) {
		ride.setStatus(RideStatus.ACCEPTED);
		Driver driver = this.drivers.get(driverId);
		driver.setStatus(DriverStatus.ON_A_TRIP);
	}
	
	public void cancelTrip(String driverId, Ride ride) {
		Driver driver = this.drivers.get(driverId);
		if(driver.getStatus() == DriverStatus.ON_A_TRIP && ride.getStatus() == RideStatus.ONGOING) {
			driver.setStatus(DriverStatus.AVAILABLE);
			ride.setStatus(RideStatus.CANCELLED);
		}
	}
	
}
