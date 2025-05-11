package com.home.Uber_Ola_Design_Advance;

import java.util.List;
import java.util.stream.Collectors;

public class ProximityDriverMatchingHandler extends DriverMatchingHandler {

	@Override
	protected List<Driver> applyFilter(List<Driver> drivers, String fromLoc, String toLoc) {
		return drivers.stream()
	            .filter(driver -> Math.abs(Integer.parseInt(driver.getCurrLocation())-Integer.parseInt(toLoc)) < 0.5) // within 5 km
	            .collect(Collectors.toList());
	}

}
