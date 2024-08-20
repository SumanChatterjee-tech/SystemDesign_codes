package com.home.Uber_Ola_Design;

import java.util.List;

public class Application {

	RiderController riderController;
	DriverController driverController;
	StrategyController strategyController;
	TripController tripController;
	
	public Application(List<Driver> driverList, List<Rider> riderList, List<Trip> trips) {
		riderController = new RiderController(riderList);
		driverController = new DriverController(driverList);
		strategyController = new StrategyController(driverList, null, null);
		tripController = new TripController(trips);
		
	}
	
	public void addRider(Rider rider) { //customer register
		this.riderController.addUser(rider);
	}
	public void addDriver(Driver driver) { // register all driver
		this.driverController.addUser(driver);
	}
	public void createTrip(Trip trip) { //customer requested for trip
		tripController.addTrip(trip);
	}
	public int getPrice(int tripId) { //show the price based upon trip requested
		Trip trip = tripController.getTrip(tripId);
		return strategyController.getPrice(trip,new PriceBasedOnRating());
	} 
	public Driver assignADriver() { // assign a driver and then we can send some notification
		return this.strategyController.getDriver(new Top5RatedDrivingStrategy());
	}
}
