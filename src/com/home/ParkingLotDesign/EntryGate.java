package com.home.ParkingLotDesign;

import java.util.List;

public class EntryGate {
	ParkingManagerFactory parkingManagerFactory;

	public EntryGate(ParkingManagerFactory parkingManagerFactory) {
		super();
		this.parkingManagerFactory = parkingManagerFactory;
	}

	ParkingSpot findParkingSpace(VechicleType vehicleType, List<ParkingSpot> spots) {
		ParkingSportManager manager = parkingManagerFactory.getParkingSpotManager(vehicleType, spots);
		return manager.findParkingSpace();
	}

	Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
		// Implementation to generate ticket
		return null;
	}
}
