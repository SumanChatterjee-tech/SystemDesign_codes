package com.home.Uber_Ola_Design_Advance;

import java.util.List;

public abstract class DriverMatchingHandler {
	protected DriverMatchingHandler next;
	
	public void setNext(DriverMatchingHandler next) {
        this.next = next;
    }
	
	public List<Driver> filter(List<Driver> drivers, String fromLoc, String toLoc) {
        List<Driver> filteredDrivers = applyFilter(drivers, fromLoc, toLoc);
        if (next != null && !filteredDrivers.isEmpty()) {
            return next.filter(filteredDrivers, fromLoc, toLoc);
        }
        return filteredDrivers;
    }

    protected abstract List<Driver> applyFilter(List<Driver> drivers, String fromLoc, String toLoc);
}
