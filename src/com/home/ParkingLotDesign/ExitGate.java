package com.home.ParkingLotDesign;

import java.util.ArrayList;

public class ExitGate {
	  ParkingManagerFactory factory;

	    ExitGate(ParkingManagerFactory factory) {
	        this.factory = factory;
	    }

	    void removeVehicle(Ticket ticket) {
	        ParkingSportManager manager = factory.getParkingSpotManager(ticket.vehicle.getVt(), new ArrayList<>());
	        manager.removeVehicle(ticket.vehicle);
	    }
}
