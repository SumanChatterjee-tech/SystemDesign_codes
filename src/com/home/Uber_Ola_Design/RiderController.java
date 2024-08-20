package com.home.Uber_Ola_Design;

import java.util.List;

public class RiderController {

	List<Rider> riderList;

	public RiderController(List<Rider> rider) {
		super();
		this.riderList = rider;
	}
	
	 //add user
    public void addUser(Rider user){
    	riderList.add(user);
    }

    //remove user
    public void removeUser(Rider user){
    	riderList.remove(user);
    }

    //get particular user
    public Rider getUser(int userId){
        for(Rider rider : riderList){
            if(rider.id == userId){
                return rider;
            }
        }
        return null;
    }
}
