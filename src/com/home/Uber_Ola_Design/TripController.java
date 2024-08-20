package com.home.Uber_Ola_Design;

import java.util.List;

public class TripController {

	List<Trip> tripList;

	public TripController(List<Trip> tripList) {
		super();
		this.tripList = tripList;
	}

	public void addTrip(Trip trip){
		tripList.add(trip);
	}

	//remove user
	public void removeTrip(Trip trip){
		tripList.remove(trip);
	}

	//get particular user
	public Trip getTrip(int tripId){
		for(Trip trip : tripList){
			if(trip.tripId == tripId){
				return trip;
			}
		}
		return null;
	}
}
