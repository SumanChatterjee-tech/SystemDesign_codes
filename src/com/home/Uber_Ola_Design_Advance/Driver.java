package com.home.Uber_Ola_Design_Advance;

import java.util.UUID;

public class Driver implements Observer {

	private String id;
	private String name;
	private String contact;
	private final String licensePlate;
	private String currLocation;
	private DriverStatus status;
	private Ride currentTrip;
	private String rating;

	public Driver(String name, String contact, String licensePlate, String currLocation) {
		super();
		this.name = name;
		this.id = UUID.randomUUID().toString();
		this.contact = contact;
		this.licensePlate = licensePlate;
		this.currLocation = currLocation;
		this.status = DriverStatus.AVAILABLE;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
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
		if (this.status == DriverStatus.AVAILABLE) {
			this.status = DriverStatus.ON_A_TRIP;
			this.currentTrip = ride;
		}
	}

	public synchronized void completeTrip(Ride ride) {
		if (this.status == DriverStatus.ON_A_TRIP) {
			this.status = DriverStatus.AVAILABLE;
			this.currentTrip = null;
		}
	}

	@Override
	public void update(String message) {
		System.out.println(this.name+"-one new notifiction says "+message);
	}
}
