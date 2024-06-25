package com.home.ParkingLotDesign;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<ParkingSpot> spots = new ArrayList<>();
        for (int i = 1; i <= 100; ++i) {
           if(i%2 ==0) {
        	   spots.add(new TwoWheelSpot(i, true, null, 20));
           }else {
        	   spots.add(new FourWheelSpot(i, true, null, 40));
           }
        }
        ParkingManagerFactory parkingFactory = new ParkingManagerFactory();
        EntryGate entry = new EntryGate(parkingFactory);
        ExitGate exitGate = new ExitGate(parkingFactory);
        
        //entry of a vehicle
        Vehicle v = new Vehicle(999, VechicleType.TWO_WHEEL);
        ParkingSpot p = entry.findParkingSpace(v.getVt(), spots);
        p.setEmpty(false);
        Ticket ticket = entry.generateTicket(v, p);
        
        //exit
        exitGate.removeVehicle(ticket);
	}

}
