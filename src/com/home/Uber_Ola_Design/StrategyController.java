package com.home.Uber_Ola_Design;

import java.util.List;

public class StrategyController {

	List<Driver> driverList;
	PricingStrategy pricingStrategy;
	DrivingStrategy driverStrategy;
	
	public StrategyController(List<Driver> driverList, PricingStrategy pricingStrategy,
			DrivingStrategy driverStrategy) {
		super();
		this.driverList = driverList;
		this.pricingStrategy = pricingStrategy;
		this.driverStrategy = driverStrategy;
	}
	
	public int getPrice(Trip tripDetails, PricingStrategy pricingStrategy) {
		this.pricingStrategy = pricingStrategy;
		return this.pricingStrategy.calculatePrice(tripDetails);
	}
	
	public Driver getDriver(DrivingStrategy driverStrategy) {
		this.driverStrategy = driverStrategy;
		return this.driverStrategy.matchDriver(this.driverList);
	}
}
