package com.home.Uber_Ola_Design;

import java.util.List;

public class Top5RatedDrivingStrategy implements DrivingStrategy {

	@Override
	public Driver matchDriver(List<Driver> listOfDriver) {
		return listOfDriver.get(0); //may be I will sort it based on ratings and based on the avaiulability I will asign
		//top rated driver
	}

}
