package com.home.Uber_Ola_Design_Advance;

import java.util.UUID;

public class Driver {

	private String id;
	private String name;
	private String contact;
    private final String licensePlate;
    private String  currLocation;
    private DriverStatus status;
    private Ride currentTrip;
    
	public Driver(String name, String contact, String licensePlate, String currLocation) {
		super();
		this.name = name;
		this.id = UUID.randomUUID().toString();
		this.contact = contact;
		this.licensePlate = licensePlate;
		this.currLocation = currLocation;
		this.status = DriverStatus.AVAILABLE;
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getCurrLocation() {
		return currLocation;
	}

	public void setCurrLocation(String currLocation) {
		this.currLocation = currLocation;
	}

	public DriverStatus getStatus() {
		return status;
	}

	public void setStatus(DriverStatus status) {
		this.status = status;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public Ride getCurrentTrip() {
		return currentTrip;
	}
	
	public synchronized void assignTrip(Ride ride) {
		if(this.status == DriverStatus.AVAILABLE) {
			this.status = DriverStatus.ON_A_TRIP;
			this.currentTrip = ride;
		}
	}
	
	public synchronized void completeTrip(Ride ride) {
		if(this.status == DriverStatus.ON_A_TRIP) {
			this.status = DriverStatus.AVAILABLE;
			this.currentTrip = null;
		}
	}
}
