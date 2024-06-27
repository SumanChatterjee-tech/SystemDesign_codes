package com.home.RentalCarDesign;

import java.util.ArrayList;
import java.util.List;

public class Store {
	int id;
	Vehicle vehicle;
	Location location;
	List<Reservation> reservation = new ArrayList<>();
	
	//CRUD operations
	//store wise operations like, getVehicle, isVechileReserved etc.
	//completeTrip(Reservation id) //getReservation and mark complete for same store id
}
