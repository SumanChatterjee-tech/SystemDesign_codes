package com.home.RentalCarDesign;

import java.util.Date;

public class Bike extends Vehicle{

	public Bike(int vehicleID, int vehicleNumber, VehicleType vehicleType, String companyName, String modelName,
			int kmDriven, Date manufacturingDate, int average, int cc, int dailyRentalCost, int hourlyRentalCost,
			int noOfSeat, Status status) {
		super(vehicleID, vehicleNumber, vehicleType, companyName, modelName, kmDriven, manufacturingDate, average, cc,
				dailyRentalCost, hourlyRentalCost, noOfSeat, status);
		// TODO Auto-generated constructor stub
	}

}
