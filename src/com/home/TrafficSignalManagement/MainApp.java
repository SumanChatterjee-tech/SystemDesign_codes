package com.home.TrafficSignalManagement;

import java.util.Arrays;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrafficSignal ts1 = new TrafficSignal();
		TrafficSignal ts2 = new TrafficSignal();

		Road r1 = new Road("r1", ts1);
		Road r2 = new Road("r2", ts2);

		// Adding vehicles to the roads
		Vehicle car1 = new Vehicle("Car 1");
		Vehicle bike1 = new Vehicle("Bike 1");
		Vehicle car2 = new Vehicle("Car 2");
		r1.addVehicle(car1);
		r1.addVehicle(bike1);
		r2.addVehicle(car2);

		// Creating emergency vehicle detector
		TrafficController controller = new TrafficController(Arrays.asList(r1, r2));
		EmergencyVehicle detector1 = new EmergencyVehicle(controller, r1);
		EmergencyVehicle detector2 = new EmergencyVehicle(controller, r2);

		ts1.addObserver(detector1);
		ts2.addObserver(detector2);

		// Starting the traffic cycle
		controller.startSignalCycle();
	}

}
