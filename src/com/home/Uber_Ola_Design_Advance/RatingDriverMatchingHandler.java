package com.home.Uber_Ola_Design_Advance;

import java.util.List;
import java.util.stream.Collectors;

public class RatingDriverMatchingHandler extends DriverMatchingHandler{

	@Override
	protected List<Driver> applyFilter(List<Driver> drivers, String fromLoc, String toLoc) {
		return drivers.stream()
	            .filter(driver -> Integer.parseInt(driver.getRating()) >3.5) // greater than atleast 3.5
	            .collect(Collectors.toList());
	}

	
}
