package com.home.Uber_Ola_Design;

import java.util.List;

public class DriverController {

	List<Driver> driverList;

	public DriverController(List<Driver> driver) {
		super();
		this.driverList = driver;
	}
	
	 //add user
    public void addUser(Driver user){
    	driverList.add(user);
    }

    //remove user
    public void removeUser(Driver user){
    	driverList.remove(user);
    }

    //get particular user
    public Driver getUser(int userId){
        for(Driver driver : driverList){
            if(driver.id == userId){
                return driver;
            }
        }
        return null;
    }
}
