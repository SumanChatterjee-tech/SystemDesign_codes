package com.home.ParkingLotDesign;

public class ParkingSpot {
	private long id;
	private boolean isEmpty;
	private Vehicle vehicle;
	private int price;
	public ParkingSpot(long id, boolean isEmpty, Vehicle vehicle, int price) {
		super();
		this.id = id;
		this.isEmpty = true;
		this.vehicle = vehicle;
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	void parkVehicle(Vehicle v) {
		this.vehicle = v;
		this.isEmpty = false;
	}
	
	void removeVehicle() {
		this.vehicle = null;
		this.isEmpty=true;
	}
}
