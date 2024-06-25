package com.home.ParkingLotDesign;

import java.util.List;

public abstract class ParkingSportManager {
	List<ParkingSpot> parkingSpot;

	public ParkingSportManager(List<ParkingSpot> parkingSpot) {
		super();
		this.parkingSpot = parkingSpot;
	}
	abstract ParkingSpot findParkingSpace();
	
	  void parkVehicle(Vehicle v) {
	        ParkingSpot spot = findParkingSpace();
	        spot.parkVehicle(v);
	    }

	    void removeVehicle(Vehicle v) {
	        for (ParkingSpot spot : parkingSpot) {
	            if (spot.getVehicle() != null && spot.getVehicle().equals(v)) {
	                spot.removeVehicle();
	                break;
	            }
	        }
	    }
}
