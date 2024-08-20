package com.home.Uber_Ola_Design;

import java.util.List;

public interface DrivingStrategy {

	Driver matchDriver(List<Driver> listOfDriver);
}
